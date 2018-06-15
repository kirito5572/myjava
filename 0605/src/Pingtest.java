

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pingtest {
	String ip;
	
	public Pingtest(String ip) {
		
	}
	Object[] ResultPing(String ip) {
		Object[] result = new Object[3];
		String pingCmd = "ping -a " + ip;
		Runtime r = Runtime.getRuntime();
		try {
			Process p = r.exec(pingCmd);
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				Pattern pattern2 = Pattern.compile("Ping\\s+(.+)\\s+\\[");
				Matcher matcher2 = pattern2.matcher(inputLine);
				Pattern pattern = Pattern.compile("(\\d+ms)\\s+TTL=(\\d+)");
				Matcher matcher = pattern.matcher(inputLine);
				if (matcher2.find()) {
					System.out.println(matcher2.group(1));
					result[0] = matcher2.group(1);
				}
				if (matcher.find()) {
					System.out.println(matcher.group(1) + "," + matcher.group(2));
					result[1] = matcher.group(1);
					result[2] = matcher.group(2);
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Pingtest pt = new Pingtest("192.168.0.41");
		pt.ResultPing("192.168.0.41");
	}
}
