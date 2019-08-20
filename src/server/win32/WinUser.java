package server.win32;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.WinDef;

import server.Run;


public interface WinUser {
	
	public static List getFieldOrder(Class<?> c)
	{
		List<String> names = new ArrayList<String>();
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields)
		{
			names.add(f.getName());
		}
		return names;
	}
	
	public static class MOUSEINPUT extends Structure{
		public MOUSEINPUT() {}
		public BaseTSD.ULONG_PTR dwExtraInfo;
		public WinDef.DWORD dwFlags;
		public WinDef.LONG dx;
		public WinDef.LONG dy;
		public WinDef.DWORD mouseData;
		public WinDef.DWORD time;
		protected List getFieldOrder() {
			return WinUser.getFieldOrder(this.getClass());
		}
		
	}
	
	public static class KEYBDINPUT extends Structure{
		public KEYBDINPUT() {}
		public WinDef.WORD wVk;
		public WinDef.WORD wScan;
		public WinDef.DWORD dwFlags;
		public WinDef.DWORD time;
		public BaseTSD.ULONG_PTR dwExtraInfo;
		protected List getFieldOrder() {
			return WinUser.getFieldOrder(this.getClass());
		}
	}
	
	public static class HARDWAREINPUT extends Structure{
		public HARDWAREINPUT() {}
		public WinDef.DWORD Msg;
		public WinDef.WORD wParamL;
		public WinDef.WORD wParamH;
		protected List getFieldOrder() {
			return WinUser.getFieldOrder(this.getClass());
		}
	}
	
	public static class INPUT extends Structure {
		//public INPUT() {}
		public WinDef.DWORD type;
		public DUMMYUNIONNAME dummy = new DUMMYUNIONNAME();
		
		public static class DUMMYUNIONNAME extends Union{
			//public DUMMYUNIONNAME() {}
			
			public MOUSEINPUT mi;
			public KEYBDINPUT ki;
			public HARDWAREINPUT hi;
			protected List getFieldOrder() {
				return WinUser.getFieldOrder(this.getClass());
			}
		}
		protected List getFieldOrder() {
			return WinUser.getFieldOrder(this.getClass());
		}
	}
}
