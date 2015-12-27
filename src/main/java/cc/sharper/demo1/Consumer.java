package cc.sharper.demo1;

/**
 * Created by liumin3 on 2015/12/27.
 */
public class Consumer extends Thread
{
    private int num;// 每次消费的产品数量
    private Storage storage;// 所在放置的仓库
    public Consumer(Storage storage)// 构造函数，设置仓库
    {
        this.storage = storage;
    }

    // 线程run函数
    @Override
    public void run()
    {
        consume(num);
    }
    // 调用仓库Storage的生产函数
    public void consume(int num)
    {
        storage.consume(num);
    }
    public int getNum()
    {
        return num;
    }
    public void setNum(int num)
    {
        this.num = num;
    }
    public Storage getStorage()
    {
        return storage;
    }
    public void setStorage(Storage storage)
    {
        this.storage = storage;
    }
}
