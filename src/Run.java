import com.sun.jna.Native;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinDef.*;
import com.sun.jna.win32.StdCallLibrary;
import java.awt.*;
import java.awt.event.*;


public class Run {
	public static void main(String[] args)
	{
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
	
	}
	public interface user32 extends StdCallLibrary{
		user32 INSTANCE = Native.loadLibrary("user32",user32.class);
		
	}
	
}
