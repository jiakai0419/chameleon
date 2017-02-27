package chameleon.strategy.image.impl;

import chameleon.strategy.image.ImageStrategy;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Author KaiJia
 * @DATE 2017-02-27
 */
public class NoisyPointStrategy implements ImageStrategy {
    private static final int SCALE_MIN = 8;
    private static final int SCALE_MAX = 128;
    private static final int SCALE_FACTOR = 10000;
    private Random random = new Random();

    public void execute(BufferedImage image) {
        int count = scale(image.getWidth(), image.getHeight());
        while (count-- > 0) {
            image.setRGB(random.nextInt(image.getWidth()),
                    random.nextInt(image.getHeight()),
                    random.nextInt() & 0xffffff);
        }
    }

    private int scale(int width, int height) {
        int s = width * height / SCALE_FACTOR;
        if (s < SCALE_MIN) {
            s = SCALE_MIN;
        }
        if (s > SCALE_MAX) {
            s = SCALE_MAX;
        }
        return s;
    }
}
