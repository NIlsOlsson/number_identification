package main;

import java.util.List;

import data.Batch;
import data.BatchGenerator;
import data.DataExtractor;
import data.TestImage;

public class Main {

	public static void main(String[] args) {
		DataExtractor dataExtractor = new DataExtractor();
		List<TestImage> trainingImages = dataExtractor.getTrainingImages();
		
		Network network = new Network(new int[] {1024, 30, 10});
		
		for (int i = 0; i < 100; i++) {
			List<Batch> testData = BatchGenerator.splitIntoRandomBatches(trainingImages, 4);
			
			for (Batch batch : testData) {
				network.train(batch, 3);
			}
		}
		
		List<Batch> verificationData = BatchGenerator.splitIntoOrderedBatches(dataExtractor.getVerificationImages(), 11);
		
		network.test(verificationData.get(0));
		
		
	}

}
