package utils;

import java.util.Arrays;

public class ActivationUtils {
	
	public final static double e = Math.E;
	
	public static double[][] reLu(double[][] matrix) {
		for (int i = 0 ; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = Math.max(0, matrix[i][j]);
			}
		}
		return matrix;
	}
	
	public static double[][] sigmoid(double[][] matrix) {
		for (int i = 0 ; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = sigmoid(matrix[i][j]);
			}
		}
		return matrix;
	}
	
	private static double sigmoid(double x) {
		return 1 / (1 + Math.exp(-x));
	}
	
	public static double[] exponentiate(double[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = Math.pow(e, list[i]);
		}
		return list;
	}
	
	public static double[] normalize(double[] list) {
		double sum = Arrays.stream(list).reduce(0.0, Double::sum);
		for (int i = 0; i < list.length; i++) {
			list[i] = list[i]/sum;
		}
		return list;
	}
	
	
	
}
