public class AtomicClock extends Clock{
	public AtomicClock() {
		super(ClockType.quantum, 0.00);
	}
	public void display() {
		System.out.println("quantum atomic clock: time ["+time.formattedTime() + "], total drift = "+ String.format("%.2f", time.getTotalDrift())); 
	}

	
}
