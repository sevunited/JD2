package by.jd2.p1.task1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.jd2.p1.task1.controller.command.Command;
import by.jd2.p1.task1.controller.command.CommandProvider;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final CommandProvider provider = new CommandProvider();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);


	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String name;
		Command comand;
		name = request.getParameter("command");
		comand = provider.takeCommand(name);
		comand.execute(request, response);

		
		
	}

}
