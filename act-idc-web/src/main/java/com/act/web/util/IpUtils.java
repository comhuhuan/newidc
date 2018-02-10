package com.act.web.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * 提供ip和长整数long之间的转换方法，以及获取请求的ip地址
 * @author culven
 *
 */
public class IpUtils {
    
    private static final Logger logger = Logger.getLogger(IpUtils.class);

	/**
     * ip地址转成整数.
     * @param ip
     * @return
     */  
	public static long ipToLong(String ipString){
		long result = 0;
	    java.util.StringTokenizer token = new java.util.StringTokenizer(ipString,".");
	    result += Long.parseLong(token.nextToken())<<24;
	    result += Long.parseLong(token.nextToken())<<16;
	    result += Long.parseLong(token.nextToken())<<8;
	    result += Long.parseLong(token.nextToken());
	    return result;
	}
	
	/**
     * 整数转成ip地址.
     * @param ipLong
     * @return
     */ 
	public static String longToIp(long ipLong){
	     StringBuilder sb = new StringBuilder();
	     sb.append(ipLong>>>24);sb.append(".");
	     sb.append(String.valueOf((ipLong&0x00FFFFFF)>>>16));sb.append(".");
	     sb.append(String.valueOf((ipLong&0x0000FFFF)>>>8));sb.append(".");
	     sb.append(String.valueOf(ipLong&0x000000FF));
	     return sb.toString();
	}
	
	/**
	 * 获取ip地址
	 * @param request 请求实例
	 * @return IP Address
	 */
	public static String getIpAddrByRequest(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * 获取本机IP
	 * @return 本机IP
	 * @throws SocketException
	 */
	public static String getRealIp() throws SocketException {
		String localip = null;// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP

		Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		boolean finded = false;// 是否找到外网IP
		while (netInterfaces.hasMoreElements() && !finded) {
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> address = ni.getInetAddresses();
			while (address.hasMoreElements()) {
				ip = address.nextElement();
				if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
					netip = ip.getHostAddress();
					finded = true;
					break;
				} else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
					localip = ip.getHostAddress();
				}
			}
		}
	
		if (netip != null && !"".equals(netip)) {
			return netip;
		} else {
			return localip;
		}
	}
	/**
	 * 
	 * @Title: checkIP 
	 * @Description: 判断IP是否合法
	 * @param IP
	 * @return 格式正确返回true，否则false
	 * @return boolean
	 * @author Andrew 0666
	 * @date 2013-4-16 下午03:23:29 
	 * @modifier Andrew 0666
	 * @date 2013-4-16 下午03:23:29 
	 */
	public static boolean checkIP(String IP){
		java.util.regex.Pattern pattern = java.util.regex.Pattern
                .compile("^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$");
        return pattern.matcher(IP).matches();
	}
	
	/**
	 * 
	 * <b>功能：</b>通过第三方接口获取IP对应物理地址信息<br>
	 * <b>作者：</b>Zhangp<br>
	 * <b>日期：</b> 2013-11-15 <br>
	 * @param apiPath
	 * @return Json String
	 */
    public static String getIpInfo(String apiPath) {
        StringBuffer buffer = new StringBuffer();
        HttpURLConnection connection = null;

        try {
            URL url = new URL(apiPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
            connection.setReadTimeout(10000);//设置读取数据超时时间，单位毫秒
            connection.setUseCaches(false);// 是否缓存true|false
            connection.setRequestMethod("GET");

            // 获取返回状态码判断当前连接是否可用
            int responseCode = connection.getResponseCode();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader inStream = new InputStreamReader(connection.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(inStream);
                String inputline = "";

                while ((inputline = reader.readLine()) != null) {
                    buffer.append(inputline);
                }
                reader.close();
            } else {
                String responseMessage = connection.getResponseMessage();
                buffer.append("{'status':'-1','responseCode':'").append(responseCode);
                buffer.append("','responseMessage':'").append(responseMessage);
                buffer.append("'}");
            }
        } catch (MalformedURLException e) {
            buffer.append("{'status':'-1','responseCode':'500','responseMessage':'").append(e.getMessage()).append("'}");
            logger.error("getIpInfo method error", e);
        } catch (IOException e) {
            buffer.append("{'status':'-1','responseCode':'500','responseMessage':'").append(e.getMessage()).append("'}");
            logger.error("getIpInfo method error", e);
        } catch (Exception e) {
            buffer.append("{'status':'-1','responseCode':'500','responseMessage':'").append(e.getMessage()).append("'}");
            logger.error("getIpInfo method error", e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return buffer.toString();
    }  
	
}

