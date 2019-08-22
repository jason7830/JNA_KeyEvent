package server;
import server.events.*;

public class Run {
	public static void main(String[] args) throws InterruptedException
	{
		//KeyBoardEvent.sendVKey(VirtualKeyCode.VK_VOLUME_MUTE, new int[] {0,2});
		MouseEvent.setAbsPosition(0,0);
		//KeyBoardEvent.sendVKeyEx(new int[] {0x10,'A'});
		//KeyBoardEvent.sendScanKeyEx(new int[] {0x11,0x12,0x2E});
		//KeyBoardEvent.sendScanKey(0x27,new int[] {0});
		//Thread.sleep(5000);
		while(true) {
			Thread.sleep(300);
		}
	}
}
