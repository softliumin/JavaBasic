package cc.sharper.xml.createxml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * dom方式生成xml文件
 *
 * Created by liumin3 on 2016/1/20.
 */
public class DOMCreateTest2
{
    public static void main(String[] args)
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();

            Document document = builder.newDocument();

            Element bookStore = document.createElement("bookStore");

            Element book = document.createElement("book");
            Element name = document.createElement("name");
            name.setTextContent("Java权威指南");

            book.setAttribute("id","1");
            book.appendChild(name);

            bookStore.appendChild(book);

            Element book2 = document.createElement("book");
            Element name2 = document.createElement("name");

            name2.setTextContent("Python权威指南");
            book2.setAttribute("id","2");
            book2.appendChild(name2);
            bookStore.appendChild(book2);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");//缩进宽度

            transformer.transform(new DOMSource(bookStore),new StreamResult(new File("bookdom.xml")));

        } catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        } catch (TransformerConfigurationException e)
        {
            e.printStackTrace();
        } catch (TransformerException e)
        {
            e.printStackTrace();
        }
    }
}
