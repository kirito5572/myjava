package work;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

class MunjeExam {
	public void readingData(String fname) throws IOException {
		FileReader fr = new FileReader(fname);
		BufferedReader br = new BufferedReader(fr);
		String csvStr = "";
		String tmpStr = "";
		do {
			tmpStr = br.readLine();
			if (tmpStr != null) {
				csvStr += tmpStr + "\t";
			}
		} while (tmpStr != null);
		StringTokenizer parse = new StringTokenizer(csvStr, "\t");
		int length = parse.countTokens()/5;
		String[] schoolName = new String[length];
		String[] address = new String[length];
		String[] phone = new String[length];
		int[] numOfTeacher = new int[length];
		int[] numOftudent = new int[length];

		length = parse.countTokens()/ 4;
		for (int i = 0; i < length; i++) {
			schoolName[i] = parse.nextToken();
			address[i] = parse.nextToken();
			phone[i] = parse.nextToken();
			teacher[i] = parse.nextToken();
			student[i] = parse.nextToken();
		}
		System.out
				.println("Name" + "\t" + "address" + "\t" + "math" + "\t" + "english" + "\t" + "total" + "\t" + "avg");
		for (int i = 0; i < length; i++) {
			System.out.println(
					name[i] + "\t" + address[i] + "\t" + math[i] + "\t" + english[i] + "\t" + total[i] + "\t" + avg[i]);
		}
		fr.close();
		br.close();
	}
}
public class Munje5 {
	
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			MunjeExam me = new MunjeExam();
			me.readingData("munje5.txt");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
