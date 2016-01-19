package cc.sharper.xml.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liumin3 on 2016/1/19.
 */
public class DOM4JTest2
{
    public static void main(String[] args)
    {
        SAXReader reader = new  SAXReader();
        try
        {
            Document read = reader.read(new File("src/main/java/Book2.xml"));

            Element rootElement = read.getRootElement();
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext())
            {
                Element next =(Element) iterator.next();

                List<Attribute> list =  next.attributes();

                //获得自己的属性值
                for (Attribute attr : list)
                {
                    System.out.print(attr.getName() + " ");
                    System.out.println(attr.getValue());
                }
                //直接获取属性值
                System.out.println(next.attribute("id").getValue());

                //获得子元素的信息
                Iterator child =  next.elementIterator();
                while (child.hasNext())
                {
                    Element ch = (Element)child.next();
                    System.out.print(ch.getName() + " ");
                    System.out.println(ch.getStringValue());
                }


            }


        } catch (DocumentException e)
        {
            e.printStackTrace();
        }


    }
}
