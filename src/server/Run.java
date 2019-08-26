package server;
import com.sun.jna.platform.win32.Advapi32;
//import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.POINT;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;

import server.events.*;
import server.win32.user32;
import server.win32.advapi32;

public class Run {
	public static void main(String[] args) throws InterruptedException, NoSuchFieldException
	{
		char[] u = new char[256+1];
		int pcb = u.length;
		Pointer pu = new Memory((256+1)*2);
		Pointer pi = new Memory(Integer.BYTES);
		advapi32.INSTANCE.getUserNameA(pu, pi);
		System.out.println(pu.getString(0));
		
		//advapi32.INSTANCE.getUserNameA(lpuffer, pcbBuffer);
		//KeyBoardEvent.sendVKey(VirtualKeyCode.VK_VOLUME_MUTE, new int[] {0,2}); 1579 788
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
}
