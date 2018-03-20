package com.lawyee.mycelue.pull;

import android.util.Log;

import com.lawyee.mycelue.vo.Person;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyMondle
 * @Package com.lawyee.mycelue.pull
 * @Description: $todo$
 * @author: YFL
 * @date: 2018/3/15 9:10
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class XmlPullParser {
    public static final String TAG = "=====";
    private Person person;

    public ArrayList<?> getPersion(InputStream xml) {
        ArrayList<Person> mPersons = null;

        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();

            org.xmlpull.v1.XmlPullParser pullParser = xmlPullParserFactory.newPullParser();
            //解析事件类型
            int eventType = pullParser.getEventType();
            pullParser.setInput(xml, "utf-8");
            while (eventType != org.xmlpull.v1.XmlPullParser.END_DOCUMENT) {
                switch (eventType) { //开始元素
                    case org.xmlpull.v1.XmlPullParser.START_DOCUMENT:
                        mPersons=new ArrayList<>();
                        Log.e(TAG, "开始元素");

                        break;
                    //开始标签
                    case org.xmlpull.v1.XmlPullParser.START_TAG:
                        Log.e(TAG, "开始标签"+eventType);
                        if (pullParser.getName().equals("person")){
                            person = new Person();
                            String id = pullParser.getAttributeValue(0);
                            person.setId(Integer.parseInt(id));
                        }else if (pullParser.getName().equals("name")){
                            String name = pullParser.nextText();
                            person.setName(name);
                        }else if (pullParser.getName().equals("age")){
                            String age = pullParser.nextText();
                            person.setAge(Integer.parseInt(age));
                        }

                        break;
                    case org.xmlpull.v1.XmlPullParser.END_TAG:
                        if (pullParser.getName().equals("person")){
                            mPersons.add(person);
                            person=null;
                        }

                        break;
                    default:
                        break;
                }
                eventType = pullParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
             return mPersons;

    }
}
