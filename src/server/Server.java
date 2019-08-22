package server;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Server extends HttpServlet{
	private String msg ;
	public void init() throws ServletException{
		msg = "";
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		Enumeration<String> elements = request.getParameterNames();
		while(elements.hasMoreElements()) {
			System.out.println(elements.nextElement());
		}
		//pw.write("<h1>"+msg+"</h1>");
	}
	
	public void destory() {
		
	}
}
