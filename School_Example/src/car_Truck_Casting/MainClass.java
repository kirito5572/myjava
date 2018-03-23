package car_Truck_Casting;

public class MainClass {
	public static void main(String[] args) {
		Car truck = new Truck("Red", "Hyundai");
		Truck truck02 = (Truck)truck;
		truck02.printAll();
	}
}
