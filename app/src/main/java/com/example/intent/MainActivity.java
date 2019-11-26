package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_url,btn_camera,btn_album,btn_call,btn_map;
    EditText edt_phone;
    Uri uri;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_url = findViewById(R.id.btnURL);
        btn_camera = findViewById(R.id.btnCamera);
        btn_album = findViewById(R.id.btnImg);
        btn_call = findViewById(R.id.btnCall);
        btn_map = findViewById(R.id.btnMap);
        edt_phone = findViewById(R.id.edtPhone);

        btn_url.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_camera.setOnClickListener(this);
        btn_album.setOnClickListener(this);
        btn_map.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btnURL: //按下開啟網頁
                uri = Uri.parse("https://youtube.com");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                break;

            case R.id.btnCamera: //按下開啟相機
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                break;

            case R.id.btnMap: //按下開啟地圖
                uri = Uri.parse("geo:24.948436, 121.229220");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.btnCall: //按下撥打電話
                uri = Uri.parse("tel:"+edt_phone.getText());
                intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                break;

            case R.id.btnImg: //按下開啟相簿
                intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                startActivityForResult(intent,0);
                break;
        }
    }
}
