package qaTest;


public class Polygon {
	/**
	 * Checks if point is inside of polygon
	 * 
	 * @param vertexCount number of vertices
	 * @param vertexX x coordinates of vertices
	 * @param vertexY y coordinates of vertices
	 * @param testX x coordinate of point to test
	 * @param testY y coordinate of point to test
	 * @return true if given point is inside polygon
	 */
	public static boolean isPointInsidePolygon(double[] vertexX, double[] vertexY, double testX,
			double testY) {
		boolean c = false;
		for (int i = 0, j = vertexX.length - 1; i < vertexX.length; j = i++) {
			if (((vertexY[i] > testY) != (vertexY[j] > testY))
					&& (testX < (vertexX[j] - vertexX[i]) * (testY - vertexY[i]) / (vertexY[j] - vertexY[i])
							+ vertexX[i]))
				c = !c;
		}
		return c;
	}
}
