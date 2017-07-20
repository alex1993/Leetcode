import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Script Created by daidai on 2017/3/11.
 */
public class ThreadTest {
    private static boolean stopRequest;

    public static synchronized void setStopRequest() {
        stopRequest = true;
    }

    public static synchronized boolean getStopRequest() {
        return stopRequest;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            while (!getStopRequest()) {
                i++;
            }
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);
        setStopRequest();
    }
}
