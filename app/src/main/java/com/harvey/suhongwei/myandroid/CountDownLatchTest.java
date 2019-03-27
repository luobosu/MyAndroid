package poetrylove.shw.com.poetrylove.test;


import com.harvey.suhongwei.myandroid.PersonHelper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    private static ExecutorService executor = Executors.newCachedThreadPool();
    public static void main(String[] args){
        Param param = new Param();
        Runnable a = new ARunnable(param);
        Runnable b = new BRunnable(param);
        Runnable c = new CRunnable(param);
        executor.execute(a);
        executor.execute(b);
        executor.execute(c);

        try {
            param.countDownLatch.await();
            System.out.println(Thread.currentThread().getId()+"\t"+param.a+"\t"+param.b+"\t"+param.c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static class Param{
        public volatile CountDownLatch countDownLatch = new CountDownLatch(3);

        public volatile int a;
        public volatile int b;
        public volatile int c;
    }

    public static class ARunnable implements Runnable{
        private Param param;

        public ARunnable(Param param) {
            this.param = param;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            param.a = 10;

            System.out.println(Thread.currentThread().getId()+"\t"+param.a+"\t"+param.b+"\t"+param.c);
            param.countDownLatch.countDown();
        }
    }

    public static class BRunnable implements Runnable{

        private Param param;

        public BRunnable(Param param) {
            this.param = param;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            param.b = 3;
            System.out.println(Thread.currentThread().getId()+"\t"+param.a+"\t"+param.b+"\t"+param.c);
            param.countDownLatch.countDown();
        }
    }

    public static class CRunnable implements Runnable{
        private Param param;

        public CRunnable(Param param) {
            this.param = param;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            param.c = 4;
            System.out.println(Thread.currentThread().getId()+"\t"+param.a+"\t"+param.b+"\t"+param.c);
            param.countDownLatch.countDown();
        }
    }
}
