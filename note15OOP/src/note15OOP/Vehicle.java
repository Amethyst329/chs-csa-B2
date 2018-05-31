package note15OOP;

public interface Vehicle {
	enum VehicleClassType { CAR, TRUCK };
	public float getMaxSpeed();
	public void drive(int distance);
	public VehicleClassType vehicleKind();
}
