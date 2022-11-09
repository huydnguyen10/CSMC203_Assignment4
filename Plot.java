
public class Plot {
	private int x, y, width, depth;
	
	// Constructor no-args (set default Plot with width and depth of 1.)
	public Plot() {
		width = 1;
		depth = 1;
	}
	
	//1. Constructor: Generate constructor to set all attributes to past parameters
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//Copy constructor
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	//2. Generate Getter and setter
	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDepth() {
		return this.depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getWidth() {
		return this.depth;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	/*
	 * 3. Create method overlaps that take Plot instance and determines whether its overlap?
	 * Compare backward by the ways does NOT overlap
	 */
	public boolean overlaps(Plot plot) {
		if (this.x >= (plot.x + plot.width)) return false;
		if (this.y >= (plot.y + plot.depth)) return false;
		if ((this.x + width) <= plot.x) return false;
		if ((this.y + depth) <= plot.y) return false;
		
		return true;
	}
	
	/*
	 * 4. Create a method encompasses that take a Plot instance and determines  
	 * if the given plot is encompassed by (is contained by) this plot. Note that the determination 
	 * should be inclusive, in other words, if an edge lies on the edge of the current plot, this is acceptable.
	 */
	
	public boolean encompasses(Plot plot) {
		if (this.x <= plot.x 
				&& (this.x + this.width) >= (plot.x + plot.width) 
				&& this.y <= plot.y 
				&& (this.y + this.depth) >= (plot.y + plot.depth))  {
			return true;
		}
		return false;
	}
	
	/*
	 * 5. Create a toStrong method that represent a Plot object in the following String format. x,y,width,depth
	 */
	public String toString() {
		return this.x + "," + this.y + "," + this.width + "," + this.depth;
	}
}
