package com.edevs.currencyconverter;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class Converter extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Spinner spinner;
    TextView amount, result;
    String option;
    Button convert_btn;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        Intent i = getIntent();
        String username = i.getStringExtra("username");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_200)));
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //Initializing the variables by assigning them to UI components
        convert_btn = findViewById(R.id.convert_btn);
        amount = findViewById(R.id.amount);
        result = findViewById(R.id.result);
    }

    public void convert(View view)
    {
        //local variables:
        double value; //final result
        final int rate = 40000; //exchange rate
        //Retrieving the selected option
        String option = spinner.getSelectedItem().toString();

        if(amount.getText().toString().isEmpty())
        {   //Empty field alert
            Toast.makeText(getApplicationContext(), "Empty field", Toast.LENGTH_LONG).show();
        }
        else if(Double.parseDouble(amount.getText().toString())>=0) //Amount has to be greater than or equal to 0
        {   //Applying a conversion protocol in respect to every option
            if(option.equals("USD to LBP"))
            {
                value = Double.parseDouble(amount.getText().toString())*rate;
                DecimalFormat df = new DecimalFormat("###,###,###");
                df.setMaximumFractionDigits(3);
                result.setText(df.format(value) + " LBP");
                Toast.makeText(this, "Converted", Toast.LENGTH_SHORT).show();
            } else if(option.equals("LBP to USD"))
            {
                value = Double.parseDouble(amount.getText().toString())/rate;
                DecimalFormat df = new DecimalFormat("#");
                df.setMaximumFractionDigits(3);
                result.setText(df.format(value) + " USD");
                Toast.makeText(this, "Converted", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(this, "Please enter a value greater than 0", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        option = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}
