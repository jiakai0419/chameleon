package chameleon.utils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.FileInputStream;
import java.util.Iterator;

/**
 * @Author KaiJia
 * @DATE 2017-02-27
 */
public class ImageFormatDetector {
    public static String detection(String filename) {
        FileInputStream fis = null;
        ImageInputStream iis = null;
        try {
            fis = new FileInputStream(filename);
            iis = ImageIO.createImageInputStream(fis);

            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
            if (readers.hasNext()) {
                return readers.next().getFormatName();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            Liberator.liberate(iis);
            Liberator.liberate(fis);
        }
    }
}
