package ru.student.studentlist;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

    final String LOG_TAG = "myLogs";
    TextView textView;
    
    EditText addName;
    EditText addLastName;
    EditText addFacultet;
    
    Button btnSave, btnLoad;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> pages = new ArrayList<View>();
         
        View page = inflater.inflate(R.layout.page1, null);
        
        addName = (EditText) findViewById(R.id.addName);
        addLastName = (EditText) findViewById(R.id.addLastName);
        addFacultet = (EditText) findViewById(R.id.addFacultet);
        
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
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
    @Override
    public void onClick(View arg0) {
        sPref = getPreferences(MODE_PRIVATE);
        if (arg0.getId() == R.id.btnSave){
            saveDataFile(addName.getText(), addLastName.getText(), addFacultet.getText());
        }
    }
}
