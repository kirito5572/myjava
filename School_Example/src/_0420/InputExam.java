package _0420;

import java.io.IOException;
import java.io.InputStream;

public class InputExam {
	public static void streamTest(InputStream is) {
		int i = 0;	
		while(true) {
			try {
				i = is.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i == -1)	break;
			char c = (char)i;
			System.out.print(c);
		}
	}
	public static void main(String[] args) {
		streamTest(System.in);
	}

}
