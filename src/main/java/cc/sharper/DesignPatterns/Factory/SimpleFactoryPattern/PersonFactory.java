package cc.sharper.DesignPatterns.Factory.SimpleFactoryPattern;

/**
 * Created by liumin3 on 2016/1/20.
 */
public class PersonFactory
{
    public  PersonInterface getPerson(String typeName)
    {
        if ("man".equals(typeName))
        {
            return  new Man();
        }else
        {
            return  new Woman();
        }
    }
}
