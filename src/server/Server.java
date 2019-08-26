package server;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import server.win32.advapi32;

import com.sun.jna.Memory;
import com.sun.jna.platform.win32.User32;

import server.events.KeyBoardEvent;
import server.events.VirtualKeyCode;

public class Server extends HttpServlet{
	public void init() throws ServletException{
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		System.out.println("TEST");
		String key = request.getParameter("key");
		System.out.println("KEY:"+key);
		try {
			System.out.println(KeyBoardEvent.sendVKey(getVkeyCode(key), new int[] {0,2}));
		}catch(Exception ex) {System.out.println("FAILE:"+ex.getStackTrace());}
		//pw.write("<h1>"+msg+"</h1>");
	}
	
	public void destory() {
		
	}
	
	public short getVkeyCode(String key) throws NoSuchFieldException{
		short keycode = -1;
		try
		{
			keycode =  (short)VirtualKeyCode.class.getDeclaredField("VK_"+key).get(null);
			System.out.println(""+keycode);
		}
		catch(Exception iae) {
			System.out.println("ILLEGAL:"+iae.getStackTrace());
		}
		return keycode;
	}
	
	public static String getClientName() {
		String name = "";
		Memory b_name = new Memory(Character.BYTES*(256+1));
		Memory b_size = new Memory(Integer.BYTES);
		b_size.setInt(0, 256+1);
		advapi32.INSTANCE.GetUserNameA(b_name, b_size);
		return b_name.getString(0);
	}
}
