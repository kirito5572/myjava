class DerivedThread extends Thread{

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 50; i++) {
			System.out.println(i+ " \t");
		}
	}

}

public class Thread2Exam {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		DerivedThread d1 = new DerivedThread();
		DerivedThread d2 = new DerivedThread();
		d1.start();
		d2.start();
		System.out.println("프로그램 종료");
	}
}