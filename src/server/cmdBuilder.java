package server;

import java.io.*;
public class cmdBuilder {
	private String user ;
	private String workDir ;
	private BufferedReader reader;
	private BufferedWriter writer;
	private Process p;
	public cmdBuilder(String user) {
		this.user= user;
		this.workDir = this.getClass().getClassLoader().getResource(".").getPath().substring(1);
	}
	
	public void runAsUser() {
		try {
			String cmd = "cmd /c chcp 65001 && runas /user:"+user+" && cd "+ workDir + " && java -cp . server.Run";
			System.out.println(cmd);
			p = Runtime.getRuntime().exec(cmd);
			reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		}catch(IOException ioex) {
			ioex.printStackTrace();
		}
	}
	
	public String readLine() throws IOException {
		return reader.readLine();
	}
	
	public String readEOF() throws IOException {
		String s = "";
		String tmp = "";
		do {
			tmp = reader.readLine();
			s += tmp;
		}while(tmp != null);
		return s;
	}
	
	public void writeLine(String cmd) throws IOException {
		writer.write(cmd+"/n");
	}
}
