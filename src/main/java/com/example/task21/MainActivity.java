package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton metreButton, celsiusButton, kilogramsButton;
    private TextView results;
    private TextView resultsType;
    private EditText inputText;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.options));
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        inputText = (EditText) findViewById(R.id.inputText);

        results = (TextView) findViewById(R.id.results);
        resultsType = (TextView) findViewById(R.id.resultsType);

        metreButton = (ImageButton) findViewById(R.id.metreButton);
        celsiusButton = (ImageButton) findViewById(R.id.celsiusButton);
        kilogramsButton = (ImageButton) findViewById(R.id.kilogramsButton);

        //Meter
        metreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (spinner.getSelectedItem().toString().equals("Metre"))
                {
                    String userInput = inputText.getText().toString();
                    Double toConvert = Double.parseDouble(userInput);
                    Float Centimetre = (float)(toConvert * 100);
                    Float Foot = (float)(toConvert * 3.2808398950131);
                    Float Inch = (float)(toConvert * 39.3700787402);

                    results.setText(String.format("%.2f",Centimetre) + "\r\n\r\n" + String.format("%.2f",Foot) + "\r\n\r\n" + String.format("%.2f",Inch));
                    resultsType.setText("Centimetre" + "\r\n\r\nFoot" + "\r\n\r\nInch");
                }
                else
                {
                    //toast error message
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion icon.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Celsius
        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (spinner.getSelectedItem().toString().equals("Celsius"))
                {
                    String userInput = inputText.getText().toString();
                    Double toConvert = Double.parseDouble(userInput);
                    Float Fahrenheit = (float)((toConvert * 1.8) + 32);
                    Float Kelvin = (float)(toConvert + 273.15);

                    results.setText(String.format("%.2f",Fahrenheit) + "\r\n\r\n" + String.format("%.2f",Kelvin));
                    resultsType.setText("Fahrenheit" + "\r\n\r\nKelvin");
                }
                else
                {
                    //toast error message
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion icon.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Kilograms
        kilogramsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (spinner.getSelectedItem().toString().equals("Kilograms"))
                {
                    String userInput = inputText.getText().toString();
                    Double toConvert = Double.parseDouble(userInput);
                    Float Gram = (float)(toConvert * 1000);
                    Float Ounce = (float)(toConvert * 35.27396194958);
                    Float Pound = (float)(toConvert * 2.2046226218488);

                    results.setText(String.format("%.2f",Gram) + "\r\n\r\n" + String.format("%.2f",Ounce) + "\r\n\r\n" + String.format("%.2f",Pound));
                    resultsType.setText("Gram" + "\r\n\r\nOunce(Oz)" + "\r\n\r\nPound(lb)");
                }
                else
                {
                    //toast error message
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion icon.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}