package pl.java.borowiec.tools;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

public final class ImageUtils {

	private ImageUtils() {
	}

	public static BufferedImage getScaledInstance(BufferedImage img, int targetWidth, int targetHeight, Object hint, boolean higherQuality) {
		int type = img.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
		BufferedImage ret = img;
		int w, h;
		if (higherQuality) {

			w = img.getWidth();
			h = img.getHeight();
		} else {

			w = targetWidth;
			h = targetHeight;
		}

		do {
			if (higherQuality && w > targetWidth) {
				w /= 2;
				if (w < targetWidth) {
					w = targetWidth;
				}
			}

			if (higherQuality && h > targetHeight) {
				h /= 2;
				if (h < targetHeight) {
					h = targetHeight;
				}
			}

			BufferedImage tmp = new BufferedImage(w, h, type);
			Graphics2D g2 = tmp.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
			g2.drawImage(ret, 0, 0, w, h, null);
			g2.dispose();

			ret = tmp;
		} while (w != targetWidth || h != targetHeight);

		return ret;
	}

	public static BufferedImage scaleImage(InputStream source, int width) throws Exception {

		InputStream imageStream = new BufferedInputStream(source);
		Image image = ImageIO.read(imageStream);
		image = image.getScaledInstance(width, -1, Image.SCALE_SMOOTH);

		int w = image.getWidth(null);
		int h = image.getHeight(null);
		BufferedImage thumbImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2D = thumbImage.createGraphics();
		g2D.drawImage(image, 0, 0, null);
		g2D.dispose();
		return thumbImage;
	}

	public static BufferedImage scaleImage(Image source, int width, int height) {
		Image image = source.getScaledInstance(width, height, Image.SCALE_SMOOTH);

		int w = image.getWidth(null);
		int h = image.getHeight(null);
		BufferedImage thumbImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2D = thumbImage.createGraphics();
		g2D.drawImage(image, 0, 0, null);
		g2D.dispose();
		return thumbImage;
	}
}