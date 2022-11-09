/*
 * Class: CMSC203 
 * Instructor: Prof. Monshi
 * Description: (Give a brief description for each Class)
 * Due: 11/08/2022
 * Platform/compiler: Write an application that lets the user create a 
 * 					management company and add the properties managed by the company to its list. 
 * 					Assume the maximum number of properties handled by the company is 5.
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Duc Huy Nguyen
*/

public class ManagementCompany {
	
	static final int MAX_PROPERTY = 5;
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	private String name;
	private String taxID;
	private double mgmFee;
	private Property [] properties = new Property[MAX_PROPERTY]; 
	private Plot plot;
	private int numberOfProperties;
	
	/*
	 * Constructor: no-args
	 * Creates a ManagementCompany object using empty strings, creates a default Plot 
	 * with maximum width and depth and it initializes the properties array.
	 */
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFee = 0.0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	/**
	 * Constructor: Another constructor to set all attributes to past parameters
	 * Creates a ManagementCompany object using the given values, creates a default Plot 
	 * with maximum width and depth and it initializes the properties array.
	 * @param name		of company
	 * @param taxID		of company
	 * @param mgmFee	of company
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	/**
	 * Constructor: Another constructor to set all attributes to past parameters
	 * Creates a ManagementCompany object using the given values creates a Plot 
	 * using the given values and it initializes the properties array.
	 * 
	 * @param name 		name of management company 
	 * @param taxID		tax ID of management company
	 * @param mgmFee	Management fee of management company
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		this.numberOfProperties = 0;
	}

	/**
	 * Copy constructor
	 * Creates a new ManagementCompany copy of the given ManagementCompany.
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	//Generate getter and setter for all variables
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxID() {
		return this.taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public double getMgmFee() {
		return this.mgmFee;
	}

	public void setMgmFee(double mgmFee) {
		this.mgmFee = mgmFee;
	}
	
	public Property[] getProperties() {
		return this.properties;
	}

	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	public Plot getPlot() {
		return this.plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public int getNumberOfProperties() {
		return this.numberOfProperties ;
	}

	public void setNumberOfProperties(int numberOfProperties) {
		this.numberOfProperties = numberOfProperties;
	}
	
	/*
	 * Represents the information of all the properties in the properties array.
	 * Create variables that temporary hold array from properties then shows out by toString
	 */
	public String toString() {
		String propertiesList = "";
		double totalMgmFee = 0.0;
		for (int i = 0; i < numberOfProperties; i++) {
			propertiesList += properties[i].toString() + "\n";
			totalMgmFee += properties[i].getRentAmount() * (mgmFee / 100);
		}
		return "List of the properties for " + this.name + ", taxID: " + this.taxID + "\n-----------------\n" + propertiesList + 
				"\n---------------\n" + "total management Fee: " + totalMgmFee;
	}
	
