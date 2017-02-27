package chameleon;

import chameleon.convertor.image.ImageConvertor;
import chameleon.convertor.image.impl.OriginalImageConvertor;

/**
 * @Author KaiJia
 * @DATE 2017-02-24
 */
public class Main {

    public static void main(String[] args) {
        ImageConvertor convertor = new OriginalImageConvertor();
        convertor.convert("qrcode.png", "qrcode_alpha.png");
        convertor.convert("panda.jpg", "panda_alpha.jpg");
    }

}
