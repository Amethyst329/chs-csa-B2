

public class GrandfatherClock extends Clock{
	public GrandfatherClock() {
		super(ClockType.mechanical, 0.000347222);
	}
	public void display() {
		System.out.println("mechanical grandfather clock: time ["+time.formattedTime() + "], total drift = "+ String.format("%.2f", time.getTotalDrift())); 

	}
}
