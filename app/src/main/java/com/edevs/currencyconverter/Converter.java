package com.edevs.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Converter extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        Intent i = getIntent();
        String username = i.getStringExtra("username");
        Toast.makeText(this, username, Toast.LENGTH_LONG).show();
    }

    public void convert(View view)
    {
        Toast.makeText(this, "converting", Toast.LENGTH_LONG).show();
    }
}
