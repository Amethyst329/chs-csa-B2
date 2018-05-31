package note15OOP;

public abstract class Auto implements Vehicle {
	public enum FuelType {
		GAS, DIESEL, ELECTRIC, HYBRID
	}
	public int numWheels = 4;
	public FuelType fuelKind;
	public Auto() {
		System.out.println("Create an Auto");
	}
	
	public int getWheelCount() {
		return(numWheels);
	}
	
	public abstract float getMaxSpeed();
	public abstract void drive(int distance);
	public abstract VehicleClassType vehicleKind();
}
