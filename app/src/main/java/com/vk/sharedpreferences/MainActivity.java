package com.vk.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView tv_name, tv_age;
    private EditText et_name, et_age;
    private Switch sw_gender;
    private Button btn_save, btn_apply;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_name = findViewById(R.id.tv_name);
        tv_age = findViewById(R.id.tv_age);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        sw_gender = findViewById(R.id.sw_gender);
        btn_save = findViewById(R.id.btn_save);
        btn_apply = findViewById(R.id.btn_apply);
        sharedPreferences = this.getSharedPreferences(SharedPref.sharedPrefName, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_name.setText("Name : "+et_name.getText().toString());
                tv_age.setText("Age : "+et_age.getText().toString());
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(SharedPref.studentName, et_name.getText().toString());
                editor.putString(SharedPref.studentAge, et_age.getText().toString());
                editor.putBoolean(SharedPref.studentGender, sw_gender.isChecked());
                editor.commit();
            }
        });

        tv_name.setText("Name : "+sharedPreferences.getString(SharedPref.studentName,""));
        tv_age.setText("Age : "+sharedPreferences.getString(SharedPref.studentAge,""));
        sw_gender.setChecked(sharedPreferences.getBoolean(SharedPref.studentGender,true));

    }
}