package com.example.fumingzhen.text17;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final static String SharedPreferencesFileName="config";
    private final static String Key_LoginDate="LoginDate";
    private final static String Key_LoginName="LoginName";
    private final static String Key_LoginNo="LoginNo";
    private final static String Key_LoginSex="LoginSex";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences(SharedPreferencesFileName,MODE_PRIVATE);
        editor=preferences.edit();
        Button butWrite=(Button)findViewById(R.id.butWrite);
        Button butRead=(Button)findViewById(R.id.butRead);
        butWrite.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
                String strLoginDate=simpleDateFormat.format(new Date());
                editor.putString(Key_LoginDate,strLoginDate);
                editor.putString(Key_LoginName,"付明振");
                editor.putString(Key_LoginNo,"2014011396");
                editor.putString(Key_LoginSex,"男");
                editor.apply();
            }
        });
        butRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strLoginDate=preferences.getString(Key_LoginDate,null);
                String strLoginName=preferences.getString(Key_LoginName,null);
                String strLoginNo=preferences.getString(Key_LoginNo,null);
                String strLoginSex=preferences.getString(Key_LoginSex,null);
                if(strLoginDate!=null){
                    Toast.makeText(MainActivity.this,"姓名："+strLoginName+"  学号："+strLoginNo+"  性别："+strLoginSex+"   记录时间："+strLoginDate,Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(MainActivity.this,"无记录时间",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
