package com.example.form_exercise;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etEmail;
    EditText etTel;
    EditText etPass;
    EditText etDate;

    int pDay, pMonth, pYear=0;
    Activity activity=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.name);
        etEmail = findViewById(R.id.email);
        etTel = findViewById(R.id.tel);
        etPass = findViewById(R.id.pass);
        etDate = findViewById(R.id.birthdate);
    }


    public void checkForm(View view) {
        String n = etName.getText().toString();
       /* if ((etName.getText().toString().trim().equalsIgnoreCase("")) || (etEmail.getText().toString().trim().equalsIgnoreCase("")) || (etPass.getText().toString().trim().equalsIgnoreCase("")) || (etTel.getText().toString().trim().equalsIgnoreCase(""))){
            Toast.makeText(this, R.string.error, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,n + " " + getString(R.string.ok), Toast.LENGTH_LONG).show();
        }
*/

        if (etName.getText().toString().trim().equalsIgnoreCase("")) {
            etName.setError(getString(R.string.empty));
        } else if (etEmail.getText().toString().trim().equalsIgnoreCase("")) {
            etEmail.setError(getString(R.string.empty));
        } else if (etPass.getText().toString().trim().equalsIgnoreCase("")) {
            etPass.setError(getString(R.string.empty));
        } else if (etTel.getText().toString().trim().equalsIgnoreCase("")) {
            etPass.setError(getString(R.string.empty));
        } else {
            Toast.makeText(this, getString(R.string.ok), Toast.LENGTH_LONG).show();
        }
    }

    public void openDialog(View view) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(

                this);

        alertDialogBuilder.setTitle(getString(R.string.app_name));

        alertDialogBuilder.setMessage(getString(R.string.deleteAll))

                .setCancelable(false)

                .setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                        etName.setText("");
                        etEmail.setText("");
                        etTel.setText("");
                        etPass.setText("");
                    }
                })

                .setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }


    public void chooseDate(View view) {
        DatePickerDialog dateDialog = new DatePickerDialog(activity, pDateSetListener, pYear, pMonth, pDay);

        dateDialog.getDatePicker().setMinDate(System.currentTimeMillis());
           Calendar calendar = Calendar.getInstance();
           calendar.set(2019,5,22);
        dateDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        dateDialog.show();
    }

    private DatePickerDialog.OnDateSetListener pDateSetListener =

            new DatePickerDialog.OnDateSetListener() {

        @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    pYear = year;

                    pMonth = monthOfYear;

                    pDay = dayOfMonth;

                    String fromDay = Integer.toString(pDay);

                    String fromMonth = Integer.toString(pMonth + 1);

                    if (fromDay.length() == 1) fromDay = "0" + fromDay;

                    if (fromMonth.length() == 1) fromMonth = "0" + fromMonth;

                    etDate.setText(fromDay + "/" + fromMonth + "/" + pYear);
                }
            };
}