package _0420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderExam {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String inputdata = br.readLine();
			System.out.println(inputdata);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
