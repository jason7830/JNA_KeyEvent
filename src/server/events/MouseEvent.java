package server.events;

import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.DWORD;

import server.win32.*;
import server.win32.WinUser.*;
public class MouseEvent {
	public static int setAbsPosition(long dx, long dy) {
		INPUT ip = new INPUT();
		ip.type = new WinDef.DWORD(INPUT.INPUT_MOUSE);
		ip.dummy.setType("mi");
		ip.dummy.mi.dwFlags = new WinDef.DWORD(MOUSEINPUT.MOUSEEVENTF_MOVE | MOUSEINPUT.MOUSEEVENTF_ABSOLUTE | MOUSEINPUT.MOUSEEVENTF_VIRTUALDESK);
		ip.dummy.mi.dx = new WinDef.LONG(dx);
		ip.dummy.mi.dy = new WinDef.LONG(dy);
		ip.dummy.mi.mouseData = new WinDef.DWORD(0);
		return user32.INSTANCE.SendInput(new WinDef.DWORD(1), ip, ip.size());
	}
}
