package main;

import static utils.MathUtils.*;
import static utils.BackPropagationUtils.*;
import static utils.ArrayUtils.*;

public class DenseLayer extends Layer{
	
	public DenseLayer(int numberOfInputs, int numberOfNeurons) {
		super();
		this.weights = new double[numberOfNeurons][numberOfInputs];
		fillMatrixRandomly(this.weights);
		this.biases = new double[numberOfNeurons];		
	}
	
	public double[][] setErrors(double[][] nextLayerWeights, double[][] nextLayerError) {
		double[][] h1 = transpose(matrixProduct(transpose(nextLayerWeights), nextLayerError));
		double[][] h2 = sigmoidDerivative(weightedValues);
		double[][] output = hadamardProduct(h1, h2);
		errors = copy(output);
		return output;
	}
	
	
	
}
