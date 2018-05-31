
public class WristWatch extends Clock{
	public WristWatch() {
		super(ClockType.digital, 0.000034722);
	}
	public void display() {
		System.out.println("digital wrist watch: time ["+time.formattedTime() + "], total drift = "+ String.format("%.2f", time.getTotalDrift())); 

	}
}
