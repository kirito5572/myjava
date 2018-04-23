package _0420;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileStreamExam {
	public static void main(String[] args) {
		byte[] b = new byte[1024];
		try {
			FileInputStream fi = new FileInputStream("tin.txt");
			FileOutputStream fo = new FileOutputStream("tout.txt");
			fi.read(b);
			fo.write(b);
			fo.flush();
			fi.close();
			fo.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
