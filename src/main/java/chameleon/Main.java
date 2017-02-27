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
        convertor.convert("a.png", "b.png");
    }

}
