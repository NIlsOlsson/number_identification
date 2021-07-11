package utils;

import java.util.Random;

public class MathUtils {
	

	
	public static double[][] fillMatrixRandomly(double[][] matrix) {
		Random randomGenerator = new Random();
		randomGenerator.setSeed(0);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0.2*randomGenerator.nextDouble()-0.1;
			}
		}
		return matrix;
	}
	
	public static double[][] matrixProduct(double[][] inputs, double[][] weights) {
		double[][] output = new double[inputs.length][weights.length];
		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[i].length; j++) {
				output[i][j] = dotProduct(inputs[i], weights[j]);
			}
		}
		return output;
	}

	private static double dotProduct(double[] list1, double[] list2) {
		int size = Math.min(list1.length, list2.length);
		double product = 0;
		for (int i = 0; i < size; i++) 
			product += (list1[i]*list2[i]);
		return product;
	}
	
	public static double[][] addArrayToMatrix(double[][] matrix, double[] array) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < array.length; j++) {
				matrix[i][j] += array[j];
			}
		}
		return matrix;
	}
	
	public static double[][] hadamardProduct(double[][] matrix1, double[][] matrix2) {
		assert(matrix1.length == matrix2.length);
		double[][] output = new double[matrix1.length][matrix1[0].length];
		for (int i = 0; i < matrix1.length; i++) {
			output[i] = hadamardProduct(matrix1[i], matrix2[i]);
		}
		return output;
	}
	
	public static double[] hadamardProduct(double[] list1, double[] list2) {
		assert(list1.length == list2.length);
		double[] output = new double[list1.length];
		for (int i = 0; i < list1.length; i++) {
			output[i] = list1[i]*list2[i];
		}
		return output;
	}
	
	public static double[][] subtractMatrices(double[][] matrix1, double[][] matrix2) {
		assert(matrix1.length == matrix2.length);
		assert(matrix1[0].length == matrix2[0].length);
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				matrix1[i][j] -= matrix2[i][j];
			}
		}
		return matrix1;
	}
	
}
