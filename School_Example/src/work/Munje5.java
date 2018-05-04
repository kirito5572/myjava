package work;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

class MunjeExam {
	String[] schoolName = new String[20];
	String[] address = new String[20];
	String[] phone = new String[20];
	int[] numOfTeacher = new int[20];
	int[] numOfstudent = new int[20];
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

		length = parse.countTokens()/ 4;
		for (int i = 0; i < length; i++) {
			schoolName[i] = parse.nextToken();
			address[i] = parse.nextToken();
			phone[i] = parse.nextToken();
			numOfTeacher[i] = Integer.parseInt(parse.nextToken());
			numOfstudent[i] = Integer.parseInt(parse.nextToken());
		}
		//System.out
				//.println("schoolName" + "\t" + "address" + "\t" + "phone" + "\t" + "numOfTeacher" + "\t" + "numOfstudent");
		for (int i = 0; i < length; i++) {
			System.out.println(
					schoolName[i] + "\t" + address[i] + "\t" + phone[i] + "\t" + numOfTeacher[i] + "\t" + numOfstudent[i]);
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
