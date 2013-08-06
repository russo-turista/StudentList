package ru.student.studentlist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class SQLdatabase extends Activity {
//Водим и сохраняем данные в файл
    final String LOG_TAG = "myLogsSQL";
    TextView textView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> pages = new ArrayList<View>();
         
        View page = inflater.inflate(R.layout.page1, null);
        /*TextView textView = (TextView) page.findViewById(R.id.text_view);
        textView.setText("Страница 1");*/
        pages.add(page);
         
        page = inflater.inflate(R.layout.page, null);
        textView = (TextView) page.findViewById(R.id.text_view);
        textView.setText("Страница 2");
        pages.add(page);
         
        SamplePagerAdapter pagerAdapter = new SamplePagerAdapter(pages);
        ViewPager viewPager = new ViewPager(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(1);     
         
        setContentView(viewPager);
        
        Log.d(LOG_TAG, "Class of view: " + viewPager.getClass().toString());
        /*Log.d(LOG_TAG, "LayoutParams of view is null: " + (lp == null));
        Log.d(LOG_TAG, "Text of view: " + ((TextView) viewPager).getText());*/
    }
}
