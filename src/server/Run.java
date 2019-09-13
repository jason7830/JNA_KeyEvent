package server;
import com.sun.jna.platform.win32.Advapi32;
import com.sun.jna.platform.win32.WinBase;
//import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.POINT;
import com.sun.jna.ptr.IntByReference;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.WString;

import server.events.*;
import server.win32.user32;
import server.win32.WinUser.StringByReference;
import server.win32.advapi32;

public class Run {
	private static String key = "";
	public static void main(String[] args) throws InterruptedException, NoSuchFieldException
	{
		//System.out.println(args.length);
		//WinBase.STARTUPINFO si = new WinBase.STARTUPINFO();
		WString nullw = null;
		//boolean b= advapi32.INSTANCE.CreateProcessWithLogonW(new WString("YoYo"),nullw , new WString("761223"), 1, new WString("c:\\\\windows\\\\system32\\\\cmd.exe"), new WString("\"javaw -jar test.jar\""), 0x10, null, new WString("C:\\Users\\YoYo\\Desktop"), si, new WinBase.PROCESS_INFORMATION());
		;
		//System.out.println(this.getClass());
		//boolean b = advapi32.INSTANCE.CreateProcessWithTokenW(Server.Logon("YoYo", "761223").getValue(), 0x01, new WString("c:\\\\windows\\\\system32\\\\cmd.exe"), new WString("javaw -jar brainstorm.jar"), 0, null,new WString("C:\\Users\\YoYo\\Desktop\\brainstorm"), si, new WinBase.PROCESS_INFORMATION());
		//int sc = com.sun.jna.platform.win32.Kernel32.INSTANCE.GetLastError();
		//System.out.println(""+b+sc);
		//KeyBoardEvent.sendVKey(VirtualKeyCode.VK_VOLUME_MUTE, new int[] {0,2});
		//System.out.println(Server.getClientName());
		
		//advapi32.INSTANCE.getUserNameA(lpuffer, pcbBuffer);
		// 1579 788
		//KeyBoardEvent.sendVKeyEx(new int[] {0x10,'A'});
		//KeyBoardEvent.sendScanKeyEx(new int[] {0x11,0x12,0x2E});
		//KeyBoardEvent.sendScanKey(0x27,new int[] {0});
		//Thread.sleep(5000);
		//�@��NativeLong���j�p�O4bytes
		/*
		Pointer pt = new Memory(8);
		while(true) {
			user32.INSTANCE.GetCursorPos(pt);
			System.out.println(pt.getNativeLong(0)+"  "+pt.getNativeLong(4));
			Thread.sleep(200);
		}*/
	}
	
	private static void setArgs()
	{
		
	}
}
