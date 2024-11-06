package com.example.binary;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView txtNum1, txtOperation, txtNum2, txtResult, txtDecimal;
    MaterialButton btnErase, btnClear, btnMultiplication, btnDivision, btn1, btn0, btnAddition, btnSubtraction;

    boolean button = true;
    BinaryCalculator binaryCalculator = new BinaryCalculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNum1 = findViewById(R.id.txtNum1);
        txtOperation = findViewById(R.id.txtOperation);
        txtNum2 = findViewById(R.id.txtNum2);
        txtResult = findViewById(R.id.txtResult);
        txtDecimal = findViewById(R.id.txtDecimal);

//        assignId(btnErase, R.id.btnErase);
//        assignId(btnClear, R.id.btnClear);
//        assignId(btnMultiplication, R.id.btnMultiplication);
//        assignId(btnDivision, R.id.btnDivision);
//        assignId(btn1, R.id.btn1);
//        assignId(btn0, R.id.btn0);
//        assignId(btnAddition, R.id.btnAddition);

    }


    public void btnEquals_onClick(View view) {
        String n1, n2, n3, operation;

        n1 = getTextNum1();
        n2 = getTextNum2();
        operation = txtOperation.getText().toString();

        switch (operation){
            case "+":
                txtResult.setText(binaryCalculator.add(n1, n2));
                break;
            case "-":
                txtResult.setText(binaryCalculator.subtract(n1, n2));
                break;
            case "x":
                txtResult.setText(binaryCalculator.multiply(n1, n2));
                break;
            case "/":
                txtResult.setText(binaryCalculator.divide(n1, n2));
                break;
        }
        n3 = txtResult.getText().toString();
        txtDecimal.setText(binaryCalculator.binaryToDecimal(n3)+"");

    }

    public void btnClear_onClick(View view) {
        txtNum1.setText("0");
        txtNum2.setText("0");
        txtOperation.setText("+");
        txtResult.setText("0");
        txtDecimal.setText("0");
    }

    public void btnAddition_onClick(View view) {
        txtOperation.setText("+");
    }

    public void btnSubtraction_onClick(View view) {
        txtOperation.setText("-");
    }

    public void btnMultiplication_onClick(View view) {
        txtOperation.setText("x");
    }

    public void btnDivision_onClick(View view) {
        txtOperation.setText("/");
    }

    public void txtNum1_onClick(View view) {
        button = true;
    }

    public void txtNum2_onClick(View view) {
        button = false;
    }

    public void btn1_onClick(View view) {
        if (button) {
            if (getTextNum1().equals("0")) {
                txtNum1.setText("");
            }
            txtNum1.setText(getTextNum1() + "1");
        } else {
            if (getTextNum2().equals("0")) {
                txtNum2.setText("");
            }
            txtNum2.setText(getTextNum2() + "1");
        }
    }

    public void btn0_onClick(View view) {
        if (button) {
            if (!getTextNum1().equals("0")) {
                txtNum1.setText(getTextNum1() + "0");
            }
        } else {
            if (!getTextNum2().equals("0")) {
                txtNum2.setText(getTextNum2() + "0");
            }

        }
    }

    public void btnErase_onClick(View view) {
        String s;
        if (button && !getTextNum1().isEmpty()) {
            if (!getTextNum1().equals("0")) {
                s = getTextNum1().substring(0, getTextNum1().length() - 1);
                txtNum1.setText(s);
            }
            if(getTextNum1().equals("")){
                txtNum1.setText("0");
            }
        } else {
            if (!getTextNum2().equals("0")) {

                if (!getTextNum2().isEmpty()) {
                    s = getTextNum2().substring(0, getTextNum2().length() - 1);
                    txtNum2.setText(s);
                }
                if(getTextNum2().equals("")){
                    txtNum2.setText("0");
                }
            }
        }
    }

    private String getTextNum1() {
        return txtNum1.getText().toString();
    }

    private String getTextNum2() {
        return txtNum2.getText().toString();
    }
}