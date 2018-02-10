package com.act.web.enums;

public enum EsType {
	IpDomainRelation("br2004"),  // IP域名关系
	alarm_isms("4"),          // 监测日志
	block_isms("5"),          // 过滤日志 
	access_log("3"),		  //网页访问日志、其他协议日志
	VisitResultEsModel("3"),	//访问日志
	ismsm_housemonitor("2"),	//基础数据监测日志
	URLHandle("url001"),               // 
	ProvinceTLD("ptld001"),
	EcURLExclusion("ec0001"),			//URL排重
	domain_activelog("81"),//活跃域名  -- xj
	ip_activelog("82"),//活跃IP  --xj
	secanalyse("url_analysis_second"),
	Nwebpage("pages"),	//爬虫爬取网页内容信息
	blackcmd_log("9") //违法违规  --xj
	;
	
	private String value;

	EsType(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

