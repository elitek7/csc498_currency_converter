package com.edevs.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Changing the action bar color to theme color
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));

    }

    public void login(View v)
    {
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);

        String username_input = username.getText().toString();
        String password_input = password.getText().toString();

        if(username_input.equals("user.leb") && password_input.equals("123456"))
        {
            Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show();
            //Initializing an intent to access the converter page
            Intent i = new Intent(getApplicationContext(), Converter.class);
            i.putExtra("username", username_input);
            startActivity(i);
        }
        else if (!username_input.equals("user.leb") && password_input.equals("123456"))
        {
            Toast.makeText(this, "Wrong username", Toast.LENGTH_LONG).show();
        }
        else if (username_input.equals("user.leb") && !password_input.equals("123456"))
        {
            Toast.makeText(this, "Wrong password", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Wrong credentials", Toast.LENGTH_LONG).show();
        }
    }
}