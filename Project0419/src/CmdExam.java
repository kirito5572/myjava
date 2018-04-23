import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdExam {
	public static void main(String[] args) {
		String[] cmd = new String[3];
		// cmd /c dir
		cmd[0] = "cmd.exe";// command shell
		cmd[1] = "/c";     // Run Command and then terminate
		cmd[2] = "dir";    // directory list command
		try {
			// Runtime.getRuntime().exec(system command);
			// system command https://ss64.com/nt/cmd.html
			Process process = Runtime.getRuntime().exec(cmd);
			// process output processing
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
