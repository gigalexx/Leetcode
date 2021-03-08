package algorithms;

import java.util.concurrent.atomic.AtomicInteger;

public class VisibilityDemonstration {


    private final static Object LOCK = new Object();
    private static final AtomicInteger sCount = new AtomicInteger(0);

    public static void main(String[] args) {
        new Consumer().start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            return;
        }
        new Producer().start();
    }

    static class Consumer extends Thread {
        @Override
        public void run() {

            int localValue = -1;
            while (true) {
//                synchronized (LOCK) {
                if (localValue != sCount.get()) {
                    System.out.println("Consumer: detected count change " + sCount.get());
                    localValue = sCount.get();
                }
                if (sCount.get() >= 5) {
                    break;
                }
//                }
            }
            System.out.println("Consumer: terminating");
        }
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
//                synchronized (LOCK) {
                if (sCount.get() >= 5) break;
                int localValue = sCount.get();
                localValue++;
                System.out.println("Producer: incrementing count to " + localValue);
                sCount.set(localValue);
//                }
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    return;
//                }
            }
            System.out.println("Producer: terminating");
        }
    }


}
