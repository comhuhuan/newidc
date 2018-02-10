package com.act.web.es.type;

import java.util.Date;
/**
 * 
 * 
 * <p>Title: AlarmIsmsModel.java
 * <p>Description:监控日志es 映射model
 * @author zhufj
 * @date 2018年2月5日 下午3:28:35
 */
public class AlarmIsmsModel {
	private String house_id;
	private String service_code;
	private String scheme_id;
	private String in_ip;
	private String in_ipv6;
	private Long in_port;
	private String out_ip;
	private String out_ipv6;
	private Long out_port;
	private String proxy_ip;
	private Long proxy_port;
	private Long proxy_type;
	private String host;
	private String url;
	private String content;
	private  Date cur_time;
	private String is_read;
	private String is_up;
	public String getHouse_id() {
		return house_id;
	}
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	public String getService_code() {
		return service_code;
	}
	public void setService_code(String service_code) {
		this.service_code = service_code;
	}
	public String getScheme_id() {
		return scheme_id;
	}
	public void setScheme_id(String scheme_id) {
		this.scheme_id = scheme_id;
	}
	public String getIn_ip() {
		return in_ip;
	}
	public void setIn_ip(String in_ip) {
		this.in_ip = in_ip;
	}
	public String getIn_ipv6() {
		return in_ipv6;
	}
	public void setIn_ipv6(String in_ipv6) {
		this.in_ipv6 = in_ipv6;
	}
	public Long getIn_port() {
		return in_port;
	}
	public void setIn_port(Long in_port) {
		this.in_port = in_port;
	}
	public String getOut_ip() {
		return out_ip;
	}
	public void setOut_ip(String out_ip) {
		this.out_ip = out_ip;
	}
	public String getOut_ipv6() {
		return out_ipv6;
	}
	public void setOut_ipv6(String out_ipv6) {
		this.out_ipv6 = out_ipv6;
	}
	public Long getOut_port() {
		return out_port;
	}
	public void setOut_port(Long out_port) {
		this.out_port = out_port;
	}
	public String getProxy_ip() {
		return proxy_ip;
	}
	public void setProxy_ip(String proxy_ip) {
		this.proxy_ip = proxy_ip;
	}
	public Long getProxy_port() {
		return proxy_port;
	}
	public void setProxy_port(Long proxy_port) {
		this.proxy_port = proxy_port;
	}
	public Long getProxy_type() {
		return proxy_type;
	}
	public void setProxy_type(Long proxy_type) {
		this.proxy_type = proxy_type;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCur_time() {
		return cur_time;
	}
	public void setCur_time(Date cur_time) {
		this.cur_time = cur_time;
	}
	public String getIs_read() {
		return is_read;
	}
	public void setIs_read(String is_read) {
		this.is_read = is_read;
	}
	public String getIs_up() {
		return is_up;
	}
	public void setIs_up(String is_up) {
		this.is_up = is_up;
	}
}
