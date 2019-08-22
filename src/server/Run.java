package server;
//import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.POINT;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;

import server.events.*;
import server.win32.user32;

public class Run {
	public static void main(String[] args) throws InterruptedException
	{
		//KeyBoardEvent.sendVKey(VirtualKeyCode.VK_VOLUME_MUTE, new int[] {0,2}); 1579 788
		System.out.println(""+MouseEvent.setAbsPosition(1579,788));
		//KeyBoardEvent.sendVKeyEx(new int[] {0x10,'A'});
		//KeyBoardEvent.sendScanKeyEx(new int[] {0x11,0x12,0x2E});
		//KeyBoardEvent.sendScanKey(0x27,new int[] {0});
		//Thread.sleep(5000);
		
		//一個NativeLong的大小是4bytes
		Pointer pt = new Memory(8);
		while(true) {
			user32.INSTANCE.GetCursorPos(pt);
			System.out.println(pt.getNativeLong(0)+"  "+pt.getNativeLong(4));
			Thread.sleep(200);
		}
		
	}
}
