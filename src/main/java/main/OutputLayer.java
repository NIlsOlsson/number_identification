package main;

import static utils.ArrayUtils.copy;
import static utils.MathUtils.*;
import static utils.BackPropagationUtils.*;

public class OutputLayer extends Layer {

	public OutputLayer(int numberOfInputs, int numberOfNeurons) {
		super();
		this.weights = new double[numberOfNeurons][numberOfInputs];
		fillMatrixRandomly(this.weights);
		this.biases = new double[numberOfNeurons];
	}


	public double[][] setErrors(double[][] desiredValues) {
		double[][] output = hadamardProduct(subtractMatrices(activationValues, desiredValues), sigmoidDerivative(weightedValues));
		errors = copy(output);
		return output;
	}

}
