package com.aula.lanfranchi.calcularbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraBasico extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_basico);

        /* Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.operations, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter); */

    }
    public void cliqueBotaoCalcular(View view){
        TextView fieldResult = (TextView) findViewById(R.id.result);
        double res = 0.0;
        EditText field1 = (EditText) findViewById(R.id.operand1);
        EditText field2 = (EditText) findViewById(R.id.operand2);
        String stringOp1 = field1.getText().toString();
        String stringOp2 = field2.getText().toString();
        if(TextUtils.isEmpty(stringOp1)){
            field1.setError(getString(R.string.error_op));
            return;
        }
        if(TextUtils.isEmpty(stringOp2)){
            field2.setError(getString(R.string.error_op));
            return;
        }
        double op1 = Double.parseDouble(stringOp1);
        double op2 = Double.parseDouble(stringOp2);
        RadioGroup rd = (RadioGroup) findViewById(R.id.buttons);
        int checked = rd.getCheckedRadioButtonId();
        if (checked!=-1){
            // Check which radio button was clicked
            switch(checked) {
                case R.id.buttonSum:
                    res = op1 + op2;
                    fieldResult.setText(String.valueOf(res));
                    break;
                case R.id.buttonSub:
                    res = op1 - op2;
                    fieldResult.setText(String.valueOf(res));
                    break;
                case R.id.buttonMult:
                    res = op1 * op2;
                    fieldResult.setText(String.valueOf(res));
                    break;
                case R.id.buttonDiv:
                    if(op2!=0.0) {
                        res = op1 / op2;
                        fieldResult.setText(String.valueOf(res));
                    }else{
                        fieldResult.setText("");
                        Toast.makeText(this.getApplicationContext(),getString(R.string.error_div), Toast.LENGTH_LONG).show();
                    }
                    break;
            }
        }else {
            Toast.makeText(this.getApplicationContext(),getString(R.string.error_radiobtn), Toast.LENGTH_LONG).show();
        }
    }
}
