package p_100;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ship Boat = new Boat();
		Ship Yacht = new Yacht();
		System.out.println("요트의 최대 속도 : "+Yacht.maxSpeed()+"노트");
		System.out.println("요트의 탑승 인원 : "+Yacht.passenger()+"명");
		System.out.println("보트의 최대 속도 : "+Boat.maxSpeed()+"노트");
		System.out.println("보트의 탑승 인원 : "+Boat.passenger()+"명");
	}

}
