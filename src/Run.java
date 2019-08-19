import com.sun.jna.Native;
import com.sun.jna.Union;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinDef.*;
import com.sun.jna.win32.StdCallLibrary;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

import com.sun.jna.platform.win32.BaseTSD;


public class Run {
	public static void main(String[] args) throws InterruptedException
	{
		/*
		Frame f = new Frame("test");
		TextArea ta = new TextArea("");
		ta.setBounds(50,50,50,50);
		f.add(ta);
		f.setSize(500,500);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		*/
		
		//dummy.ki.time = new WinDef.DWORD(0);
		//dummy.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
		
		while(true){
			INPUT i = new INPUT();
			INPUT[] ip = (INPUT[]) i.toArray(2);
			ip[0].type = new WinDef.DWORD(1);
			ip[0].dummy.setType("ki");
			//ip[0].dummy.ki.wScan = new WinDef.WORD(0);
			//input_p.dummy.ki.dwFlags = new WinDef.DWORD(0);
			ip[0].dummy.ki.wVk = new WinDef.WORD('A');
			//int press = user32.INSTANCE.SendInput(new WinDef.DWORD(1),input_p , input_p.size());
			//System.out.println("press: "+press);
			ip[1].type = new WinDef.DWORD(1);
			ip[1].dummy.setType("ki");
			//ip[1].dummy.ki.wScan = new WinDef.WORD(0);
			ip[1].dummy.ki.dwFlags = new WinDef.DWORD(2);
			ip[1].dummy.ki.wVk = new WinDef.WORD('A');
			int release = user32.INSTANCE.SendInput(new WinDef.DWORD(2),ip, ip[0].size());
			System.out.println("release: "+release);
			Thread.sleep(700);
			System.out.println("SLEPT");
		}
		//System.out.println("TEST");
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
			return Run.getFieldOrder(this.getClass());
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
			return Run.getFieldOrder(this.getClass());
		}
	}
	
	public static class HARDWAREINPUT extends Structure{
		public HARDWAREINPUT() {}
		public WinDef.DWORD Msg;
		public WinDef.WORD wParamL;
		public WinDef.WORD wParamH;
		protected List getFieldOrder() {
			return Run.getFieldOrder(this.getClass());
		}
	}
	
	public static class INPUT extends Structure{
		public INPUT() {}
		public WinDef.DWORD type;
		public DUMMYUNIONNAME dummy = new DUMMYUNIONNAME();
		
		public static class DUMMYUNIONNAME extends Union{
			public DUMMYUNIONNAME() {
				
			}
			
			public MOUSEINPUT mi;
			public KEYBDINPUT ki;
			public HARDWAREINPUT hi;
			protected List getFieldOrder() {
				return Run.getFieldOrder(this.getClass());
			}
		}
		protected List getFieldOrder() {
			return Run.getFieldOrder(this.getClass());
		}
	}
	
	private static List getFieldOrder(Class<?> c)
	{
		List<String> names = new ArrayList<String>();
		Field[] fields = c.getDeclaredFields();
		for(Field f : fields)
		{
			names.add(f.getName());
		}
		return names;
	}
	
	public interface user32 extends StdCallLibrary{
		user32 INSTANCE = (user32)Native.loadLibrary("user32",user32.class);
		public int SendInput(WinDef.DWORD cInputs,INPUT[] pInputs, int cbsize);
	}
	
}
