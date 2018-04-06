import java.util.Random;


public class ThreadEx {  
 
	public static void main(String[] args) {
	 
		Rank R = new Rank();//���߿� ��ũ ����Ҷ� ��ä��ȯ
		//������ ���� �� ����
		Horse h1 = new Horse("1��",R);
		Horse h2 = new Horse("2��",R);
		Horse h3 = new Horse("3��",R);
		//������ ��ŸƮ
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
		 System.out.println(name+"����"+rank+"������ �����߽��ϴ�.");
	}
}

class Horse extends Thread{
	//��� �� �� �Ÿ�
	String Hname;
	//���߿� ��ũ ����Ҷ� ��ü ����
	Rank r = new Rank();
	 
	//Horse h1 = new Horse("1��",R); ������ 1���� name,R�� r�� ��
	Horse(String Hname, Rank r)
	{
		this.Hname = Hname;
		this.r=r;
	  
	}
	//������ ����Ǵ°�
	public void run() {
		int distance = 300;
		Random random = new Random();
		int num;
		
		String str ="-";
		//���ѷ��� ����
		while(true)
		{
			//�Ÿ��� 0���� �Ǹ� while�� ���������鼭 ��ũ ���!
			if(distance <0)
			{
				r.finishLine(Hname);
				break;
			}
			num = random.nextInt(100)+1;
			distance -= num;
			//���ǰ��� �����̱� ���� ���� str..
			str += "-";
			System.out.println(str+Hname+"��>> �����Ÿ�"+distance+"m");
			try{
				//����ó�� �Լ�
				Thread.sleep(num);
			} catch(Exception e){
				System.out.println(e.getMessage());
			}
	  
		}
	}
}