package cc.sharper.xml.jdom;

import cc.sharper.xml.sax.entity.Book;
import com.alibaba.fastjson.JSON;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liumin3 on 2016/1/19.
 */
public class JDOMTest2
{
    private  static ArrayList<Book> listBook = new ArrayList<Book>();

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
                Book book1 = new Book();
                String id =  book.getAttributeValue("id");//获取自己的特有属性值
                System.out.println(id);
                book.getAttributeValue("id");

                //循环获取自身属性
                for (Attribute attribute : book.getAttributes())
                {
                    System.out.print(attribute.getName() + " ");
                    System.out.println(attribute.getValue());
                }

                //循环获取子节点内容

                for (Element element : book.getChildren())
                {
                    System.out.print(element.getName() + " ");
                    System.out.println(element.getValue());
                    if(element.getName().equals("name"))
                    {
                        book1.setName(element.getValue());
                    }else if (element.getName().equals("language"))
                    {
                        book1.setLanguage(element.getValue());
                    }else if(element.getName().equals("author"))
                    {
                        book1.setAuthor(element.getValue());
                    }else if(element.getName().equals("year"))
                    {
                        book1.setYear(element.getValue());
                    }else if(element.getName().equals("price"))
                    {
                        book1.setPrice(element.getValue());
                    }


                }
                listBook.add(book1);
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

        System.out.println(JSON.toJSONString(listBook));

    }
}
