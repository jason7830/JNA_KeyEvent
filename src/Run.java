import com.sun.jna.Native;
import com.sun.jna.Union;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinDef.*;
import com.sun.jna.win32.StdCallLibrary;
import java.awt.*;
import java.awt.event.*;
import com.sun.jna.platform.win32.BaseTSD;


public class Run {
	public static void main(String[] args)
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
		user32.LPINPUT input = new user32.LPINPUT();
		user32.LPINPUT.DUMMYUNIONNAME dummy = new user32.LPINPUT.DUMMYUNIONNAME();
		input.type = new WinUser.DWORD(1);
		dummy.ki.time = new WinUser.DWORD(0);
		dummy.ki.dwExtraInfo = new BaseTSD.ULONG_PTR(0);
		dummy.ki.wScan = new WinUser.WORD(0);
		dummy.ki.dwFlags = new WinUser.DWORD(0);
		dummy.ki.wVk = new WinUser.WORD(0x41);
		user32.INSTANCE.SendInput(1, input , input.size());
		System.out.println("TEST");
	}
	
	
	public interface user32 extends StdCallLibrary{
		user32 INSTANCE = (user32)Native.loadLibrary("user32",user32.class);
		public int SendInput(long cInputs,LPINPUT pInputs, int cbsize);
		public static class MOUSEINPUT extends Structure{
			public WinUser.LONG dx;
			public WinUser.LONG dy;
			public WinUser.DWORD mouseData;
			public WinUser.DWORD dwFlags;
			public WinUser.DWORD time;
			public BaseTSD.ULONG_PTR dwExtraInfo;
			
		}
		
		public static class KEYBDINPUT extends Structure{
			public WinUser.WORD wVk;
			public WinUser.WORD wScan;
			public WinUser.DWORD dwFlags;
			public WinUser.DWORD time;
			public BaseTSD.ULONG_PTR dwExtraInfo;
		}
		
		public static class HARDWAREINPUT extends Structure{
			public WinUser.DWORD Msg;
			public WinUser.WORD wParamL;
			public WinUser.WORD wParamH;
		}
		
		public static class LPINPUT extends Structure{
			public WinUser.DWORD type;
			public static class DUMMYUNIONNAME extends Union{
				public MOUSEINPUT mi;
				public KEYBDINPUT ki;
				public HARDWAREINPUT hi;
			}
		}
	}
	
}
