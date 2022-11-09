
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class represents GFA test cases for a Plot object.
 * 
 * @author Farnaz Eivazi
 * @version 7/11/2022
 * 
 */
public class PlotTestSudent {
	private Plot plot1, plot2, plot5, plot3;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(2, 2, 6, 6);
		plot2 = new Plot(1, 2, 6, 6);
		plot5 = new Plot(3, 4, 4, 3);
		plot3 = new Plot(8, 8, 1, 1);
	}

	@After
	public void tearDown() throws Exception {
		plot1 = plot5 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
		assertFalse(plot3.overlaps(plot5));
	}
	
	@Test
	public void testEncompasses() {
		assertTrue(plot1.encompasses(plot5));
		assertFalse(plot1.encompasses(plot2));
	
	}
	@Test
	public void testToString() {
		assertEquals("3,4,4,3",plot5.toString());
		assertEquals("1,2,6,6", plot2.toString());
	}
}
