package com.act.command.provider;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Path;

import com.act.alone.model.TabSysConfig;
import com.act.command.SendCommandService;
import com.act.util.json.JacksonUtil;

@Path("/services")
public class SendCommandServiceImpl implements SendCommandService{

	@Override
	public String sendToEu(String command, Integer type) {
		String result="";
		switch (type) {
		case 4:
			result="监测策略下发完毕";
			break;
		case 5:
			result="过滤策略下发完毕";
			break;
		default:
			result="其他策略下发完毕";
			break;
		}
		
		List<TabSysConfig> jsonReulst=TabSysConfig.getDao().selectAll();
		String str="";
		try {
			str = JacksonUtil.beanToJson(jsonReulst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result+"json="+str;
	}

}
