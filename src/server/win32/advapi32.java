package server.win32;

import com.sun.jna.win32.StdCallLibrary;
import server.win32.WinUser.*;
import server.win32.WinUser.INPUT;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.Pointer;

public interface advapi32 extends StdCallLibrary {
	//load from windows/system32
	
	advapi32 INSTANCE = Native.load("advapi32",advapi32.class);
	
	public boolean GetUserNameA(Pointer lpuffer, Pointer pcbBuffer);
	
}
