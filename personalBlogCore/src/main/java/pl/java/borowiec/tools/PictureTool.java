package pl.java.borowiec.tools;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 13:12:13
 */
public class PictureTool {
	static final Logger LOGGER = LoggerFactory.getLogger(PictureTool.class);
	public static String DEFAULT_FORMAT = "JPG";
	public static int[] widths = new int[] { 100, 200, 300, 400, 500 };

	public static void transformPicture(File file, String path, int[] widths, String formatName) throws IOException {
		String[] fileName = file.getName().split("\\.");
		BufferedImage input = ImageIO.read(file);

		for (Integer width : widths) {
			double rate = (double) width / input.getWidth();
			int toHeight = (int) (input.getHeight() * rate);
			BufferedImage output = new BufferedImage(width, toHeight, input.getType());
			AffineTransformOp at = new AffineTransformOp(AffineTransform.getScaleInstance(rate, rate), null);
			at.filter(input, output);
			ImageIO.write(output, formatName, new File(path + fileName[0] + "_" + width + "." + fileName[1]));

		}
	}

	@SuppressWarnings({ "hiding", "boxing" })
	public static void transformBytesToPicture(String fileName, byte[] bytes, String path, int[] widths, String formatName) throws IOException {

		File file = new File(path + fileName);
		FileUtils.writeByteArrayToFile(file, bytes);
		BufferedImage input = ImageIO.read(new ByteArrayInputStream(bytes));
		for (Integer width : widths) {
			double rate = (double) width / input.getWidth();
			int toHeight = (int) (input.getHeight() * rate);
			BufferedImage output = new BufferedImage(width, toHeight, input.getType());
			AffineTransformOp at = new AffineTransformOp(AffineTransform.getScaleInstance(rate, rate), null);
			at.filter(input, output);
			ImageIO.write(output, formatName, new File(path + fileName + "_" + width + "." + formatName));

		}
	}

}
