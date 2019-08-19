package com.sun.jna.platform.win32;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.BaseTSD.LONG_PTR;
import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.sun.jna.platform.win32.WinDef.ATOM;
import com.sun.jna.platform.win32.WinDef.BOOL;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.DWORDByReference;
import com.sun.jna.platform.win32.WinDef.HDC;
import com.sun.jna.platform.win32.WinDef.HICON;
import com.sun.jna.platform.win32.WinDef.HINSTANCE;
import com.sun.jna.platform.win32.WinDef.HKL;
import com.sun.jna.platform.win32.WinDef.HMENU;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.HRGN;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.LPVOID;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.POINT;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinDef.UINT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinDef.POINT.ByValue;
import com.sun.jna.platform.win32.WinGDI.ICONINFO;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.WinUser.BLENDFUNCTION;
import com.sun.jna.platform.win32.WinUser.FLASHWINFO;
import com.sun.jna.platform.win32.WinUser.GUITHREADINFO;
import com.sun.jna.platform.win32.WinUser.HDEVNOTIFY;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.HMONITOR;
import com.sun.jna.platform.win32.WinUser.HOOKPROC;
import com.sun.jna.platform.win32.WinUser.INPUT;
import com.sun.jna.platform.win32.WinUser.LASTINPUTINFO;
import com.sun.jna.platform.win32.WinUser.MONITORENUMPROC;
import com.sun.jna.platform.win32.WinUser.MONITORINFO;
import com.sun.jna.platform.win32.WinUser.MONITORINFOEX;
import com.sun.jna.platform.win32.WinUser.MSG;
import com.sun.jna.platform.win32.WinUser.RAWINPUTDEVICELIST;
import com.sun.jna.platform.win32.WinUser.SIZE;
import com.sun.jna.platform.win32.WinUser.WINDOWINFO;
import com.sun.jna.platform.win32.WinUser.WINDOWPLACEMENT;
import com.sun.jna.platform.win32.WinUser.WNDCLASSEX;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.platform.win32.WinUser.WinEventProc;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public interface User32 extends StdCallLibrary, WinUser, WinNT {
	User32 INSTANCE = (User32) Native.load("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
	HWND HWND_MESSAGE = new HWND(Pointer.createConstant(-3));
	int CS_GLOBALCLASS = 16384;
	int WS_EX_TOPMOST = 8;
	int DEVICE_NOTIFY_WINDOW_HANDLE = 0;
	int DEVICE_NOTIFY_SERVICE_HANDLE = 1;
	int DEVICE_NOTIFY_ALL_INTERFACE_CLASSES = 4;
	int SW_SHOWDEFAULT = 10;

	HDC GetDC(HWND var1);

	int ReleaseDC(HWND var1, HDC var2);

	HWND FindWindow(String var1, String var2);

	int GetClassName(HWND var1, char[] var2, int var3);

	boolean GetGUIThreadInfo(int var1, GUITHREADINFO var2);

	boolean GetWindowInfo(HWND var1, WINDOWINFO var2);

	boolean GetWindowRect(HWND var1, RECT var2);

	boolean GetClientRect(HWND var1, RECT var2);

	int GetWindowText(HWND var1, char[] var2, int var3);

	int GetWindowTextLength(HWND var1);

	int GetWindowModuleFileName(HWND var1, char[] var2, int var3);

	int GetWindowThreadProcessId(HWND var1, IntByReference var2);

	boolean EnumWindows(WNDENUMPROC var1, Pointer var2);

	boolean EnumChildWindows(HWND var1, WNDENUMPROC var2, Pointer var3);

	boolean EnumThreadWindows(int var1, WNDENUMPROC var2, Pointer var3);

	boolean FlashWindowEx(FLASHWINFO var1);

	HICON LoadIcon(HINSTANCE var1, String var2);

	HANDLE LoadImage(HINSTANCE var1, String var2, int var3, int var4, int var5, int var6);

	boolean DestroyIcon(HICON var1);

	int GetWindowLong(HWND var1, int var2);

	int SetWindowLong(HWND var1, int var2, int var3);

	LONG_PTR GetWindowLongPtr(HWND var1, int var2);

	Pointer SetWindowLongPtr(HWND var1, int var2, Pointer var3);

	boolean SetLayeredWindowAttributes(HWND var1, int var2, byte var3, int var4);

	boolean GetLayeredWindowAttributes(HWND var1, IntByReference var2, ByteByReference var3, IntByReference var4);

	boolean UpdateLayeredWindow(HWND var1, HDC var2, POINT var3, SIZE var4, HDC var5, POINT var6, int var7,
			BLENDFUNCTION var8, int var9);

	int SetWindowRgn(HWND var1, HRGN var2, boolean var3);

	boolean GetKeyboardState(byte[] var1);

	short GetAsyncKeyState(int var1);

	HHOOK SetWindowsHookEx(int var1, HOOKPROC var2, HINSTANCE var3, int var4);

	LRESULT CallNextHookEx(HHOOK var1, int var2, WPARAM var3, LPARAM var4);

	boolean UnhookWindowsHookEx(HHOOK var1);

	int GetMessage(MSG var1, HWND var2, int var3, int var4);

	boolean PeekMessage(MSG var1, HWND var2, int var3, int var4, int var5);

	boolean TranslateMessage(MSG var1);

	LRESULT DispatchMessage(MSG var1);

	void PostMessage(HWND var1, int var2, WPARAM var3, LPARAM var4);

	int PostThreadMessage(int var1, int var2, WPARAM var3, LPARAM var4);

	void PostQuitMessage(int var1);

	int GetSystemMetrics(int var1);

	HWND SetParent(HWND var1, HWND var2);

	boolean IsWindowVisible(HWND var1);

	boolean MoveWindow(HWND var1, int var2, int var3, int var4, int var5, boolean var6);

	boolean SetWindowPos(HWND var1, HWND var2, int var3, int var4, int var5, int var6, int var7);

	boolean AttachThreadInput(DWORD var1, DWORD var2, boolean var3);

	boolean SetForegroundWindow(HWND var1);

	HWND GetForegroundWindow();

	HWND SetFocus(HWND var1);

	DWORD SendInput(DWORD var1, INPUT[] var2, int var3);

	DWORD WaitForInputIdle(HANDLE var1, DWORD var2);

	boolean InvalidateRect(HWND var1, RECT var2, boolean var3);

	boolean RedrawWindow(HWND var1, RECT var2, HRGN var3, DWORD var4);

	HWND GetWindow(HWND var1, DWORD var2);

	boolean UpdateWindow(HWND var1);

	boolean ShowWindow(HWND var1, int var2);

	boolean CloseWindow(HWND var1);

	boolean RegisterHotKey(HWND var1, int var2, int var3, int var4);

	boolean UnregisterHotKey(Pointer var1, int var2);

	boolean GetLastInputInfo(LASTINPUTINFO var1);

	ATOM RegisterClassEx(WNDCLASSEX var1);

	boolean UnregisterClass(String var1, HINSTANCE var2);

	HWND CreateWindowEx(int var1, String var2, String var3, int var4, int var5, int var6, int var7, int var8, HWND var9,
			HMENU var10, HINSTANCE var11, LPVOID var12);

	boolean DestroyWindow(HWND var1);

	boolean GetClassInfoEx(HINSTANCE var1, String var2, WNDCLASSEX var3);

	LRESULT DefWindowProc(HWND var1, int var2, WPARAM var3, LPARAM var4);

	HDEVNOTIFY RegisterDeviceNotification(HANDLE var1, Structure var2, int var3);

	boolean UnregisterDeviceNotification(HDEVNOTIFY var1);

	int RegisterWindowMessage(String var1);

	HMONITOR MonitorFromPoint(ByValue var1, int var2);

	HMONITOR MonitorFromRect(RECT var1, int var2);

	HMONITOR MonitorFromWindow(HWND var1, int var2);

	BOOL GetMonitorInfo(HMONITOR var1, MONITORINFO var2);

	BOOL GetMonitorInfo(HMONITOR var1, MONITORINFOEX var2);

	BOOL EnumDisplayMonitors(HDC var1, RECT var2, MONITORENUMPROC var3, LPARAM var4);

	BOOL GetWindowPlacement(HWND var1, WINDOWPLACEMENT var2);

	BOOL SetWindowPlacement(HWND var1, WINDOWPLACEMENT var2);

	BOOL AdjustWindowRect(RECT var1, DWORD var2, BOOL var3);

	BOOL AdjustWindowRectEx(RECT var1, DWORD var2, BOOL var3, DWORD var4);

	BOOL ExitWindowsEx(UINT var1, DWORD var2);

	BOOL LockWorkStation();

	boolean GetIconInfo(HICON var1, ICONINFO var2);

	LRESULT SendMessageTimeout(HWND var1, int var2, WPARAM var3, LPARAM var4, int var5, int var6,
			DWORDByReference var7);

	ULONG_PTR GetClassLongPtr(HWND var1, int var2);

	int GetRawInputDeviceList(RAWINPUTDEVICELIST[] var1, IntByReference var2, int var3);

	HWND GetDesktopWindow();

	boolean PrintWindow(HWND var1, HDC var2, int var3);

	boolean IsWindowEnabled(HWND var1);

	boolean IsWindow(HWND var1);

	HWND FindWindowEx(HWND var1, HWND var2, String var3, String var4);

	HWND GetAncestor(HWND var1, int var2);

	boolean GetCursorPos(POINT var1);

	boolean SetCursorPos(long var1, long var3);

	HANDLE SetWinEventHook(int var1, int var2, HMODULE var3, WinEventProc var4, int var5, int var6, int var7);

	boolean UnhookWinEvent(HANDLE var1);

	HICON CopyIcon(HICON var1);

	int GetClassLong(HWND var1, int var2);

	int RegisterClipboardFormat(String var1);

	HWND GetActiveWindow();

	LRESULT SendMessage(HWND var1, int var2, WPARAM var3, LPARAM var4);

	int GetKeyboardLayoutList(int var1, HKL[] var2);

	HKL GetKeyboardLayout(int var1);

	boolean GetKeyboardLayoutName(char[] var1);

	short VkKeyScanExA(byte var1, HKL var2);

	short VkKeyScanExW(char var1, HKL var2);

	int MapVirtualKeyEx(int var1, int var2, HKL var3);

	int ToUnicodeEx(int var1, int var2, byte[] var3, char[] var4, int var5, int var6, HKL var7);

	int LoadString(HINSTANCE var1, int var2, Pointer var3, int var4);
}