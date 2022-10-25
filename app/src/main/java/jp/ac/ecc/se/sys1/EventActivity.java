package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        //呼び元画面から送られてきたintent情報を入手
        Intent intent = getIntent();
        int age = intent.getIntExtra("age",25);
        //確認
        Toast.makeText(this,"年齢"+age,Toast.LENGTH_SHORT).show();

        TextView textProfile = findViewById(R.id.profile2);
        EditText nameText = findViewById(R.id.textname1);
        EditText passText = findViewById(R.id.NumPass);
        Button clearN = findViewById(R.id.clearN);
        Button clearP = findViewById(R.id.clearP);
        CheckBox age1 = findViewById(R.id.age1);
        CheckBox age2 = findViewById(R.id.age2);
        CheckBox age3 = findViewById(R.id.age3);
        RadioButton man = findViewById(R.id.man);
        RadioButton woman = findViewById(R.id.woman);
        Button confirmButton = findViewById(R.id.confirmButton);

        clearN.setOnClickListener(this);
        clearP.setOnClickListener(this);

        confirmButton.setOnClickListener(this);
        confirmButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(man.isChecked()==true){
                    Toast.makeText(getApplicationContext(),"男",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"女",Toast.LENGTH_SHORT).show();
                }
                finish();

                return false;
            }
        });

        clearP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                setTitle(passText.getText());
                return false;
            }
        });

    }

    @Override
    public void onClick(View view) {
        EditText nameText = findViewById(R.id.textname1);
        EditText passText = findViewById(R.id.NumPass);
        switch (view.getId()){
            case R.id.clearN:
                nameText.setText("");
                break;
            case R.id.clearP:
                passText.setText("");
                setTitle("練習アプリ");
                break;
            case R.id.confirmButton:
                Toast.makeText(this,nameText.getText(),Toast.LENGTH_SHORT).show();

        }
    }
}