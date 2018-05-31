
public class CuckooClock extends Clock{
	public CuckooClock() {
		super(ClockType.mechanical, 0.000694444);
	}
	public void display() {
		System.out.println("mechanical cuckoo clock: time ["+time.formattedTime() + "], total drift = "+ String.format("%.2f", time.getTotalDrift())); 
		
	}
}
