package car_Truck;

public class Truck extends Car{
	String vendor;
	Truck(String color ,String vendor){
		super(color);
		this.vendor = vendor;
	}
	void print_Truck() {
		System.out.println(vendor);
	}
}
