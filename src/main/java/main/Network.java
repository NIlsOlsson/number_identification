package main;

import data.Batch;

import utils.ArrayUtils;

import static utils.BackPropagationUtils.*;

public class Network {

	private final int numberOfHiddenLayers;
	private final DenseLayer[] hiddenLayers;
	private final OutputLayer outputLayer;
	
	public Network(int[] sizes) {
		numberOfHiddenLayers = sizes.length-2;
		hiddenLayers = new DenseLayer[numberOfHiddenLayers];
		for (int i = 1; i <= numberOfHiddenLayers; i++) {
			hiddenLayers[i-1] = new DenseLayer(sizes[i-1], sizes[i]);
		}
		outputLayer = new OutputLayer(sizes[numberOfHiddenLayers], sizes[numberOfHiddenLayers+1]);
	}
	
	public void test(Batch batch) {
		double[][] result = forward(batch);
		for (int i = 0; i < result.length; i++) {
			double best = Double.MIN_VALUE;
			int bestDigit = 0;
			for (int j = 0; j < result[i].length; j++) {
				if (result[i][j] > best) {
					best = result[i][j];
					bestDigit = j;
				}
			}
			System.out.println(bestDigit + " is supposed to be " + batch.get(i).getNumber());
		}
	}
	
	public double[][] forward(Batch batch) {
		double[][] input = ArrayUtils.floatToDouble(batch.getInputs());
		for (int i = 0; i < numberOfHiddenLayers; i++) {
			input = hiddenLayers[i].forward(input);
		}
		input = outputLayer.forward(input);
		return input;
	}
	
	public void propagateBack(Batch batch) {
		outputLayer.setErrors(getDesiredValues(batch));
		hiddenLayers[numberOfHiddenLayers-1].setErrors(outputLayer.weights, outputLayer.errors);
		for (int i = (numberOfHiddenLayers-2); i >= 0; i--) {
			hiddenLayers[i].setErrors(hiddenLayers[i+1].weights, hiddenLayers[i+1].errors);
		}
	}
	
	public void updateBiases(double learningRate) {
		outputLayer.updateBiases(learningRate);
		for (int i = 0; i < numberOfHiddenLayers; i++) {
			hiddenLayers[i].updateBiases(learningRate);
		}
	}
	
	public void updateWeights(Batch batch, double learningRate) {
		hiddenLayers[0].updateWeights(ArrayUtils.floatToDouble(batch.getInputs()), learningRate);
		for (int i = 1; i < numberOfHiddenLayers; i++) {
			hiddenLayers[i].updateWeights(hiddenLayers[i-1].activationValues, learningRate);
		}
		outputLayer.updateWeights(hiddenLayers[numberOfHiddenLayers-1].activationValues, learningRate);
	}

	public void train(Batch trainingData, double learningRate) {
		forward(trainingData);
		propagateBack(trainingData);
		updateBiases(learningRate);
		updateWeights(trainingData, learningRate);
	}

}
