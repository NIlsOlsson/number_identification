package data;

public class TestImage {

	private final float[][] pixelValues;
	private final int width;
	private final int height;
	private final int number;
	
	
	public TestImage(float[][] pixelValues, int number) {
		this.pixelValues = pixelValues;
		this.width = pixelValues.length;
		this.height = pixelValues[0].length;
		this.number = number;
	}


	public float[] getPixelValues() {
		float[] oneDimensionalPixelValues = new float[pixelValues.length*pixelValues[0].length];
		for(int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				oneDimensionalPixelValues[height*x + y] = pixelValues[x][y];
			}
		}
		return oneDimensionalPixelValues;
	}

	public int getSize() {
		return pixelValues.length*pixelValues[0].length;
	}

	public int getNumber() {
		return number;
	}
	
	
	
	
}
