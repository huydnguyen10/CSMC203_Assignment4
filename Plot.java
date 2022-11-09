
public class Plot {
	private int x, y, width, depth;
	
	public Plot() {
		width = 1;
		depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot) {
		x = otherPlot.x;
		y = otherPlot.y;
		width = otherPlot.width;
		depth = otherPlot.depth;
	}
	
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
	
	
	
	public boolean overlaps(Plot plot) {
//		if (((x<=plot.x && x<=(plot.x+plot.width)) && (y<=plot.y && y<=plot.y+plot.depth)) ||
//		())
		
		
//		int x1 = otherPlot.x;
//		int y1 = otherPlot.y;
//		int w1 = otherPlot.width;
//		int d1 = otherPlot.depth;
		if (this.x >= (plot.x + plot.width)) return false;
		if (this.y >= (plot.y + plot.depth)) return false;
		if ((this.x + width) <= plot.x) return false;
		if ((this.y + depth) <= plot.y) return false;
		
		return true;
	}
	
	public boolean encompasses(Plot plot) {
		if (this.x <= plot.x 
				&& (this.x + this.width) >= (plot.x + plot.width) 
				&& this.y <= plot.y 
				&& (this.y + this.depth) >= (plot.y + plot.depth))  {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return this.x + "," + this.y + "," + this.width + "," + this.depth;
	}
}
