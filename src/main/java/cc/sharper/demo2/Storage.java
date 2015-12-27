package cc.sharper.demo2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liumin3 on 2015/12/27.
 */
public class Storage
{
    private final int MAX_SIZE = 100;// 仓库最大存储量
    private LinkedList<Object> list = new LinkedList<Object>();// 仓库存储的载体

    private final Lock lock = new ReentrantLock();// 锁，独占锁，非公平锁
    private final Condition full = lock.newCondition();// 仓库满的条件变量
    private final Condition empty = lock.newCondition();// 仓库空的条件变量

    // 生产num个产品
    public void produce(int num)
    {
        lock.lock();// 获得锁
        // 如果仓库剩余容量不足
        while (list.size() + num > MAX_SIZE)
        {
            System.out.println( Thread.currentThread().getName()+"【要生产的产品数量】:" + num + "/t【库存量】:" + list.size()
                    + "/t暂时不能执行生产任务!");
            try
            {
                full.await();// 由于条件不满足，生产阻塞
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        // 生产条件满足情况下，生产num个产品
        for (int i = 1; i <= num; ++i)
        {
            list.add(new Object());
        }
        System.out.println(Thread.currentThread().getName()+"【已经生产产品数】:" + num + "/t【现仓储量为】:" + list.size());
        // 唤醒其他所有线程
        full.signalAll();
        empty.signalAll();
        // 释放锁
        lock.unlock();
    }

    // 消费num个产品
    public void consume(int num)
    {
        // 获得锁
        lock.lock();
        // 如果仓库存储量不足
        while (list.size() < num)
        {
            System.out.println(Thread.currentThread().getName()+"【要消费的产品数量】:" + num + "/t【库存量】:" + list.size()
                    + "/t暂时不能执行生产任务!");
            try
            {
                empty.await();// 由于条件不满足，消费阻塞
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        // 消费条件满足情况下，消费num个产品
        for (int i = 1; i <= num; ++i)
        {
            list.remove();
        }
        System.out.println(Thread.currentThread().getName()+"【已经消费产品数】:" + num + "/t【现仓储量为】:" + list.size());
        // 唤醒其他所有线程
        full.signalAll();
        empty.signalAll();

        lock.unlock();// 释放锁
    }

    // set/get方法
    public int getMAX_SIZE()
    {
        return MAX_SIZE;
    }
    public LinkedList<Object> getList()
    {
        return list;
    }
    public void setList(LinkedList<Object> list)
    {
        this.list = list;
    }
}
