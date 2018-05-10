package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * This is my quiz app
 */
public class MainActivity extends AppCompatActivity {

    String name;
    RadioGroup question1;
    RadioGroup question2;
    RadioGroup question3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question1 = (RadioGroup) findViewById(R.id.question1);
        question2 = (RadioGroup) findViewById(R.id.question2);
        question3 = (RadioGroup) findViewById(R.id.question3);


    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitQuiz(View view) {

        int result = 0;

        int answer1Id = question1.getCheckedRadioButtonId();
        RadioButton radio1 = findViewById(answer1Id);
        checkNull(radio1);
        String answer1 = radio1.getText().toString();
        if(validateAnswer(getString(R.string.james_dean), answer1)){
            result = result + 1;
        }

        int answer2Id = question2.getCheckedRadioButtonId();
        RadioButton radio2 = findViewById(answer2Id);
        checkNull(radio2);
        String answer2 = radio2.getText().toString();
        if(validateAnswer(getString(R.string.andy_rourke), answer2)) {
            result = result + 1;
        }

        int answer3Id = question3.getCheckedRadioButtonId();
        RadioButton radio3 = findViewById(answer3Id);
        checkNull(radio3);
        String answer3 = radio3.getText().toString();
        if(validateAnswer(getString(R.string._1987), answer3)) {
            result = result + 1;
        }


        if (question4IsValid()) {
            result = result + 1;
        }

        displayScore(result);

    }



    private boolean question4IsValid (){

        boolean isValid = true;

        CheckBox cbJohnny = (CheckBox) findViewById(R.id.johnny_checkbox);
        if (!cbJohnny.isChecked()){
            isValid = false;
        }

        CheckBox cbAndy = (CheckBox) findViewById(R.id.andy_checkbox);
        if (cbAndy.isChecked()){
            isValid = false;
        }

        CheckBox cbMorrissey = (CheckBox) findViewById(R.id.morrissey_checkbox);
        if (!cbMorrissey.isChecked()) {
            isValid = false;
        }


        return isValid;
    }


    /**
     * reset quiz
     */


    public void resetQuiz(View view){
        question1.clearCheck();
        question2.clearCheck();
        question3.clearCheck();

    }


    // public class MyActivity extends Activity {
    //     protected void onCreate(Bundle icicle) {
    //         super.onCreate(icicle);
    //
    //         setContentView(R.layout.content_layout_id);
    //
    //         final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_id);
    //         if (checkBox.isChecked()) {
    //             checkBox.setChecked(false);
    //         }
    //     }
    // }



    private boolean validateAnswer(String expected, String selected){
        if(expected.equals(selected)){
            return true;
        }
        return false;
    }



    /**
     * This method displays the result.
     */
    private void displayScore(int score) {
        EditText text = (EditText) findViewById(R.id.et_name);
        name = text.getText().toString();
        Toast.makeText(this, name + ", your score is: " + score + " out of 4", Toast.LENGTH_LONG).show();
    }

    private void displayError() {
        Toast.makeText(this, "Oops, you must complete all fields!", Toast.LENGTH_LONG).show();
    }

    private void checkNull(View view){
        if( view == null){
            displayError();
            return;
        }
    }

}

