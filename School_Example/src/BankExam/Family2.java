package BankExam;

public class Family2 extends Thread {
	public void run() {
		synchronized(BankExam.mybank) {
			BankExam.mybank.minusMoney(2000);
		}
		System.out.println("minusMoney(2000)" + BankExam.mybank.getMoney());
	}
}
