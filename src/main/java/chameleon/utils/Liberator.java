package chameleon.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author KaiJia
 * @DATE 2017-02-27
 */
public class Liberator {
    public static void liberate(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
