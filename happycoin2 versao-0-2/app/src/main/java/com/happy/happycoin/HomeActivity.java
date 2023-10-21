package com.happy.happycoin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
    private ImageView botaoUser;

    private void initializeComponents() {
        botaoUser = findViewById(R.id.Image_perfil);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initializeComponents();

        botaoUser.setOnClickListener(v ->{
            Intent intent2 = new Intent(getApplicationContext(), TelaUserActivity.class);
            startActivity(intent2);

        });



    }


}