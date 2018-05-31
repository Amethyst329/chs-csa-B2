package note15OOP;

public class Truck extends Auto {
	private double bedSize = 43.22;
	private float maxSpeed = (float)97.63;
	
	//Write the necessary code for a trunk!
	// It needs to have a method
	// getBedSize() that returns a Double representing 
	//    the square feet of the truck bed.
	
	public Truck() {
		super();
		fuelKind = FuelType.DIESEL;
		System.out.println("Create a Truck");
	}
	
	public double getBedSize() {
		return(bedSize);
	}
	
	public float getMaxSpeed() {
		return(maxSpeed);
	}
	
	public VehicleClassType vehicleKind() {
		return(VehicleClassType.TRUCK);
	}
	
	public void drive(int miles) {
		System.out.println("Simulate driving TRUCK for " + miles + " miles.");
	}
}