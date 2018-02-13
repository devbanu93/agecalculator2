package com.example.sarthaj.agecalculator;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sarthaj.agecalculator.R;

import java.util.Calendar;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    EditText et_year;
    TextView tv_answer;
    Button bt_clear;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_year = (EditText) findViewById(R.id.et_year);
        tv_answer = (TextView) findViewById(R.id.tv_answer);
        bt_clear = (Button) findViewById(R.id.bt_clear);
        et_year.setOnClickListener(new View.OnClickListener() {
            final Calendar cal = Calendar.getInstance();
            int mYear = cal.get(Calendar.YEAR);
            int mMonth = cal.get(Calendar.MONTH);
            int mDay = cal.get(Calendar.DAY_OF_MONTH);
            int last = cal.getActualMaximum(cal.DATE);
            public void onClick(View v) {
                DatePickerDialog mDatePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                    /*      Your code   to get date and time    */
                        int s = selectedyear;
                        int t = selectedmonth;
                        int u = selectedday;
                        int c=0;
                        et_year.setText(u + "/" + (t + 1) + "/" + s);
                        int cage = mYear - s;
                        int month = mMonth - t;
                        int days = mDay - u;
                        int n = month - 1;
                        int p = last-u;
                        int q = mDay + p;
                            if (cage >= 0 && month >= 0 && days >= 0)
                        {
                            tv_answer.setText("You are " + cage + " years " + month + " months " + days + " days " + " old");
                        }
                        else if (month<0 && days>=0 && cage>=0){
                            for(int i=mMonth;i>=1;i--)
                            {
                                c++;
                            }
                            for(int j=12;j>t;j--)
                            {
                                c++;
                            }
                            int y=cage-1;
                            tv_answer.setText("You are " + y + " years " + c + " months " + days + " days " + " old");
                        }else if(month<0 && days<0 && cage>=0) {

                                for(int i=mMonth;i>=1;i--)
                                {
                                    c++;
                                }
                                for(int j=12;j>t;j--)
                                {
                                    c++;
                                }
                                int y=cage-1;
                                tv_answer.setText("You are " + y + " years " + c + " months " + q + " days " + " old");
                            }
                            else if(month>=0 && days<0 && cage>=0) {
                                if(month==0)
                                    tv_answer.setText("You are " + cage + " years " + month + " months " + q + " days " + " old");
                                else
                                tv_answer.setText("You are " + cage + " years " + n + " months " + q + " days " + " old");
                            }
                            else
                        {
                            tv_answer.setText("Select correct date");
                        }
                    }
                }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select Date");
                mDatePicker.show();


                bt_clear.setOnClickListener(new View.OnClickListener()

                {
                    public void onClick(View v) {
                        et_year.setText("");
                        tv_answer.setText("");

                    }
                });
            }
        });
    }

}




