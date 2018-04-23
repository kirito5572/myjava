package _0420;

import java.io.IOException;

public class Echo2Exam {
	public static void main(String[] args) {
		int bt;
		try {
			while((bt = System.in.read()) != -1) {
				System.out.println((char)bt);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
