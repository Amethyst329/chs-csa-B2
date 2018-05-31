
public class Sundial extends Clock{
	public Sundial() {
		super(ClockType.natural, 0.00);
	}
	public void display() {
		System.out.println("natural sundial: time ["+time.formattedTime() + "], total drift = "+ String.format("%.2f", time.getTotalDrift())); 
	}
}
