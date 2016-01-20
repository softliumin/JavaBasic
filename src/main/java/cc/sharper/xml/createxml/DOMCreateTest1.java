package cc.sharper.xml.createxml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


/**
 * Created by liumin3 on 2016/1/20.
 */
public class DOMCreateTest1
{
    public DocumentBuilder getDocumentBuilder(){
        // 创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 创建DocumentBuilder对象
        DocumentBuilder db =null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;
    }

    /**
     * 生成xml
     */
    public void createXML(){
        DocumentBuilder db = getDocumentBuilder();
        Document document = db.newDocument();
        document.setXmlStandalone(true);
        Element bookstore = document.createElement("bookStore");
        //向bookstore根节点中添加子节点book
        Element book = document.createElement("book");
        Element name = document.createElement("name");
//		name.setNodeValue("小王子");
        name.setTextContent("小王子");

        book.appendChild(name);
        book.setAttribute("id", "1");
        //将book节点添加到bookstore根节点中
        bookstore.appendChild(book);
        //将bookstore节点（已经包含了book）添加到dom树中
        document.appendChild(bookstore);
        //创建TransformerFactory对象
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            //创建Transformer对象
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.transform(new DOMSource(document),new StreamResult(new File("books1.xml")));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DOMCreateTest1 creatXml = new DOMCreateTest1();
        creatXml.createXML();
    }
}
