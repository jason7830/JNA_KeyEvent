package server.win32;

import com.sun.jna.win32.StdCallLibrary;
import server.win32.WinUser.*;
import server.win32.WinUser.INPUT;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
public interface user32 extends StdCallLibrary{
	user32 INSTANCE = Native.load("user32",user32.class);
	
	//The name of the input locale identifier to load.
	public static final String LANG_SYSTEM_DEFAULT = "LANG_SYSTEM_DEFAULT";
	//Specifies how the input locale identifier is to be loaded
	public static final short KLF_ACTIVATE = 0x00000001; 
	
	//The MapVirtualKeyExA translation to perform. 
	public static final short MAPVK_VK_TO_VSC = 0;
	public static final short MAPVK_VSC_TO_VK = 1;
	public static final short MAPVK_VK_TO_CHAR = 2;
	public static final short MAPVK_VSC_TO_VK_EX = 3;
	public static final short MAPVK_VK_TO_VSC_EX = 4;
	
	public WinDef.HKL LoadKeyboardLayoutA(String pwszKLID, long Flags);
	public long MapVirtualKeyExA(long ucode, long uMapType, WinDef.HKL dwHKL);
	public long MapVirtualKeyA(long ucode, long uMapType);
	public short VkKeyScanExA(char ch, WinDef.HKL dwhkl);
	public short VkKeyScanA(char ch);
	public int SendInput(WinDef.DWORD cInputs,INPUT[] pInputs, int cbsize);
}
