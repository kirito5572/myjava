import java.util.Random;


public class ThreadEx {  
 
	public static void main(String[] args) {
	 
		Rank R = new Rank();//나중에 랭크 기록할때 객채소환
		//스레드 생성 및 선언
		Horse h1 = new Horse("1번",R);
		Horse h2 = new Horse("2번",R);
		Horse h3 = new Horse("3번",R);
		//스레드 스타트
		h1.start();
		h2.start();
		h3.start();
    
 	}
 
}

class Rank {
	int rank = 0;
	 
	synchronized void finishLine(String name)
	{
		 rank +=1;
		 System.out.println(name+"말이"+rank+"등으로 도착했습니다.");
	}
}

class Horse extends Thread{
	//몇번 말 및 거리
	String Hname;
	//나중에 랭크 기록할때 객체 선언
	Rank r = new Rank();
	 
	//Horse h1 = new Horse("1번",R); 했을떄 1번이 name,R이 r로 들어감
	Horse(String Hname, Rank r)
	{
		this.Hname = Hname;
		this.r=r;
	  
	}
	//스레드 실행되는곳
	public void run() {
		int distance = 300;
		Random random = new Random();
		int num;
		
		String str ="-";
		//무한루프 돌림
		while(true)
		{
			//거리가 0이하 되면 while문 빠져나오면서 랭크 등록!
			if(distance <0)
			{
				r.finishLine(Hname);
				break;
			}
			num = random.nextInt(100)+1;
			distance -= num;
			//현실감을 돋보이기 위해 만든 str..
			str += "-";
			System.out.println(str+Hname+"말>> 남은거리"+distance+"m");
			try{
				//예외처리 함수
				Thread.sleep(num);
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
	  
		}
	}
}