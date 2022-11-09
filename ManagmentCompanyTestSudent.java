
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagmentCompanyTestSudent {
	Property sampleProperty;
	Property sample1;
	ManagementCompany mangementCo ; 
	
	@Before
	public void setUp() throws Exception {
		mangementCo= new ManagementCompany("Railey", "555555555",6);
	}

	@After
	public void tearDown() throws Exception {
		mangementCo=null;
	}

	@Test
	public void testAddProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);	
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
		sample1 = new Property("ABC", "Candy", 2500, "Rockville", 7, 7, 2, 2);
		assertEquals(mangementCo.addProperty(sample1), 2, 2);
	}
	
	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);		 
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	
		assertEquals(mangementCo.getPropertiesCount(), 1);
	}

	@Test
	public void testToString() {
//		assertEquals("12,12,6,6", mangementCo.toString());
		assertTrue(mangementCo.toString().contains("Railey"));
		assertTrue(mangementCo.toString().contains("555555555"));
	}
	
	@Test
	public void testGetTotalRent() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);	
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
		sample1 = new Property("ABC", "Candy", 2500, "Rockville", 7, 7, 2, 2);
		assertEquals(mangementCo.addProperty(sample1), 2, 2);
		assertEquals(5113, mangementCo.getTotalRent());
	}
	
	@Test
	public void testGetHighestRentProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);	
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
		sample1 = new Property("ABC", "Candy", 2500, "Rockville", 7, 7, 2, 2);
		assertEquals(mangementCo.addProperty(sample1), 2, 2);
		assertEquals(sampleProperty, mangementCo.getHighestRentPropperty());
	}
	
	@Test
	public void testRemoveLastProperty() {
		sampleProperty = new Property ("Sunsational", "Beckman", 2613, "BillyBob Wilson",2,5,2,2);	
		assertEquals(mangementCo.addProperty(sampleProperty),0,0);	//property has been successfully added to index 0
		sample1 = new Property("ABC", "Candy", 2500, "Rockville", 7, 7, 2, 2);
		assertEquals(mangementCo.addProperty(sample1), 2, 2);
		mangementCo.removeLastProperty();
		assertEquals(1, mangementCo.getNumberOfProperties());
		
		int count = 0;
		for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++){
			if (mangementCo.getProperties()[i] != null) {
				count++;
			}
		}
		assertEquals(1, count);
	}
}
