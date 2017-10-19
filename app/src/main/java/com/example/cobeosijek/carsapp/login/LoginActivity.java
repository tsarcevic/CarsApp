package com.example.cobeosijek.carsapp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cobeosijek.carsapp.R;
import com.example.cobeosijek.carsapp.car_list.CarsActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginFormButton;
    TextView loginToolbarText;
    TextView loginFormWelcomeText;
    EditText emailEditText;
    EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setUI();
    }

    private void setUI() {
        loginFormButton = findViewById(R.id.login_button);
        loginToolbarText = findViewById(R.id.login_form);
        loginFormWelcomeText = findViewById(R.id.welcome_screen);
        emailEditText = findViewById(R.id.email_text);
        passwordEditText = findViewById(R.id.password_text);

        loginFormButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_button) {
// TODO: 19/10/2017 checkstring into stringutils
            if (checkText(emailEditText.getText().toString()) && checkPassword(passwordEditText.getText().toString())) {
                startActivity(CarsActivity.getLaunchIntent(this, emailEditText.getText().toString().trim()));

                emailEditText.setText("");
                passwordEditText.setText("");
                emailEditText.setError(null);
                passwordEditText.setError(null);
            }
        }
    }

    private boolean checkPassword(String password) {
        if (password.length() < 6) {
            passwordEditText.setError(getString(R.string.password_error));
            passwordEditText.setText("");

            return false;
        }
        return true;
    }

    private boolean checkText(String text) {
        if (!TextUtils.isEmpty(text) && Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
            return true;
        }
        emailEditText.setError(getString(R.string.invalid_mail));
        emailEditText.setText("");

        return false;
    }
}
