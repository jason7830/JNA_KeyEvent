package server.events;

import java.time.Clock;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.DWORD;

import server.win32.*;
import server.win32.WinUser.*;
public class MouseEvent {
	public static byte SM_CXSCREEN = 0;
	public static byte SM_CYSCREEN = 1;
	public static int setAbsPosition(long dx, long dy) {
		INPUT ip = new INPUT();
		ip.type = new WinDef.DWORD(INPUT.INPUT_MOUSE);
		ip.dummy.setType("mi");
		ip.dummy.mi.dwFlags = new WinDef.DWORD(MOUSEINPUT.MOUSEEVENTF_MOVE|MOUSEINPUT.MOUSEEVENTF_ABSOLUTE | MOUSEINPUT.MOUSEEVENTF_VIRTUALDESK);
		int width = user32.INSTANCE.GetSystemMetrics(SM_CXSCREEN);
		int height = user32.INSTANCE.GetSystemMetrics(SM_CYSCREEN);
		/*
		If MOUSEEVENTF_ABSOLUTE value is specified, dx and dy contain normalized absolute coordinates between 0 and 65,535. The event procedure maps 
		these coordinates onto the display surface. Coordinate (0,0) maps onto the upper-left corner of the display surface, (65535,65535) maps onto the lower-right corner. 
		*/
		ip.dummy.mi.dx = new WinDef.LONG((long)Math.ceil(dx * 65536 / (double)width));
		ip.dummy.mi.dy = new WinDef.LONG((long)Math.ceil(dy * 65536 / (double)height));
		ip.dummy.mi.time = new WinDef.DWORD(0);
		ip.dummy.mi.mouseData = new WinDef.DWORD(0);
		ip.dummy.mi.dwExtraInfo = new BaseTSD.ULONG_PTR(user32.INSTANCE.GetMessageExtraInfo().longValue());
		return user32.INSTANCE.SendInput(new WinDef.DWORD(1),new INPUT[] { ip}, ip.size());
	}
}
