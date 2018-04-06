
public class StringStringBuilder {
	public static void main(String[] args) {
		String string;
		StringBuilder stringBuilder;
		
		string = new String("Hello");
		System.out.println("String string: " + string);
		string += " Minsu";
		System.out.println("String string: " + string);
		stringBuilder = new StringBuilder("Hello");
		System.out.println("String stringBuilder: " + stringBuilder);
		stringBuilder.append(" Minsu");
		System.out.println("String stringBuilder: " + stringBuilder);

	}
}
