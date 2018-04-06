package BankExam;

public class Bank {
	private int money = 10000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	public synchronized void saveMoney(int save ) {
		int m = this.getMoney();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setMoney(m+save);
	}
	public synchronized void minusMoney(int minus ) {
		int m = this.getMoney();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setMoney(m-minus);
	}
	
}
