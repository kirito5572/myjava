class DerivedThread1 extends Thread{

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 50; i++) {
			System.out.println(i+ " \t");
		}
	}

}

public class Runnable2Exam {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		DerivedThread1 d1 = new DerivedThread1();

		Thread thd1 = new Thread(d1);
		Thread thd2 = new Thread(d1);
		thd1.start();
		thd2.start();
		System.out.println("프로그램 종료");
	}
}