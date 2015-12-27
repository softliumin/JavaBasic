package cc.sharper.demo2;

/**
 * Created by liumin3 on 2015/12/27.
 */
public class Producer extends Thread
{
    private int num;// 每次生产的产品数量
    private Storage storage;// 所在放置的仓库
    public Producer(Storage storage)// 构造函数，设置仓库
    {
        this.storage = storage;
    }

    // 线程run函数
    public void run()
    {
        produce(num);
    }

    // 调用仓库Storage的生产函数
    public void produce(int num)
    {
        storage.produce(num);
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
