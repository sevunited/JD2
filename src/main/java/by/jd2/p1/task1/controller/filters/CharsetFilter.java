package by.jd2.p1.task1.controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharsetFilter implements Filter{
	private String encoding;
	private ServletContext context;
	
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		context.log("Charset was set");
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("characterEncoding");
		context = fConfig.getServletContext();
		context.log("Parameter encoding=" + encoding);
	}

}
