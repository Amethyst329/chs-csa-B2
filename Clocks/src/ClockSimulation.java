
import java.util.ArrayList;

public class ClockSimulation {
	public static void main(String[] args) {
		long day = 86400;
		long week = 604800;
		long month = 2592000;
		long year = 31536000;
		long i=0;
		ArrayList<Clock> clock_list = new ArrayList<Clock>();
		clock_list.add(new Sundial());
		clock_list.add(new CuckooClock());
		clock_list.add(new GrandfatherClock());
		clock_list.add(new AtomicClock());
		clock_list.add(new WristWatch());
		for(int x=0; x<=4; x++) {
			switch(x) {
			case(0):
				System.out.println("Times before start:");
				break;
			case(1):
				System.out.println("After 1 day:");
				i = day;
				break;
			case(2):
				System.out.println("After 1 week:");
				i = week;
				break;
			case(3):
				System.out.println("After 1 month:");
				i = month;
				break;
			case(4):
				System.out.println("After 1 year:");
				i = year;
				break;	
			}
			for(Clock clock_class : clock_list) {
				clock_class.reset();
				for(int b=0; b<i; b++) {
					clock_class.tick();
				}
				
				clock_class.display();
				
			}
			System.out.println();
		}
		
	}
}
