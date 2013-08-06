package ru.student.studentlist;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

public class SaveAndLoadFile{
//Вводим и сохраняем данные в файл
    
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    
  private void  saveDataFile(String addName, String addLastName, String addFacultet){
      sPref = getPreferences(MODE_PRIVATE);
      Editor ed = sPref.edit();
      ed.putString(SAVED_TEXT, addName);
      ed.commit();
      Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }
}
