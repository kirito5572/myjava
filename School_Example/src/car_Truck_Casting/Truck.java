package car_Truck_Casting;

public class Truck extends Car{
	//필드
	public String vendor;
	//생성자
	public Truck(String color, String vendor) {
		super(color);
		this.color = color;
		this.vendor = vendor;
	}
	//메소드
	public void printAll() {
		System.out.println("색상은"+ color +" 이고, 회사는 "+vendor +
				"입니다.");
	}
}
