package car_Truck;

public class Mainclass {

	public static void main(String[] args) {
		Truck t = new Truck ("White","Hyundai");
		//t.color 호출
		System.out.println(t.color);
		//t.Car("Blue") 생성자 호출 *생성자는 상속할수 없다*
		//t.Car("Blue");
		//t.print_car() 메소드 호출
		t.print_car();

	}

}
