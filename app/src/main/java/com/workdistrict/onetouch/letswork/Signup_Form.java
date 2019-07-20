package com.workdistrict.onetouch.letswork;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Signup_Form extends AppCompatActivity {


    private EditText editTextEmail, EditTextNumber, editTextName, editTextPassword, EditTextCnic;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);

        editTextEmail = findViewById(R.id.id_email_up);
        editTextPassword = findViewById(R.id.id_password_up);
        editTextName = findViewById(R.id.id_name_up);
        EditTextCnic = findViewById(R.id.id_cnic);
        EditTextNumber = findViewById(R.id.id_number);
        button = findViewById(R.id.id_sign_up);
        button = findViewById(R.id.id_sign_up);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });


    }

    public void signUp() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String name = editTextName.getText().toString().trim();
        String Cnic = EditTextCnic.getText().toString().trim();
        String Number = EditTextNumber.getText().toString().trim();


        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Password should be at least 6 character long");
            editTextPassword.requestFocus();
            return;
        }

        if (name.isEmpty()) {
            editTextName.setError("Name required");
            editTextName.requestFocus();
            return;
        }

        if (Cnic.isEmpty()) {
            EditTextCnic.setError("Cnic required");
            EditTextCnic.requestFocus();
            return;
        }

        if (Number.isEmpty()) {
            EditTextNumber.setError("NUmber required");
            EditTextNumber.requestFocus();
            return;
        }

        Call<Pojo_SignUp> call = RetrofitClient.getInstance().getApi().signUp(new Pojo_SignUp(email, Number, name, password, Cnic));

        call.enqueue(new Callback<Pojo_SignUp>() {
            @Override
            public void onResponse(Call<Pojo_SignUp> call, Response<Pojo_SignUp> response) {
                try {
                    String s = response.body().toString();
                    Toast.makeText(Signup_Form.this, s, Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Pojo_SignUp> call, Throwable t) {

                Toast.makeText(Signup_Form.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });




    }

}

