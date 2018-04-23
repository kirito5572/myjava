package _0420;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

public class BufferedExam {
	public static void main(String[] args) {
		BufferedInputStream bi = new BufferedInputStream(System.in);
		BufferedOutputStream bo = new BufferedOutputStream(System.out);
		int inputdata;
		try {
			while ((inputdata = bi.read()) != -1) {
				bo.write(inputdata);
			}
			bo.flush();
			bo.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
