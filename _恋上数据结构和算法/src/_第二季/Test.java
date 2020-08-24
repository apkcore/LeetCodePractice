package _第二季;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
//        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>(5);
        BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>(1);
//        BlockingQueue<Runnable> queue = new SynchronousQueue<>();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, queue);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true){

                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("3");
            }
        });
    }
}