	/*
	 * This is an overloaded method which has multiple versions
	 * In each version should call an appropriate existing overloaded method if possible.
	 * 1. If the array is full, it will return -1
	 * 2. o	If the property is null, it will return -2
	 * 3. o	If the plot for the property is not encompassed by the management company plot, it will return -3
	 * 4. If the plot for the property overlaps any other property’s plot, it will return -4
	 * Otherwise if the property is successfully added, it will return the index of the array where the property was added
	 * 
	 * @param name 	of property 	
	 * @param city	where the property is located
	 * @param rent	rent Amount
	 * @param owner	the owner's name
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		if (this.numberOfProperties >= MAX_PROPERTY) {
			return -1;
		}
		
		Property p = new Property(name, city, rent, owner);
		
		if (p.equals(null)) {
			return -2;
		}
		
		if (!this.plot.encompasses(p.getPlot())) {
			return -3;
		}
		
		for (int i = 0; i < this.numberOfProperties; i++) {
			if (this.properties[i].getPlot().overlaps(p.getPlot())) {
				return -4;
			}
		}
		
		this.properties[this.numberOfProperties] = p;
		numberOfProperties++;
		
		return numberOfProperties - 1;
	}
	
	/*
	 * This is an overloaded method which has multiple versions
	 * In each version should call an appropriate existing overloaded method if possible.
	 * 1. If the array is full, it will return -1
	 * 2. o	If the property is null, it will return -2
	 * 3. o	If the plot for the property is not encompassed by the management company plot, it will return -3
	 * 4. If the plot for the property overlaps any other property’s plot, it will return -4
	 * Otherwise if the property is successfully added, it will return the index of the array where the property was added
	 * 
	 * @param name 	of property 	
	 * @param city	where the property is located
	 * @param rent	rent Amount
	 * @param owner	the owner's name
	 * @param x 	The x coordinate of the plot
	 * @param y		The y coordinate of the plot
	 * @param width	The width coordinate of the plot
	 * @param depth	The depth coordinate of the plot
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		if (this.numberOfProperties >= MAX_PROPERTY) {
			return -1;
		}
		
		Property p = new Property(name, city, rent, owner);
		Plot plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		
		if (p.equals(null)) {
			return -2;
		}
		
		if (!this.plot.encompasses(p.getPlot())) {
			return -3;
		}
		
		for (int i = 0; i < this.numberOfProperties; i++) {
			if (this.properties[i].getPlot().overlaps(p.getPlot())) {
				return -4;
			}
		}
		
		this.properties[this.numberOfProperties] = p;
		numberOfProperties++;
		
		return numberOfProperties - 1;
	}
	
	/**
	 * Creates a property object by copying from another property and adds it to the properties array.
	 * This is an overloaded method which has multiple versions
	 * In each version should call an appropriate existing overloaded method if possible.
	 * 1. If the array is full, it will return -1
	 * 2. o	If the property is null, it will return -2
	 * 3. o	If the plot for the property is not encompassed by the management company plot, it will return -3
	 * 4. If the plot for the property overlaps any other property’s plot, it will return -4
	 * Otherwise if the property is successfully added, it will return the index of the array where the property was added
	 *
	 * @param property
	 * @return
	 */
	public int addProperty(Property property) {
		if (this.numberOfProperties >= MAX_PROPERTY) {
			return -1;
		}
		
		//Property p = new Property();
		
		if (property.equals(null)) {
			return -2;
		}
		
		if (!this.plot.encompasses(property.getPlot())) {
			return -3;
		}
		
		for (int i = 0; i < this.numberOfProperties; i++) {
			if (this.properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		
		this.properties[this.numberOfProperties] = property;
		numberOfProperties++;
		
		return numberOfProperties - 1;
	}
	
	/*
	 * Returns the total rent of the properties in the properties array 
	 */
	public double getTotalRent() {
		double totalRent = 0.0;
		for (int i = 0; i<numberOfProperties; i++) {
			if(properties != null) {
				totalRent += properties[i].getRentAmount();
			}
		}
		return totalRent;
	}
	
	/*
	 * Gets the property in the array with the maximum amount of rent
	 * then return the property in the array which has the highest amount of rent
	 */
	public Property getHighestRentPropperty() {
		int idx = 0;
		for (int i = 0; i<numberOfProperties; i++) {
			if (properties[idx].getRentAmount() < properties[i].getRentAmount()) {
				idx = i;
			}
		}
		return properties[idx];
	}
	
	/*
	 * Removes(nullifies) the LAST property in the properties array
	 */
	public void removeLastProperty() {
		Property[] temp = new Property[MAX_PROPERTY];
		for (int i = 0; i < numberOfProperties - 1; i++) {
			temp[i] = this.properties[i];
		}
		this.properties = temp;
		this.numberOfProperties -= 1;
	}

	/*
	 * Checks if the properties array has reached the maximum capacity
	 */
	public boolean isPropertiesFull() {
		if ( this.numberOfProperties >= MAX_PROPERTY) {
			return true;
		}
		return false;
	}
	
	/*
	 * Gets the number of existing properties in the array
	 */
	public int getPropertiesCount() {
		return this.numberOfProperties; 
	}
	
	/*
	 * Checks if the management company has a valid (between 0-100) fee
	 */
	public boolean isMangementFeeValid() {
		return getMgmFee() >=0 && getMgmFee() <= 100;
	}
}
