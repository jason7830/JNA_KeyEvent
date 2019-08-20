package server.win32;

import com.sun.jna.win32.StdCallLibrary;

import server.win32.WinUser.INPUT;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
public interface user32 extends StdCallLibrary{
	user32 INSTANCE = Native.loadLibrary("user32",user32.class);
	
	public int SendInput(WinDef.DWORD cInputs,INPUT[] pInputs, int cbsize);
}
