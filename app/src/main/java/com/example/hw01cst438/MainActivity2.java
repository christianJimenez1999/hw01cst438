package com.example.hw01cst438;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public static Intent getIntent(Context context, int value){
        Intent intent = new Intent(context, MainActivity2.class);
        intent.putExtra("INTENT_EXTRA_VALUE", value);

        return intent;
    }

}