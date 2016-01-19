package cc.sharper.xml.jdom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by liumin3 on 2016/1/19.
 */
public class JDOMTest2
{
    public static void main(String[] args)
    {
        SAXBuilder saxBuilder =  new SAXBuilder();
        try
        {
            InputStream in = new FileInputStream("src/main/java/Book2.xml");
            Document build = saxBuilder.build(in);
            Element rootElement = build.getRootElement();

            List<Element> bookList =  rootElement.getChildren();
            for (Element book : bookList)
            {
                String id =  book.getAttributeValue("id");//获取自己的特有属性值
                System.out.println(id);

                //循环获取自身属性
                for (Attribute attribute : book.getAttributes())
                {
                    System.out.print(attribute.getName()+" ");
                    System.out.println(attribute.getValue());
                }

            }

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (JDOMException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
