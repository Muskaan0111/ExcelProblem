package com.example.excelprob;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.NumberPicker;

import com.example.excelprob.databinding.ActivityByRangeBinding;

public class ByRange extends AppCompatActivity {
    ActivityByRangeBinding arb;
    boolean isChecked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_range);


        arb = ActivityByRangeBinding.inflate(getLayoutInflater());
        setContentView(arb.getRoot());

        onButtonClick();

    }

    private void onButtonClick() {

        arb.button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                arb.numberPicker.setVisibility(View.VISIBLE);
                setUpNumberPicker();
            }
        });


    }



    private void setUpNumberPicker(){



           Integer min = Integer.parseInt(arb.minValue.getText().toString().trim());
        arb.numberPicker.setMinValue(min);

        Integer max = Integer.parseInt(arb.maxValue.getText().toString().trim());

        arb.numberPicker.setMaxValue(max);






        arb.numberPicker.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {

                return  getColName(value) ;
            }
        });

          if(arb.displayColumn.isChecked()){
              arb.numberPicker.setFormatter(new NumberPicker.Formatter() {
                  @Override
                  public String format(int value) {

                      return value +" " + getColName(value) ;
                  }
              });


          }

        View firstvalue = arb.numberPicker.getChildAt(0);
        if (firstvalue != null) {
            firstvalue.setVisibility(View.INVISIBLE);
        }


    }

    private String getColName(int column) {
        StringBuilder stringBuilder = new StringBuilder();
        while (column > 0) {
            int rem = column % 26;
            if (rem == 0) {
                stringBuilder.append('Z');
                column = (column / 26) - 1;
            } else {
                stringBuilder.append((char)('A'+rem-1));
                column = column / 26;
            }
        }

        return stringBuilder.reverse().toString();

    }





}