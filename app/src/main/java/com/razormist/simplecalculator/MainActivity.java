package com.razormist.simplecalculator;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.renderscript.ScriptGroup;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.text.DecimalFormat;
import com.razormist.simplecalculator.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    private Double val1 = Double.NaN;
    private Double val2;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;



    private DecimalFormat decimalFormat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "7");
            }
        });

        binding.btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "8");
            }
        });

        binding.btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "9");
            }
        });

        binding.btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "4");
            }
        });

        binding.btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "5");
            }
        });

        binding.btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "6");
            }
        });

        binding.btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "1");
            }
        });

        binding.btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "2");
            }
        });

        binding.btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "3");
            }
        });


        binding.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + ".");
            }
        });

        binding.btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etEdit.setText(binding.etEdit.getText() + "0");
            }
        });

        binding.btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                binding.tvInfo.setText(binding.tvInfo.getText().toString() + decimalFormat.format(val2) + " = " + decimalFormat.format(val1));
                val1 = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        binding.btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                CURRENT_ACTION = DIVISION;
                binding.tvInfo.setText(decimalFormat.format(val1) + " / ");
                binding.etEdit.setText(null);
            }
        });

        binding.btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                CURRENT_ACTION = MULTIPLICATION;
                binding.tvInfo.setText(decimalFormat.format(val1) + " * ");
                binding.etEdit.setText(null);
            }
        });


        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                CURRENT_ACTION = ADDITION;
                binding.tvInfo.setText(decimalFormat.format(val1) + " + ");
                binding.etEdit.setText(null);
            }
        });

        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
                CURRENT_ACTION = SUBTRACTION;
                binding.tvInfo.setText(decimalFormat.format(val1) + " - ");
                binding.etEdit.setText(null);
            }
        });

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.etEdit.getText().length() > 0){
                    CharSequence currentText = binding.etEdit.getText();
                    binding.etEdit.setText(currentText.subSequence(0, currentText.length() - 1));
                }else{
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    binding.etEdit.setText("");
                    binding.tvInfo.setText("");
                }
            }
        });
    }

    private void Calculate(){
        if (!Double.isNaN(val1)){
            val2 = Double.parseDouble(binding.etEdit.getText().toString());
            binding.etEdit.setText(null);

            switch (CURRENT_ACTION){
                case ADDITION:
                    val1 = this.val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = this.val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = this.val1 * val2;
                    break;
                case DIVISION:
                    val1 = this.val1 / val2;
                    break;
            }
        }else{
            try{
                val1 = Double.parseDouble(binding.etEdit.getText().toString());
            }catch (Exception e){}
        }
    }
}
