package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Batch.Builder;

public class BatchGenerator {

	public static List<Batch> splitIntoRandomBatches(List<TestImage> elements, int batchSize) {
		Collections.shuffle(elements);
		List<Batch> batches = new ArrayList<>();
		Batch.Builder batchBuilder = new Builder();
		for (int i = 0; i < elements.size(); i++) {
			batchBuilder.addElement(elements.get(i));
			if (batchBuilder.getSize() == batchSize) {
				batches.add(batchBuilder.build());
				batchBuilder = new Builder();
			}
		}
		return batches;
	}
	
	public static List<Batch> splitIntoOrderedBatches(List<TestImage> elements, int batchSize) {
		List<Batch> batches = new ArrayList<>();
		Batch.Builder batchBuilder = new Builder();
		for (int i = 0; i < elements.size(); i++) {
			batchBuilder.addElement(elements.get(i));
			if (batchBuilder.getSize() == batchSize) {
				batches.add(batchBuilder.build());
				batchBuilder = new Builder();
			}
		}
		return batches;
	}
	
	
}
