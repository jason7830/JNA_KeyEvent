package server;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import server.events.VirtualKeyCode;

public class Server extends HttpServlet{
	public void init() throws ServletException{
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		Enumeration<String> elements = request.getParameterNames();
		while(elements.hasMoreElements()) {
			System.out.println(elements.nextElement());
		}
		//pw.write("<h1>"+msg+"</h1>");
	}
	
	public void destory() {
		
	}
	
	public static  short getVkeyCode(String key) throws NoSuchFieldException{
		short keycode = -1;
		try
		{
			keycode =  (short)VirtualKeyCode.class.getDeclaredField("VK_"+key).get(null);
		}
		catch(IllegalAccessException iae) {
			System.out.println(iae.getStackTrace());
		}
		return keycode;
	}
}
