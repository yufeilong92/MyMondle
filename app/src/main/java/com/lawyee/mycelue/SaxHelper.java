package com.lawyee.mycelue;

import android.util.Log;

import com.lawyee.mycelue.vo.Person;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue
 * @Description: $todo$
 * @author: YFL
 * @date: 2018/3/14 17:05
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class SaxHelper extends DefaultHandler {

    private ArrayList<Person> mPerson=null;

    public static final String TAG = "SaxHelper.class";
    private Person person;
    //当前解析的元素标签
    private String tagName = null;

    @Override
    public void startDocument() throws SAXException {
        mPerson = new ArrayList<>();
        Log.e(TAG, "开始解析 ");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        Log.e(TAG, "解析完成");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (localName.equals("person")) {
             person = new Person();
            Log.e(TAG, "2222: "+attributes );
            person.setId(Integer.parseInt(attributes.getValue("id")));
            Log.e(TAG, "/startElement: 开始处理person元素/" + localName);
        }
        this.tagName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (this.tagName != null) {
            Log.e(TAG, "characters: "+tagName );
            String s = new String(ch, start, length);
            if (this.tagName.equals("name")) {
                this.person.setName(s);
                Log.e(TAG, tagName+"/处理name元素/"+s);
            } else if (this.tagName.equals("age")) {
                this.person.setAge(Integer.parseInt(s));
                Log.e(TAG, tagName+"/处理age元素内容/"+s);
            }
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (localName.equals("person")) {
            this.mPerson.add(person);
            person = null;
            Log.e(TAG, "处理person元素结束 /"+localName);
        }

        this.tagName = null;
    }

    public ArrayList<Person> getPerson(){
        return mPerson;
    }
}
