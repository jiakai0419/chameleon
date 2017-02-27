package chameleon.convertor.image.impl;

import chameleon.convertor.image.ImageConvertor;
import chameleon.strategy.image.ImageStrategy;
import chameleon.strategy.image.impl.NoisyPointStrategy;
import chameleon.utils.ImageFormatDetector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author KaiJia
 * @DATE 2017-02-27
 * @DESC original 2D Graphics
 */
public class OriginalImageConvertor implements ImageConvertor {
    private List<ImageStrategy> strategies = new LinkedList<ImageStrategy>() {
        {
            add(new NoisyPointStrategy());
        }
    };

    public boolean convert(String origFilename, String destFilename) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(origFilename));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        executeStrategies(image);

        try {
            ImageIO.write(image,
                    ImageFormatDetector.detection(origFilename),
                    new File(destFilename));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void executeStrategies(BufferedImage image) {
        for (ImageStrategy strategy : strategies) {
            strategy.execute(image);
        }
    }

}
