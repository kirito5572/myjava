
class Top02 implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<30;i++) {
			System.out.print((Thread.currentThread()).getName() + i + "\t");
		}		
	}
		
}

public class Runnable3Exam {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		Top02 top = new Top02();
		Thread thread01 = new Thread(top,"a");
		Thread thread02 = new Thread(top,"b");
		System.out.println(thread01.getPriority());
		System.out.println(thread02.getPriority());
		thread01.start();
		thread02.start();
		System.out.println("프로그램 종료");
	}
}
