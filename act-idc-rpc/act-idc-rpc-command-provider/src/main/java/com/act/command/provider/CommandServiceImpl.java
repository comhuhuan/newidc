package com.act.command.provider;


import javax.ws.rs.Path;
import com.act.command.CommandService;

@Path("/services")
public class CommandServiceImpl implements CommandService{

	@Override
	public String printCommand(String command) {
		return "策略已下发EU";
	}

}
