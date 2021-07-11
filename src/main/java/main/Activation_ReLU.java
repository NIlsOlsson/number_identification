package main;

import utils.ActivationUtils;

public class Activation_ReLU {
	
	public double[][] forward(double[][] inputs) {
		return ActivationUtils.reLu(inputs);
	}
	
	
	
}
