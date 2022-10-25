package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class List2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        Intent intentSub = new Intent(this,SubActivity.class);
        Intent intentEvent = new Intent(this,EventActivity.class);

        ListView listView  =  findViewById(R.id.showdata);
        EditText inputData = findViewById(R.id.inputData);
        Button addButton   =  findViewById(R.id.addButton);

        ArrayList<String> datalist = new ArrayList< >();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datalist);
        listView.setAdapter(adapter);
        //データ追加ボタン
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aT = inputData.getText().toString();
                //追加する文字列を可変長配列に追加
                if(!aT.equals("")) {

                    datalist.add(aT);
                    //リスト再表示
                    listView.setAdapter(adapter);
                    //3テキストをクリア
                    inputData.setText("");
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i%2){
                    case 0:
                        startActivity(intentEvent);
                        break;
                    case 1:
                        startActivity(intentSub);
                        break;
                }
            }
        });
    }
}