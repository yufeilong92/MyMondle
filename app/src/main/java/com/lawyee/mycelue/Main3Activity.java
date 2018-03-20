package com.lawyee.mycelue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lawyee.mycelue.pull.XmlPullParser;
import com.lawyee.mycelue.vo.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnRead;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();


    }

    private ArrayList<Person> readXML() throws Exception {
        InputStream inputStream = this.getAssets().open("person.xml");
        SaxHelper helper = new SaxHelper();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = parserFactory.newSAXParser();
        saxParser.parse(inputStream, helper);
        inputStream.close();
        return helper.getPerson();


    }

    private void initView() {
        mBtnRead = (Button) findViewById(R.id.btn_read);

        mBtnRead.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
        mTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_read:
                try {
                    ArrayList<Person> people = readXML();
                    Log.e("yfl", "onClick: "+people.size() );
                    String mSti="";
                    for (int i = 0; i < people.size(); i++) {
                        Person person = people.get(i);
                       mSti+=person.getId()+"\n"+person.getAge()+"\n"
                        +person.getName()+"\n";

                    }
                    mTv.setText(mSti.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void pullClick(View view) {
        try {
            InputStream inputStream = getAssets().open("person.xml");
            XmlPullParser xmlPullParser = new XmlPullParser();
            ArrayList<?> persion = xmlPullParser.getPersion(inputStream);
            String mStr="";
            for (int i = 0; i < persion.size(); i++) {
                Person o = (Person) persion.get(i);
                 mStr+=o.getName()+"\n"+o.getId()+"\n"+o.getAge()+"\n";

            }
            Log.e("yfl", "pullClick: "+mStr );
         mTv.setText(mStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
