package data;

import java.util.ArrayList;
import java.util.List;

public class Batch {
	
	public static class Builder {
		private List<TestImage> testImages = new ArrayList<>();
		
		public Builder addElement(TestImage testImage) {
			testImages.add(testImage);
			return this;
		}
		
		public int getSize() {
			return testImages.size();
		}
		
		public Batch build() {
			return new Batch(testImages);
		}
		
	}

	private final List<TestImage> elements;
	
	private Batch(List<TestImage> elements) {
		this.elements = elements;
	}
	
	public int getSize() {
		return elements.size();
	}
	
	public TestImage get(int index) {
		return elements.get(index);
	}
	
	public List<TestImage> getAll() {
		return elements;
	}
	
	public float[][] getInputs() {
		float[][] input = new float[getSize()][get(0).getSize()];
		
		for (int i = 0; i < getSize(); i++) {
			input[i] = get(i).getPixelValues();
		}
		
		return input;
	}
	
}
