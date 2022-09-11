package com.edevs.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void login(View v)
    {
        EditText username;
        EditText password;
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_LONG).show();
    }
}