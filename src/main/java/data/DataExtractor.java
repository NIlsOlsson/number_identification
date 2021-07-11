package data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataExtractor {
	
	public List<TestImage> getVerificationImages() {
		List<TestImage> verificationImages = new ArrayList<>();
		try {
			Files.list(Paths.get("src", "main", "resources", "verification_images")).forEach(directory -> verificationImages.addAll(getTestImagesInDirectory(directory)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return verificationImages;
	}
	
	public List<TestImage> getTrainingImages() {
		List<TestImage> testImages = new ArrayList<>();
		try {
			Files.list(Paths.get("src", "main", "resources", "number_images")).forEach(directory -> testImages.addAll(getTestImagesInDirectory(directory)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return testImages;
	}
	
	private List<TestImage> getTestImagesInDirectory(Path directory) {
		List<TestImage> testImages = new ArrayList<>();
		try {
			Files.list(directory).forEach(file -> {
				testImages.add(new TestImage(ResourceHandler.getNumericImage(file), Integer.parseInt(directory.getFileName().toString())));
			});
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return testImages;
	}
	
}
