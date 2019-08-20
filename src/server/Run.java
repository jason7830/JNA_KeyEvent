package server;

import com.sun.jna.platform.win32.*;

import server.win32.WinUser.*;
import server.win32.user32;
import server.events.*;

public class Run {
	private static WinDef.HKL dwhkl = user32.INSTANCE.LoadKeyboardLayoutA(user32.LANG_SYSTEM_DEFAULT,user32.KLF_ACTIVATE);

	public static void main(String[] args) throws InterruptedException
	{
		//
		while(true) {
			//KeyBoardEvent.sendScanKeyEx(new int[] {0xA0,'A'});
			KeyBoardEvent.sendScanKey(0x41,new int[] {0,2});
			Thread.sleep(300);
		}
		
	}
	private static int sendKey(int vkey) {
		INPUT shift = new INPUT();
		shift.type = new WinDef.DWORD(INPUT.INPUT_KEYBOARD);
		shift.dummy.setType("ki");
		shift.dummy.ki.wVk = new WinDef.WORD(0x10);
		
		INPUT i = new INPUT();
		INPUT[] ip = (INPUT[])i.toArray(1);
		ip[0].type = new WinDef.DWORD(INPUT.INPUT_KEYBOARD);
		ip[0].dummy.setType("ki");
		ip[0].dummy.ki.wVk = new WinDef.WORD(vkey);
		//ip[1].type = new WinDef.DWORD(INPUT.INPUT_KEYBOARD);
		//ip[1].dummy.setType("ki");
		//ip[1].dummy.ki.wVk = new WinDef.WORD(vkey);
		//ip[1].dummy.ki.dwFlags = new WinDef.DWORD(KEYBDINPUT.KEYEVENTF_KEYUP);
		return user32.INSTANCE.SendInput(new WinDef.DWORD(1), ip , ip[0].size());
	}
	
	public static WinDef.WORD VKtoSC(char key){
		int vk = user32.INSTANCE.VkKeyScanExA(key,dwhkl);
		//the low-order byte of the return value contains the virtual-key code and the high-order byte contains the shift state
		//pick out vk from low order byte
		vk = vk & 0b0000000011111111;
		long sc = user32.INSTANCE.MapVirtualKeyExA(vk, user32.MAPVK_VK_TO_VSC,dwhkl);
		return new WinDef.WORD(sc);
	}
	
	private static int sendScanKeyPressed(char key) {
		INPUT i = new INPUT();
		i.type = new WinDef.DWORD(INPUT.INPUT_KEYBOARD);
		i.dummy.setType("ki");
		i.dummy.ki.wVk = new WinDef.WORD(0);
		i.dummy.ki.dwFlags = new WinDef.DWORD(KEYBDINPUT.KEYEVENTF_SCANCODE); 
		WinDef.WORD wScan = VKtoSC(key);
		i.dummy.ki.wScan = wScan;
		return user32.INSTANCE.SendInput(new WinDef.DWORD(1),new INPUT[] {i},i.size());
		
		//i.dummy.ki.wScan
	}
}
