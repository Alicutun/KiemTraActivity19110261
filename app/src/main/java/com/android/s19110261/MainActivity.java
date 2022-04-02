package com.android.s19110261;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CalculatorActivity";

    private Cal mCalculateInterest;

    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;
    private EditText mOperandThreeEditText;

    private List<String> EXTRA_RESULT1 = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalculateInterest = new Cal();

        mOperandOneEditText = findViewById(R.id.soTienGui);
        mOperandTwoEditText = findViewById(R.id.laiSuatGui);
        mOperandThreeEditText = findViewById(R.id.kyHanGui);

    }

    public void launchResultActivity(View view){
        compute();

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putStringArrayListExtra("EXTRA_RESULT1", (ArrayList<String>) EXTRA_RESULT1);
        startActivity(intent);
    }

    private void compute(){
        double operandOne;
        double operandTwo;
        double operandThree;

        try {
            operandOne = getOperand(mOperandOneEditText);
            operandTwo = getOperand(mOperandTwoEditText);
            operandThree = getOperand(mOperandThreeEditText);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            return;
        }
        EXTRA_RESULT1.add(String.valueOf(
                mCalculateInterest.calc(operandOne, operandTwo, operandThree)));
        EXTRA_RESULT1.add(String.valueOf(
                mCalculateInterest.sum(operandOne, operandTwo, operandThree)));

    }

    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }

    /**
     * @return the operand text which was entered in an EditText.
     */
    private static String getOperandText(EditText operandEditText) {
        String operandText = operandEditText.getText().toString();
        if (TextUtils.isEmpty(operandText)) {
            throw new NumberFormatException("Operand cannot be empty!");
        }
        return operandText;
    }

}