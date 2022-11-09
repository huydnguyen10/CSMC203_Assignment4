
public class Property {
	
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property() {
		this.propertyName = "";
		this.city = "";
		this.rentAmount = 0.0;
		this.owner = "";
	}
	
	public Property(String propertyName, String city, double rentAmount, String onwer) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = onwer;
		this.plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String onwer, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = onwer;
		this.plot = new Plot(x, y, width, depth);
	}
	
	public Property (Property otherProperty) {
		city = otherProperty.city;
		propertyName = otherProperty.propertyName;
		owner = otherProperty.owner;
		rentAmount = otherProperty.rentAmount;
	}
	
	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String onwer) {
		this.owner = onwer;
	}
	
	public String toString() {
		return propertyName + "," + city + "," + owner + "," + rentAmount ;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
}
