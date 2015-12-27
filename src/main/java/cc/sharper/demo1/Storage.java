package cc.sharper.demo1;

import java.util.LinkedList;

/**
 * Created by liumin3 on 2015/12/27.
 */
public class Storage
{
    private final int MAX_SIZE = 100;// 仓库最大存储量
    private LinkedList<Object> list = new LinkedList<Object>();// 仓库存储的载体

    public void produce(int num)// 生产num个产品
    {
        // 同步代码段
        synchronized (list)
        {
            while (list.size() + num > MAX_SIZE)// 如果仓库剩余容量不足
            {
                System.out.println("【要生产的产品数量】:" + num + " \t【库存量】:" + list.size() + "\t暂时不能执行生产任务!");
                try
                {
                    list.wait();// 由于条件不满足，生产阻塞,释放对象锁
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= num; ++i)// 生产条件满足情况下，生产num个产品
            {
                list.add(new Object());
            }
            System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
            list.notifyAll();//唤醒对象上的所有线程
        }
    }

    public void consume(int num)// 消费num个产品
    {
        synchronized (list)// 同步代码段
        {
            while (list.size() < num)// 如果仓库存储量不足
            {
                System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行生产任务!");
                try
                {
                    list.wait();// 由于条件不满足，消费阻塞
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <= num; ++i)// 消费条件满足情况下，消费num个产品
            {
                list.remove();
            }
            System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
            list.notifyAll();
        }
    }

    // get/set方法
    public LinkedList<Object> getList()
    {
        return list;
    }

    public void setList(LinkedList<Object> list)
    {
        this.list = list;
    }

    public int getMAX_SIZE()
    {
        return MAX_SIZE;
    }
}
