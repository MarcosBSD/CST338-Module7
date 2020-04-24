package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
{

   TextView tvCourseDesc;
   Button btnSubmit;
   EditText etCourseNumber;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Log.d("Life Cycle Event: ", "In onCreate()");

      tvCourseDesc = findViewById(R.id.tvCourseDesc);
      btnSubmit = findViewById(R.id.btnCourseNumber);
      etCourseNumber = findViewById(R.id.etCourseNumber);

      final String[] courseNumber = {"300", "311", "325", "334", "336", "338", "363",
            "370", "383"};
      String[] courseName = {getString(R.string.name300),
            getString(R.string.name311),
            getString(R.string.name325), getString(R.string.name334),
            getString(R.string.name336), getString(R.string.name338),
            getString(R.string.name363), getString(R.string.name370),
            getString(R.string.name383)};
      final String[] courseDesc = {getString(R.string.desc300),
            getString(R.string.desc311), getString(R.string.desc325),
            getString(R.string.desc334), getString(R.string.desc336),
            getString(R.string.desc338), getString(R.string.desc363),
            getString(R.string.desc370), getString(R.string.desc383)};

      ArrayList<Map<String, Object>> itemDataList = new ArrayList<>();

      int titleLen = courseNumber.length;
      for (int i = 0; i < titleLen; i++)
      {
         Map<String, Object> listItemMap = new HashMap<>();
         listItemMap.put("title", courseNumber[i]);
         listItemMap.put("description", courseName[i]);
         itemDataList.add(listItemMap);
      }

      SimpleAdapter simpleAdapter = new SimpleAdapter(this,
            itemDataList, android.R.layout.simple_list_item_2,
            new String[]{"title", "description"},
            new int[]{android.R.id.text1, android.R.id.text2});

      ListView listView = (ListView) findViewById(R.id.class_list);
      listView.setAdapter(simpleAdapter);

      btnSubmit.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View view)
         {
            String enteredNumber = etCourseNumber.getText().toString();
            int currentIndex = 0;
            boolean found = false;
            for (String element:courseNumber) {
               if ( element.equals( enteredNumber )) {
                  found = true;
                  break;
               }
               currentIndex++;
            }
            if (found) {
               tvCourseDesc.setText(courseDesc[currentIndex]);
            }
            else {
               tvCourseDesc.setText("Invalid Course Number");
            }

         }
      });

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view,
                                 int position, long id)
         {
            tvCourseDesc.setText(courseDesc[position]);
         }
      });
   }

   @Override
   protected void onStart()
   {
      super.onStart();
      Log.d("Life Cycle Event: ", "In onStart()");
   }

   @Override
   protected void onResume()
   {
      super.onResume();
      Log.d("Life Cycle Event: ", "In onResume()");
   }

   @Override
   protected void onPause()
   {
      super.onPause();
      Log.d("Life Cycle Event: ", "In onPause()");
   }

   @Override
   protected void onStop()
   {
      super.onStop();
      Log.d("Life Cycle Event: ", "In onStop()");
   }

   @Override
   protected void onDestroy()
   {
      super.onDestroy();
      Log.d("Life Cycle Event: ", "In onDestroy()");
   }

   @Override
   protected void onRestart()
   {
      super.onRestart();
      Log.d("Life Cycle Event: ", "In onRestart()");
   }
}
