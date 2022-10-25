package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        //  このアプリの情報を保存するファイルをprefに設定
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);
        //画面のパーツを
        EditText comment =findViewById(R.id.comment);
        Button saveButton = findViewById(R.id.saveButton);
        Button cancelButtton = findViewById(R.id.cancelButton);
        Button resetButton = findViewById(R.id.resetButton);
        String[]menu = {"dry","cutlet","cheese","soup","memo"};

        //前画面からの情報を受け取る
        Intent intent = getIntent();
        int curry = intent.getIntExtra("curry",4);


        String commentSt= pref.getString(menu[curry],"");
        comment.setText(commentSt);
        SharedPreferences.Editor editor = pref.edit();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SharedPreferences.Editor editor = pref.edit();
                editor.putString(menu[curry],comment.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(),"保存しました",Toast.LENGTH_SHORT).show();

            }
        });
        cancelButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"終了します",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("memo",null);
                editor.apply();
                Toast.makeText(getApplicationContext(),"リセットしました",Toast.LENGTH_SHORT).show();

                comment.setText(null);
            }
        });
    }
}