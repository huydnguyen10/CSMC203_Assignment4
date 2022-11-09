
public class Property {
	
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	//Constructor: no-args
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.rentAmount = 0.0;
		this.owner = "";
	}
	
	//Constructor: Another constructor to set all attributes to past parameters
	public Property(String propertyName, String city, double rentAmount, String onwer) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = onwer;
		this.plot = new Plot();
	}
	
	//Constructor: Another constructor to set all attributes to past parameters
	public Property(String propertyName, String city, double rentAmount, String onwer, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = onwer;
		this.plot = new Plot(x, y, width, depth);
	}
	
	//Copy constructor
	public Property (Property otherProperty) {
		city = otherProperty.city;
		propertyName = otherProperty.propertyName;
		owner = otherProperty.owner;
		rentAmount = otherProperty.rentAmount;
	}
	
	//Generate getter and setter for all variables
	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return this.rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String onwer) {
		this.owner = onwer;
	}
	
	public Plot getPlot() {
		return this.plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	/*
	 * 3. Represents the information of all the properties in the properties array.
	 */
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
}
