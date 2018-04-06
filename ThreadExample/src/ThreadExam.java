
class Top extends Thread{

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 50; i++) {
			System.out.println(i+ " \t");
		}
	}

}

public class ThreadExam {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		Top d = new Top();
		d.start();
		System.out.println("프로그램 종료");
	}
}
