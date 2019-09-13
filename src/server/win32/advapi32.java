package server.win32;

import com.sun.jna.win32.StdCallLibrary;

import server.win32.WinUser.StringByReference;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.WinNT.HANDLEByReference;
import com.sun.jna.Pointer;
import com.sun.jna.*;

public interface advapi32 extends StdCallLibrary {
	//load from windows/system32
	
	advapi32 INSTANCE = Native.load("advapi32",advapi32.class);
	
	public boolean GetUserNameA(Pointer lpuffer, Pointer pcbBuffer);
	public boolean LogonUserA(StringByReference lpszUsername, StringByReference lpszDomain, StringByReference lpszPassword, int dwLogonType, int dwLogonProvider, HANDLEByReference phToken);
	
	public static byte LOGON_WITH_PROFILE = 0x1;
	public static byte LOGON_NETCREDENTIALS_ONLY = 0x2;
	public boolean CreateProcessWithLogonW(WString lpszUsername, WString lpsSzDomain, WString lpszPassword, int dwLogonFlags, WString lpApplicationName, WString lpCommandLine, int dwCreationFlags, WinDef.LPVOID lpEnviroment, WString lpCurrentDirectory, WinBase.STARTUPINFO lpStartupInfo, WinBase.PROCESS_INFORMATION lpProcessInformation);
	public boolean CreateProcessWithTokenW(HANDLE htoken, int dwLogonFlags, WString lpApplicationName, WString lpCommandLine, int dwCreationFlags, WinDef.LPVOID lpEnviroment, WString lpCurrentDirectory, WinBase.STARTUPINFO lpStartupInfo, WinBase.PROCESS_INFORMATION lpProcessInformation);
	
	
}