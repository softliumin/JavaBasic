package cc.sharper.xml.sax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by liumin3 on 2016/1/19.
 */
public class SaxHandler extends DefaultHandler
{
    String value = null;

    @Override
    public void startDocument() throws SAXException
    {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException
    {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        super.startElement(uri, localName, qName, attributes);


    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        super.endElement(uri, localName, qName);


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if (!value.trim().equals(""))
        {
            System.out.println("" + value);
        }


    }
}
