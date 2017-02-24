package chameleon;

import chameleon.convertor.image.ImageConvertor;
import chameleon.convertor.image.impl.PNGConvertor;


/**
 * @Author KaiJia
 * @DATE 2017-02-24
 */
public class Main {

    public static void main(String[] args) {
        ImageConvertor convertor = new PNGConvertor();
        convertor.convert("/Users/jiakai/Downloads/a.png", "/Users/jiakai/Downloads/b.png");
    }

}
