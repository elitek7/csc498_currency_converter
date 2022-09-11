package com.edevs.currencyconverter;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Converter extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Spinner spinner;
    TextView amount, result;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        Intent i = getIntent();
        String username = i.getStringExtra("username");
        Toast.makeText(this, username, Toast.LENGTH_LONG).show();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        amount = findViewById(R.id.amount);
        result = findViewById(R.id.result);


    }

    public void convert(View view)
    {
        //local variables:
        double value; //final result
        final int rate= 40000; //exchange rate
        //Retrieving the selected option
        String option = spinner.getSelectedItem().toString();
        //Applying a conversion protocol in respect to every option
        if(option.equals("USD to LBP"))
        {
            value = Double.parseDouble(amount.getText().toString())*rate;
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(2);
            result.setText(df.format(value) + " LBP");
        } else if(option.equals("LBP to USD"))
        {
            value = Double.parseDouble(amount.getText().toString())/rate;
            DecimalFormat df = new DecimalFormat("#");
            df.setMaximumFractionDigits(2);
            result.setText(df.format(value) + " LBP");
        }


        Toast.makeText(this, "converting", Toast.LENGTH_LONG).show();

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}
