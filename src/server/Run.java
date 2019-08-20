package server;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;
import com.sun.jna.win32.StdCallLibrary;

import server.win32.WinUser.*;
import server.win32.user32;

public class Run {
	public static void main(String[] args) throws InterruptedException
	{
		while(true){
			int release = sendKey(0x41);
			System.out.println("release: "+release);
			Thread.sleep(700);
			System.out.println("SLEPT");
		}
		//System.out.println("TEST");
	}
	
	private static int sendKey(int vkey) {
		INPUT shift = new INPUT();
		shift.type = new WinDef.DWORD(INPUT.INPUT_KEYBOARD);
		shift.dummy.setType("ki");
		shift.dummy.ki.wVk = new WinDef.WORD(0x10);
		
		INPUT i = new INPUT();
		INPUT[] ip = (INPUT[])i.toArray(2);
		ip[0].type = new WinDef.DWORD(INPUT.INPUT_KEYBOARD);
		ip[0].dummy.setType("ki");
		ip[0].dummy.ki.wVk = new WinDef.WORD(vkey);
		ip[1].type = new WinDef.DWORD(INPUT.INPUT_KEYBOARD);
		ip[1].dummy.setType("ki");
		ip[1].dummy.ki.wVk = new WinDef.WORD(vkey);
		ip[1].dummy.ki.dwFlags = new WinDef.DWORD(KEYBDINPUT.KEYEVENTF_KEYUP);
		return user32.INSTANCE.SendInput(new WinDef.DWORD(2), ip , ip[0].size());
	}
}
