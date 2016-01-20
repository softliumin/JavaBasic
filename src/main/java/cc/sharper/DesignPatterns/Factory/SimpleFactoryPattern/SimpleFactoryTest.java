package cc.sharper.DesignPatterns.Factory.SimpleFactoryPattern;

import com.alibaba.fastjson.JSON;

/**
 * Created by liumin3 on 2016/1/20.
 */
public class SimpleFactoryTest
{
    //简单工厂模式  违反高内聚责任分配原则
    public static void main(String[] args)
    {
        PersonFactory personFactory = new PersonFactory();
        PersonInterface person = personFactory.getPerson("man");
        person.sayMySex();

    }
}
