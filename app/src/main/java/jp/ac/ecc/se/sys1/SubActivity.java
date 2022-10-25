package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_const2);
        setContentView(R.layout.activity_const);
        setTitle("練習アプリ");
        //画面上のパーツ宣言部
        TextView nameLabel = findViewById(R.id.nameLabel);
        EditText nameText = findViewById(R.id.nameText2);
        Button clearButton = findViewById(R.id.Clearbutton);
        Button ConfirmButton = findViewById(R.id.ConfirmButton);
        Button SendButton = findViewById(R.id.SendButton);

        nameLabel.setText("Name");

        SendButton.setOnClickListener(this);
        ConfirmButton.setOnClickListener(this);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
            }
        });


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,EventActivity.class);
        //setTitle("Button Clicked!");

        switch (view.getId()){
            case R.id.ConfirmButton:
                Toast.makeText(this,"確認ボタン　押した",Toast.LENGTH_SHORT).show();
                setTitle("確認　クリック");
                break;
            case R.id.SendButton:
                Toast.makeText(this,"送信ボタン　押した",Toast.LENGTH_SHORT).show();
                setTitle("送信クリック");
                intent.putExtra("age",19);
                startActivity(intent);
                break;
        }
    }



}