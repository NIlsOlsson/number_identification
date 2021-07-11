package utils;

import data.Batch;

public class BackPropagationUtils {
	
	public static double[][] getDesiredValues(Batch batch) {
		double[][] values = new double[batch.getSize()][10];
		for (int i = 0; i < batch.getSize(); i++) {
			values[i][batch.get(i).getNumber()] = 1;
		}
		return values;
	}
	
	public static double[][] sigmoidDerivative(double[][] matrix) {
		for (int i = 0 ; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = sigmoidDerivative(matrix[i][j]);
			}
		}
		return matrix;
	}
	
	private static double sigmoidDerivative(double x) {
		return sigmoid(x)*(1-sigmoid(x));
	}
	
	private static double sigmoid(double x) {
		return 1 / (1 + Math.exp(-x));
	}
	

	public static double cost(double[][] desiredValues, double[][] actualValues) {
		assert(desiredValues.length == actualValues.length);
		assert(desiredValues[0].length == actualValues[0].length);
		int n = desiredValues.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < desiredValues[0].length; j++) {
				sum += square(desiredValues[i][j] - actualValues[i][j]);
			}
		}
		return sum/(2*n);
	}
	
	private static double square(double x) {
		return x*x;
	}
	
	
	
}
