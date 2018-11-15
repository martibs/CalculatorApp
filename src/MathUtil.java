public class MathUtil {	
	public static long add(long number1,long number2){
		return number1+number2;
	}
	public static long sub(long number1, long number2){
		return number1-number2;
	}
	public static long mul(long number1, long number2){
		return number1*number2;
	}
	public static long div(long number1, long number2){
		if (number2 == 0){
			throw new IllegalArgumentException("Division by zero");
		}
		return number1/number2;
	}
}