package by.jd2.p1.task1.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
	// только эти исключения, никакие другие... ServletException, IOException

}
