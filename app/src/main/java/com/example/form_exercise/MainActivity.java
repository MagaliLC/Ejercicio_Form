package com.example.form_exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etEmail;
    EditText etTel;
    EditText etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.name);
        etEmail = findViewById(R.id.email);
        etTel = findViewById(R.id.tel);
        etPass = findViewById(R.id.pass);
    }


    public void deleteForm(View view) {
        etName.setText("");
        etEmail.setText("");
        etTel.setText("");
        etPass.setText("");
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
}