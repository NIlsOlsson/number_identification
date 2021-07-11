package utils;

public class ArrayUtils {

	public static double[][] floatToDouble(float[][] floatMatrix) {
		double[][] doubleMatrix = new double[floatMatrix.length][floatMatrix[0].length];
		for (int i = 0; i < floatMatrix.length; i++) {
			for (int j = 0; j < floatMatrix[0].length; j++) {
				doubleMatrix[i][j] = floatMatrix[i][j];
			}
		}
		return doubleMatrix;
	}

	public static double[][] transpose(double[][] m) {
		double[][] temp = new double[m[0].length][m.length];
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[0].length; j++)
				temp[j][i] = m[i][j];
		return temp;
	}

	public static double[][] copy(double[][] m) {
		double[][] temp = new double[m.length][m[0].length];
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[0].length; j++)
				temp[i][j] = m[i][j];
		return temp;
	}

}
