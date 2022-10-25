package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ImageView ImageView2 = findViewById(R.id.imageView2);
        Intent intent = getIntent();
        Uri imageUri2= intent.getParcelableExtra("uri");
        ImageView2.setImageURI(imageUri2);
    }
}