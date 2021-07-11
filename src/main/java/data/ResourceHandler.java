package data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class ResourceHandler {

	public static float[][] getNumericImage(Path filePath){
		BufferedImage image = getImage(filePath);
		int width = image.getWidth();
		int height = image.getHeight();
		float[][] numericImage = new float[width][height];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				numericImage[x][y] = getGrayscale(image.getRGB(x, y));
			}
		}
		return numericImage;
	}
	
	private static float getGrayscale(int rgbValue) {
		int r = (rgbValue >> 16) & 0xFF;
		int g = (rgbValue >> 8) & 0xFF;
		int b = (rgbValue & 0xFF);
		return (float)(1-((r + g + b) / 3)/255.0);
	}
	
	private static BufferedImage getImage(Path filePath) {
		try {
			return ImageIO.read(new File(filePath.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	private static void printArray(float[][] array) {
//		for (int i = 0; i < array[0].length; i++) {
//			for (int j = 0; j < array.length; j++) {
//				System.out.print(getFixedLength(String.valueOf(array[j][i])));
//			}
//			System.out.println();
//		}
//	}
//
//	private static String getFixedLength(String s) {
//		while (s.length() < 10) {
//			s += " ";
//		}
//		return s;
//	}
	
}
