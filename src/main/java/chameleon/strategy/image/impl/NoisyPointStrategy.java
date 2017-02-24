package chameleon.strategy.image.impl;

import chameleon.strategy.image.PNGStrategy;

import java.util.Random;

/**
 * @Author KaiJia
 * @DATE 2017-02-24
 */
public class NoisyPointStrategy implements PNGStrategy {
    private static final int SCALE_MAX = 100;
    private static final int SCALE_MIN = 1;
    private Random random = new Random();

    public void execute(int[][] data, int channels, int bitDepth) {
        int rows = data.length;
        int cols = data[0].length / channels;
        int count = scale(rows, cols);
        while (count-- > 0) {
            int r = random.nextInt(rows);
            int c = random.nextInt(cols);
            for (int i = 0; i < 3; i++) {
                int valueMax = (int) Math.pow(2, bitDepth);
                data[r][c * channels + i] = random.nextInt(valueMax);
            }
        }
    }

    private int scale(int rows, int cols) {
        int r = (rows * cols) / 10000;
        if (r > SCALE_MAX) {
            r = SCALE_MAX;
        }
        if (r < SCALE_MIN) {
            r = SCALE_MIN;
        }
        return r;
    }
}
