package qaTest;

import org.junit.*;
import org.junit.rules.Timeout;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

public class PolygonTest {
	private Polygon poly;

	@Before
	public void createObject() {
		poly = new Polygon();
	}
	
	@Test
	public void point_inside_polygon() {
		assertEquals("Point inside of polygon", true, poly.isPointInsidePolygon(new double[] {0.0,2.0,2.0,0.0}, new double[] {0.0,0.0,2.0,2.0}, 1.0, 1.0));
	}
	@Test
	public void point_outside_polygon() {
		assertEquals("Point outside of polygon", false, poly.isPointInsidePolygon(new double[] {0.0,2.0,2.0,0.0}, new double[] {0.0,0.0,2.0,2.0}, 3.0, 3.0));
	}
	@Test
	public void point_on_the_line_of_polygon() {
		assertEquals("Point on the line of polygon", false, poly.isPointInsidePolygon(new double[] {0.0,2.0,2.0,0.0}, new double[] {0.0,0.0,2.0,2.0}, 2.0, 0.0));
	}
	@Test
	public void point_on_the_cone_of_polygon() {
		assertEquals("Point on the cone of polygon", false, poly.isPointInsidePolygon(new double[] {0.0,2.0,2.0,0.0}, new double[] {0.0,0.0,2.0,2.0}, 2.0, 2.0));
	}
	@Test
	public void negative_coordinates_of_polygon() {
		assertEquals("Negative coordinates of polygon", true, poly.isPointInsidePolygon(new double[] {-10.0,-2.0,-2.0,-10.0}, new double[] {-1.0,-1.0,-5.0,-5.0}, -4.0, -4.0));
	}
	@Test
	public void only_X_coordinates_of_polygon() {
		assertEquals("Only X coordinates of polygon", false, poly.isPointInsidePolygon(new double[] {}, new double[] {-7.8,-12.4,-11.1,-9.9}, -11.2, -10.1));
	}
	@Test
	public void only_Y_coordinates_of_polygon() {
		assertEquals("Only Y coordinates of polygon", false, poly.isPointInsidePolygon(new double[] {}, new double[] {-7.8,-12.4,-11.1,-9.9}, -11.2, -10.1));
	}
	@Test
	public void all_coordinates_of_poligon_equals_null() {
		assertEquals("Coordinates of polygon equals null", false, poly.isPointInsidePolygon(new double[] {}, new double[] {}, -11.2, -10.1));
	}
	@Test
	public void all_coordinates_of_poligon_equals_0() {
		assertEquals("Coordinates of polygon equals \"0\"", false, poly.isPointInsidePolygon(new double[] {0,0,0}, new double[] {0,0,0}, 0, 0));
	}
	
	

	
}
