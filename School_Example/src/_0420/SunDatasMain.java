package _0420;

import java.io.*;
import java.util.StringTokenizer;

class SungDatasExam {
	int length;
	String[] name = new String[10];
	String[] address = new String[10];
	double[] math = new double[10];
	double[] english = new double[10];
	double[] total = new double[10];
	double[] avg = new double[10];

	public void writingData(String fname, boolean addend) throws IOException {
		FileWriter fw = new FileWriter(fname);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(
					"Name" + "\t" + "address" + "\t" + "math" + "\t" + "english" + "\t" + "total" + "\t" + "avg");
		bw.newLine();
		for (int i = 0; i < length; i++) {
			bw.write(
					name[i] + "\t" + address[i] + "\t" + math[i] + "\t" + english[i] + "\t" + total[i] + "\t" + avg[i]);
			bw.newLine();
		}
		bw.close();
		fw.close();
	}

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

		length = parse.countTokens()/ 4;
		for (int i = 0; i < length; i++) {
			name[i] = parse.nextToken();
			address[i] = parse.nextToken();
			math[i] = Double.parseDouble(parse.nextToken());
			english[i] = Double.parseDouble(parse.nextToken());
			total[i] = math[i] + english[i];
			avg[i] = total[i] / 2.0;
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

public class SunDatasMain {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			SungDatasExam wd = new SungDatasExam();
			wd.readingData("writed.txt");
			wd.writingData("writing.txt", false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
