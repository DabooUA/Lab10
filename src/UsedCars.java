/* Author: Serhiy Bardysh
 * This is a new car class that is taking in formation for used vehicle by inheriting most 
 * of the  from Cars class and adding mileage.  
*/
public class UsedCars extends Cars {
	
	private double mileage;
	
	public UsedCars(String enterMake, String enterModel, int enterYear, double enterPrice, double mileage) {
		super(enterMake, enterModel, enterYear, enterPrice);
		this.mileage = mileage;
		
	}

	public UsedCars(double enterMileage) {
		
		mileage = enterMileage;
		
	}
	
	public UsedCars() {
		mileage = 0.0;
	}
	
	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-10s %-10s %s %5s %1.2f %5s %5s %5s\n",  super.getMake(), super.getModel(), super.getYear(), "---", "$", super.getPrice(), "(Used)", mileage, " miles ");
	}
}
