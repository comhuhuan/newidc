package com.act.web.es.contant;

public class EsContant {
	/**
	 * 请求es服务返回的代码泛型
	 * @author zhufj
	 *
	 */
	public enum ResultCode{
		rtnNull("1"),rtnError("2"),rtnNormal("0");
		private String value;
		private ResultCode(String value){
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
	/**
	 * 请求es服务返回的消息
	 * @author zhufj
	 *
	 */
	public enum RtnMsg{
		rtnNull("es系统异常，请联系管理员"),rtnError("程序异常，请联系管理员");
		private String value;
		private RtnMsg(String value){
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
}
