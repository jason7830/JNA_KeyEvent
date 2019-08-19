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
			INPUT input_p = new INPUT();
			INPUT.DUMMYUNIONNAME dummy_p = input_p.new DUMMYUNIONNAME();
			input_p.type = new WinDef.DWORD(1);
			dummy_p.ki.wScan = new WinDef.WORD(0);
			dummy_p.ki.dwFlags = new WinDef.DWORD(0);
			dummy_p.ki.wVk = new WinDef.WORD(0x41);
			int press = user32.INSTANCE.SendInput(new WinDef.DWORD(1),input_p , input_p.size());
			System.out.println("press: "+press);
			
			INPUT input_r = new INPUT();
			INPUT.DUMMYUNIONNAME dummy_r = input_r.new DUMMYUNIONNAME();
			input_r.type = new WinDef.DWORD(1);
			dummy_r.ki.wScan = new WinDef.WORD(0);
			dummy_r.ki.dwFlags = new WinDef.DWORD(2);
			dummy_r.ki.wVk = new WinDef.WORD(0x41);
			int release = user32.INSTANCE.SendInput(new WinDef.DWORD(1),input_r, input_r.size());
			System.out.println("release: "+release);
			Thread.sleep(700);
			System.out.println("SLEPT");
		}
		//System.out.println("TEST");
	}
	
	public static class MOUSEINPUT extends Structure{
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
		public WinDef.DWORD Msg;
		public WinDef.WORD wParamL;
		public WinDef.WORD wParamH;
		protected List getFieldOrder() {
			return Run.getFieldOrder(this.getClass());
		}
	}
	
	public static class INPUT extends Structure{
		public WinDef.DWORD type;
		
		public class DUMMYUNIONNAME extends Union{
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
		public int SendInput(WinDef.DWORD cInputs,INPUT pInputs, int cbsize);
	}
	
}
