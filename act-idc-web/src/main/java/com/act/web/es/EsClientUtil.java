package com.act.web.es;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.act.framework.util.ConfigUtil;
import com.act.mapper.util.StringUtil;
import com.act.util.json.JacksonUtil;
import com.act.web.es.contant.EsContant;
import com.act.web.module.securitylog.controller.BaseDataMonitor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @Description es服务api
 * @author zhufj
 * @date 2018年1月27日 上午11:41:41
 *
 */
@Component
public class EsClientUtil {
	private final Logger log = LoggerFactory.getLogger(BaseDataMonitor.class);
	/**
	 * 
	 * @Description  去es中查询记录
	 * @author zhufj
	 * @param es_sql
	 * @return
	 */
	public String  getEsData(String es_sql){
		//通过apache_tomcat进行请求
		HttpGet request = new HttpGet(es_sql);//这里发送get请求
        HttpClient httpClient = new DefaultHttpClient();
        request.setHeader("Content-Type", "application/json;charset=utf-8");
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT,30000);//连接时间超时
        try {
        	//执行请求
			HttpResponse response = httpClient.execute(request);
			return IOUtils.toString(response.getEntity().getContent(),"UTF-8");
		} catch (ClientProtocolException e) {
			log.error("getEsData error:"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("getEsData error:"+e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 
	 * @Description 接受外部调用，返回分页（page）对象
	 * @author zhufj
	 * @param pageIndex 当前页
	 * @param pageSize 当前页大小
	 * @param sql 查询的sql
	 * @param type 查询的数据类型
	 * @return
	 */
	public EsEntity getEsEntity(int pageIndex,int pageSize, String sql,TypeReference type){
		//拼接sql参数
		StringBuffer es_url = new StringBuffer(ConfigUtil.getString("es.url"));
		StringBuffer sql_param = new StringBuffer(sql); 
		sql_param.append(" limit ").append(pageIndex).append(",").append(pageSize);
		try{
		es_url.append("?sql=").append(URLEncoder.encode(sql_param.toString(),"UTF-8"));
		}catch(Exception e){
			log.error("sql_param encode error:"+e.getMessage());
		}
		String rtnStr = getEsData(es_url.toString());
		Map<String,Object> map = parseEsRtn(rtnStr,type);
		String resultCode = map.get("resultCode").toString();
		//返回
		if(EsContant.ResultCode.rtnNull.getValue().equals(resultCode)||EsContant.ResultCode.rtnError.getValue().equals(resultCode)){
			return null;
		}else{
			EsEntity esEntity = (EsEntity)map.get("message");
			return esEntity;
		}
		
	}
	/**
	 * 
	 * <p>Title: getEsEntity
	 * <p>Description: 接受外部调用，响应对象
	 * @author zhufj
	 * @date 2018年2月5日 上午11:06:31
	 * @param sql
	 * @param type
	 * @return
	 */
	public EsEntity getEsEntity(String sql,TypeReference type){
		//拼接sql参数
		StringBuffer es_url = new StringBuffer(ConfigUtil.getString("es.url"));
		StringBuffer sql_param = new StringBuffer(sql); 
		try{
		es_url.append("?sql=").append(URLEncoder.encode(sql_param.toString(),"UTF-8"));
		}catch(Exception e){
			log.error("sql_param encode error:"+e.getMessage());
		}
		String rtnStr = getEsData(es_url.toString());
		Map<String,Object> map = parseEsRtn(rtnStr,type);
		String resultCode = map.get("resultCode").toString();
		//返回
		if(EsContant.ResultCode.rtnNull.getValue().equals(resultCode)||EsContant.ResultCode.rtnError.getValue().equals(resultCode)){
			return null;
		}else{
			EsEntity esEntity = (EsEntity)map.get("message");
			return esEntity;
		}		
	}
	/**
	 * 
	 * @Description 解析es服务返回的字符串
	 * @author zhufj
	 * @param rtnStr
	 * @param type
	 * @return
	 */
	private Map<String,Object> parseEsRtn(String rtnStr,TypeReference type){
		Map<String,Object> map = new HashMap<String,Object>();
		//es系统异常,返回空
		if(StringUtil.isEmpty(rtnStr)){
			map.put("resultCode", EsContant.ResultCode.rtnNull.getValue());
			map.put("message", EsContant.RtnMsg.rtnNull.getValue());
			log.error("getEsData error: get null for es service data");
		}else{
			boolean rtnFlag = false;
			try {
					rtnFlag = JacksonUtil.jsonStrToObj(rtnStr, "error");
					if(rtnFlag){//返回错误的字符串
						map.put("resultCode", EsContant.ResultCode.rtnError.getValue());
						map.put("message", EsContant.RtnMsg.rtnError.getValue());
						//日志
					}else{//返回正确的字符串
						ObjectMapper mapper = new ObjectMapper();
						EsEntity esEntity;
						esEntity = mapper.readValue(rtnStr,type);
						map.put("resultCode", EsContant.ResultCode.rtnNormal.getValue());
						map.put("message", esEntity);
						
					}
				} catch (JsonParseException e) {
					log.error("parseEsRtn error:"+e.getMessage());
					e.printStackTrace();
				} catch (JsonMappingException e) {
					log.error("parseEsRtn error:"+e.getMessage());
					e.printStackTrace();
				} catch (IOException e) {
					log.error("parseEsRtn error:"+e.getMessage());
					e.printStackTrace();
				}
		}
		return map;
	}
}
