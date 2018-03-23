package abstract_ShapeExam;

public class MainClass {

	public static void main(String[] args) {
		YoungJinShip YoungJin = new YoungJinShip();
		System.out.println("최대 탑승 인원 " + YoungJin.passengers() +"명");
		System.out.println("최대 적재량 " + YoungJin.luggage() +"kg");

	}

}
