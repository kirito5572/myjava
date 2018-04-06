package BankExam;

public class BankExam {
	public static Bank mybank = new Bank();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("원금 : "+mybank.getMoney());
		Family1 f1 = new Family1();
		Family2 f2 = new Family2();
		f1.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f2.start();
	}

}
