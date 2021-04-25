package by.jd2.p1.task1.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.jd2.p1.task1.controller.command.impl.GoToAddNews;
import by.jd2.p1.task1.controller.command.impl.GoToDeleteNews;
import by.jd2.p1.task1.controller.command.impl.GoToEditFullNews;
import by.jd2.p1.task1.controller.command.impl.GoToEditUser;
import by.jd2.p1.task1.controller.command.impl.GoToIndexPage;
import by.jd2.p1.task1.controller.command.impl.GoToLogination;
import by.jd2.p1.task1.controller.command.impl.GoToMainPage;
import by.jd2.p1.task1.controller.command.impl.GoToOneFullNews;
import by.jd2.p1.task1.controller.command.impl.GoToSaveAddNews;
import by.jd2.p1.task1.controller.command.impl.GoToSaveEditFullNews;
import by.jd2.p1.task1.controller.command.impl.GoToSaveEditUser;
import by.jd2.p1.task1.controller.command.impl.GoToSaveNewUser;
import by.jd2.p1.task1.controller.command.impl.GoToUserPage;
import by.jd2.p1.task1.controller.command.impl.LogOut;

public class CommandProvider {
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
	
	public CommandProvider( ) {
		commands.put(CommandName.LOGINATION, new GoToLogination());
		commands.put(CommandName.REGISTRATION, new GoToUserPage());
		commands.put(CommandName.SAVENEWUSER, new GoToSaveNewUser());
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
		commands.put(CommandName.LOGOUT, new LogOut());
		commands.put(CommandName.GOTOONEFULLNEWS, new GoToOneFullNews());
		commands.put(CommandName.GOTOEDITFULLNEWS, new GoToEditFullNews());
		commands.put(CommandName.SAVEEDITFULLNEWS, new GoToSaveEditFullNews());
		commands.put(CommandName.GOTOEDITUSER, new GoToEditUser());
		commands.put(CommandName.SAVEEDITUSER, new GoToSaveEditUser());
		commands.put(CommandName.GOTODELETENEWS, new GoToDeleteNews());
		commands.put(CommandName.GOTOADDNEWS, new GoToAddNews());
		commands.put(CommandName.SAVEADDNEWS, new GoToSaveAddNews());
		
	}

		public Command takeCommand(String name) {
			CommandName commandName;
			commandName = CommandName.valueOf(name.toUpperCase());
			return commands.get(commandName);
			
		}



}
