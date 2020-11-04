package com.example.excelprob;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.excelprob.databinding.WeightPickerColumnBinding;
import com.google.android.material.snackbar.Snackbar;

public class ByColumn extends AppCompatActivity {
  WeightPickerColumnBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_picker_column);

        b = WeightPickerColumnBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());



    }



    public void getValue(View view) {
        Integer num =Integer.parseInt( b.getNumber.getText().toString().trim());


        StringBuilder str = new StringBuilder();;

        while(num>0) {
            int rem=num%26;

            if (rem == 0) {

                str.append('Z');
                num=(num/26)-1;

            } else {
                char c=(char)('A'+rem-1);
                System.out.println(c);
                str.append(c);
                num/=26;
            }
        }

        b.resultDisplay.setVisibility(View.VISIBLE);
        b.resultDisplay.setText(str.reverse().toString());

        Snackbar.make(b.Get, "Your result = "+str.reverse().toString(), Snackbar.LENGTH_SHORT)
                .show();



    }
}
