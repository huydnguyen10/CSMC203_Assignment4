
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
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFee = 0.0;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		this.numberOfProperties = 0;
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public double getMgmFee() {
		return mgmFee;
	}

	public void setMgmFee(double mgmFee) {
		this.mgmFee = mgmFee;
	}
	
	public Property[] getProperties() {
		return properties;
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
	
	public String toString() {
		String propertiesList = "";
		double totalMgmFee = 0.0;
		for (int i = 0; i < numberOfProperties; i++) {
			propertiesList += properties[i].toString() + "\n";
			totalMgmFee += properties[i].getRentAmount() * (mgmFee / 100);
		}
		
		return this.name + "," + this.taxID + "," + this.mgmFee + "\n-----------------\n" + propertiesList + 
				"\n---------------\n" + "Total management Fee: " + totalMgmFee;
	}
	
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
	
	public double getTotalRent() {
		double totalRent = 0.0;
		for (int i = 0; i<numberOfProperties; i++) {
			if(properties != null) {
				totalRent += properties[i].getRentAmount();
			}
		}
		return totalRent;
	}
	
	public Property getHighestRentPropperty() {
		int idx = 0;
		for (int i = 1; i<numberOfProperties; i++) {
			if (properties[idx].getRentAmount() < properties[i].getRentAmount()) {
				idx = i;
			}
		}
		return properties[idx];
	}
	
	public void removeLastProperty() {
		Property[] temp = new Property[MAX_PROPERTY];
		for (int i = 0; i < numberOfProperties - 1; i++) {
			temp[i] = this.properties[i];
		}
		this.properties = temp;
		this.numberOfProperties -= 1;
	}

	public boolean isPropertiesFull() {
		if ( this.numberOfProperties >= MAX_PROPERTY) {
			return true;
		}
		return false;
	}
	
	public int getPropertiesCount() {
		return this.numberOfProperties; 
	}
	
	public boolean isMangementFeeValid() {
		return getMgmFee() >=0 && getMgmFee() <= 100;
		
	}
}
