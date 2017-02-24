package chameleon.convertor.image.impl;

import ar.com.hjg.pngj.*;
import ar.com.hjg.pngj.chunks.ChunkCopyBehaviour;
import ar.com.hjg.pngj.chunks.PngChunkTextVar;
import chameleon.convertor.image.ImageConvertor;

import java.io.File;
import java.util.Random;

/**
 * @Author KaiJia
 * @DATE 2017-02-24
 */
public class PNGConvertor implements ImageConvertor {
    private Random random = new Random();

    public boolean convert(String origFilename, String destFilename) {
        PngReader reader = null;
        PngWriter writer = null;
        try {
            reader = new PngReader(new File(origFilename));
            System.out.println(reader.toString());
            if (reader.imgInfo.channels < 3) {
                throw new UnsupportedOperationException("This method is for RGB/RGBA images");
            }
            writer = new PngWriter(new File(destFilename), reader.imgInfo, true);
            writer.copyChunksFrom(reader.getChunksList(), ChunkCopyBehaviour.COPY_ALL_SAFE);
            writer.getMetadata().setText(PngChunkTextVar.KEY_Description, "");
            for (int row = 0; row < reader.imgInfo.rows; row++) {
                IImageLine imageLine = reader.readRow();
                if (bingo()) {
                    int[] scanline = ((ImageLineInt) imageLine).getScanline();
                    int c = random.nextInt(reader.imgInfo.cols);
                    for (int i = 0; i < 3; i++) {
                        scanline[c * reader.imgInfo.channels + i] = random.nextInt((int) Math.pow(2, reader.imgInfo.bitDepth));
                    }
                }
                writer.writeRow(imageLine);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (writer != null) {
                writer.end();
            }
            if (reader != null) {
                reader.end();
            }
        }
    }

    private boolean bingo() {
        return random.nextInt(10) == 0;
    }

}
