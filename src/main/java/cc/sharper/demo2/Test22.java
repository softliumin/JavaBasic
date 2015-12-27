package cc.sharper.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liumin3 on 2015/12/27.
 */
public class Test22
{
    public static void main(String[] args)
    {
        // 仓库对象
        Storage storage = new Storage();
        // 生产者对象
        Producer p1 = new Producer(storage);
        Producer p2 = new Producer(storage);
        Producer p3 = new Producer(storage);
        Producer p4 = new Producer(storage);
        Producer p5 = new Producer(storage);
        Producer p6 = new Producer(storage);
        Producer p7 = new Producer(storage);

        // 消费者对象
        Consumer c1 = new Consumer(storage);
        Consumer c2 = new Consumer(storage);
        Consumer c3 = new Consumer(storage);

        // 设置生产者产品生产数量
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);


        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(p1);
        pool.execute(p2);
        pool.execute(p3);
        pool.execute(p4);
        pool.execute(p5);
        pool.execute(p6);
        pool.execute(p7);
        pool.execute(c1);
        pool.execute(c2);
        pool.execute(c3);

        pool.shutdown();

    }
}
