package BankExam;

public class Family1 extends Thread {
	public void run() {
		synchronized(BankExam.mybank) {
			BankExam.mybank.saveMoney(5000);
		}
		System.out.println("saveMoney(5000)" + BankExam.mybank.getMoney());
	}
}
