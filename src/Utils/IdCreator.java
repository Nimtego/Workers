package Utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by myasnikov
 * on 23.05.2017.
 */
public class IdCreator {
    private static AtomicLong idCounter = new AtomicLong();
    public static Long createID() {
        return idCounter.getAndIncrement();
    }
}
