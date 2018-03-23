package isLeader;

public class Leader extends Student{
	
	Boolean isLeader;
	public Leader(String name, String hakbun, boolean isLeader) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.hakbun = hakbun;
		this.isLeader = isLeader;
	}
	public void isLeader() {
		// TODO Auto-generated method stub
		if(isLeader)
			System.out.println(name + "은 학급회장입니다.");
	}
	
}
