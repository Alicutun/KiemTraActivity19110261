package com.android.s19110261;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private static final int request_pic = 1;

    Button open_cam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent intent = getIntent();

        ArrayList<String> listResult = intent.getStringArrayListExtra("EXTRA_RESULT1");
        String result1Number = listResult.get(0) ;
        String result2Number = listResult.get(1) ;

        TextView result1 = findViewById(R.id.soTienLaiNhanDuoc);
        TextView result2 = findViewById(R.id.tongSoTienNhan);

        result1.setText(result1Number);
        result2.setText(result2Number);

    }
    public void openCamera(View view){
        open_cam = (Button)findViewById(R.id.bt_xemPicuture);

        open_cam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, request_pic);
                finish();
            }
        });
    }
}