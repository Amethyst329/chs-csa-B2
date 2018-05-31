package note15OOP;

public class Car extends Auto implements Ford {
	private float maxSpeed = (float) 109.2;
	private float trunkSize = (float)33.56;
	public Car() {
		System.out.println("Create a car.");
		// Set the fuel kind class variable.
		super.fuelKind = FuelType.HYBRID;
	}
	
	public float getTrunkSize() {
		return(trunkSize);
	}
	
	public float getMaxSpeed() {
		return(maxSpeed);
	}
	
	public VehicleClassType vehicleKind() {
		return(VehicleClassType.CAR);
	}
	
	public boolean onStarTest(Ford.ModelNames model) {
		System.out.println("Ford model: " + model);
		return(false);
	}
	
	public void drive(int distance) {
		System.out.println("Simulate driving CAR for " + distance + " miles.");
	}
}
