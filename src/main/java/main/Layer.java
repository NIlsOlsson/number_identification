package main;

import static utils.ActivationUtils.*;
import static utils.MathUtils.*;
import static utils.ArrayUtils.*;


public abstract class Layer {
	
	public double[][] weights;
	public double[] biases;
	public double[][] activationValues;
	public double[][] weightedValues;
	public double[][] errors;
	
	public double[][] forward(double[][] inputs) {
		double[][] output = matrixProduct(inputs, weights);
		output = addArrayToMatrix(output, biases);
		weightedValues = copy(output);
		output = sigmoid(output); // Could be reLu
		activationValues = copy(output);
		return output;
	}

	
	public void updateBiases(double learningRate) {
		double[] biasChanges = new double[biases.length];
		for (int i = 0; i < errors.length; i++) {
			for (int j = 0; j < errors[i].length; j++) {
				biasChanges[j] += errors[i][j];
			}
		}
		for (int i = 0; i < biases.length; i++) {
			biases[i] -= learningRate*(biasChanges[i]/errors.length);
		}
	}
	
	public void updateWeights(double[][] previousLayerActivation, double learningRate) {
		double[][] weightChanges = new double[weights.length][weights[0].length];
		for (int testCase = 0; testCase < errors.length; testCase++) {
			for (int neuronIndex = 0; neuronIndex < weights.length; neuronIndex++) {
				for (int inputIndex = 0; inputIndex < weights[0].length; inputIndex++) {
					weightChanges[neuronIndex][inputIndex] += previousLayerActivation[testCase][inputIndex]*errors[testCase][neuronIndex];
				}
			}
		}
		for (int neuronIndex = 0; neuronIndex < weights.length; neuronIndex++) {
			for (int inputIndex = 0; inputIndex < weights[0].length; inputIndex++) {
				weights[neuronIndex][inputIndex] -= learningRate*(weightChanges[neuronIndex][inputIndex]/errors.length);
			}
		}
	}
	
}
