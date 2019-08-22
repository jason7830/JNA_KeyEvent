package server.win32;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import com.sun.jna.platform.win32.BaseTSD;
import com.sun.jna.platform.win32.WinDef;

public interface WinUser {
	
	public static List getFieldOrder(Class<?> c, Class<?>... filter) //arg2: ��蕪銝�閬�惇�折���
	{
		List<String> names = new ArrayList<String>();
		ArrayList<Class<?>> filters = new ArrayList<Class<?>>(Arrays.asList(filter));
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields)
		{
			if(filters.contains(f.getType())) continue;
			names.add(f.getName());
		}
		return names;
	}
	
	public static class MOUSEINPUT extends Structure{
		public MOUSEINPUT() {}
		public static final long MOUSEEVENTF_ABSOLUTE = 0x8000;
		public static final long MOUSEEVENTF_HWHEEL = 0x01000;
		public static final long MOUSEEVENTF_MOVE = 0x0001;
		public static final long MOUSEEVENTF_MOVE_NOCOALESCE = 0x2000;
		public static final long MOUSEEVENTF_LEFTDOWN = 0x0002;
		public static final long MOUSEEVENTF_LEFTUP = 0x0004;
		public static final long MOUSEEVENTF_RIGHTDOWN = 0x0008;
		public static final long MOUSEEVENTF_RIGHTUP = 0x0010;
		public static final long MOUSEEVENTF_MIDDLEDMOUSEEVENTF_MIDDLEUPOWN = 0x0040;
		public static final long MOUSEEVENTF_VIRTUALDESK = 0x4000;
		public static final long MOUSEEVENTF_WHEEL = 0x08000;
		public static final long MOUSEEVENTF_XDOWN = 0x0080;
		public static final long MOUSEEVENTF_XUP = 0x0100;
		
		public WinDef.LONG dx;
		public WinDef.LONG dy;
		public WinDef.DWORD mouseData;
		public WinDef.DWORD dwFlags;
		public WinDef.DWORD time;
		public BaseTSD.ULONG_PTR dwExtraInfo;
		protected List getFieldOrder() {
			return WinUser.getFieldOrder(this.getClass(),long.class);
		}
		
	}
	
	public static class KEYBDINPUT extends Structure{
		public KEYBDINPUT() {}
		public static final int KEYEVENTF_KEYDOWN = 0x0000;
		public static final int KEYEVENTF_EXTENDEDKEY = 0x0001;
		public static final int KEYEVENTF_KEYUP = 0x0002;
		public static final int KEYEVENTF_SCANCODE = 0x0008;
		public static final int KEYEVENTF_UNICODE = 0x0004;
		
		public WinDef.WORD wVk;
		public WinDef.WORD wScan;
		public WinDef.DWORD dwFlags;
		public WinDef.DWORD time;
		public BaseTSD.ULONG_PTR dwExtraInfo;
		protected List getFieldOrder() {
			return WinUser.getFieldOrder(this.getClass(),int.class);
		}
	}
	
	public static class HARDWAREINPUT extends Structure{
		public HARDWAREINPUT() {}
		public WinDef.DWORD uMsg;
		public WinDef.WORD wParamL;
		public WinDef.WORD wParamH;
		protected List getFieldOrder() {
			return WinUser.getFieldOrder(this.getClass(),int.class);
		}
	}
	
	public static class INPUT extends Structure {
		public INPUT() {}
		public static final int INPUT_MOUSE = 0;
		public static final int INPUT_KEYBOARD = 1;
		public static final int INPUT_HARDWARE = 2;
		public WinDef.DWORD type;
		
		public DUMMYUNIONNAME dummy = new DUMMYUNIONNAME();
		
		public static class DUMMYUNIONNAME extends Union{
			public DUMMYUNIONNAME() {
				
			}
			
			public MOUSEINPUT mi;
			public KEYBDINPUT ki;
			public HARDWAREINPUT hi;
			protected List getFieldOrder() {
				return WinUser.getFieldOrder(this.getClass());
			}
		}
		protected List getFieldOrder() {
			return WinUser.getFieldOrder(this.getClass(),int.class);
		}
	}
}
