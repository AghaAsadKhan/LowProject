package com.workdistrict.onetouch.letswork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login_Form extends AppCompatActivity {


    Button button;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);

        button = findViewById(R.id.bt_login);
        editTextPassword = findViewById(R.id.id_login_pass);
        editTextEmail = findViewById(R.id.id_login_pass);
        editTextPhone = findViewById(R.id.id_login_device);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

    }


    public void login() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String device = editTextPhone.getText().toString().trim();



        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            editTextEmail.setError("Enter a valid email");
//            editTextEmail.requestFocus();
//            return;
//        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 3) {
            editTextPassword.setError("Password should be at least 6 character long");
            editTextPassword.requestFocus();
            return;
        }


        Call<Pojo_Login> call = RetrofitClient.getInstance().getApi().logIn(new Pojo_Login(email, password, device));

        call.enqueue(new Callback<Pojo_Login>() {
            @Override
            public void onResponse(Call<Pojo_Login> call, Response<Pojo_Login> response) {
                try {
                    String s = response.body().toString();
                    Toast.makeText(Login_Form.this, s, Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Pojo_Login> call, Throwable t) {

                Toast.makeText(Login_Form.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });




    }

}
