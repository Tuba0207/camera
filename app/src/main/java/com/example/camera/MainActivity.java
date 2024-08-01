package com.example.camera;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public static final int SECOND_ACTIVITY_RESULT_CODE = -1;
    Button btnCamera;
    ImageView iV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//added by alishba"
        setContentView(R.layout.activity_main);

        btnCamera = findViewById(R.id.btnCamera);
        iV = findViewById(R.id.iV);

        ActivityResultLauncher<Void> launcher = registerForActivityResult(new
                        ActivityResultContracts.TakePicturePreview(),
                new ActivityResultCallback<Bitmap>() {
                    @Override
                    public void onActivityResult(Bitmap o) {
                        iV.setImageBitmap(o);

                    }
                });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher.launch(null);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_RESULT_CODE) {
            if (requestCode == RESULT_OK) ;
        }
    }
}