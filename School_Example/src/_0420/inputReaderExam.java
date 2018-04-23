package _0420;

import java.io.InputStreamReader;
import java.io.Reader;

public class inputReaderExam {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			Reader reader = new InputStreamReader(System.in);
			while (true) {
				int i = reader.read();
				if (i == -1)
					break;
				System.out.println((char) i);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println();
	}

}
