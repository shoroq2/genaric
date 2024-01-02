package com.example.travelplanning;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {
    private EditText emailAddressEditText, passwordEditText;
    private Button loginButton;
    private CheckBox rememberMeCheckBox;
    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "login_pref";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_REMEMBER_ME = "remember_me";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        emailAddressEditText = findViewById(R.id.EmailAddress);
        passwordEditText = findViewById(R.id.Password);
        loginButton = findViewById(R.id.button);
        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        // Check if remember me is enabled
        boolean rememberMe = sharedPreferences.getBoolean(KEY_REMEMBER_ME, false);
        rememberMeCheckBox.setChecked(rememberMe);

        if (rememberMe) {
            // If remember me is enabled, populate email and password fields
            emailAddressEditText.setText(sharedPreferences.getString(KEY_EMAIL, ""));
            passwordEditText.setText(sharedPreferences.getString(KEY_PASSWORD, ""));
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get email and password from EditText
                String email = emailAddressEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate email and password
                if (isValidEmail(email) && isValidPassword(password)) {
                    // Successful login, proceed to the next screen
                    Intent intent = new Intent(login.this, Travel.class);
                    startActivity(intent);

                    // Save email and password if Remember Me is checked
                    if (rememberMeCheckBox.isChecked()) {
                        saveCredentials(email, password);
                    } else {
                        // Clear saved credentials if Remember Me is unchecked
                        clearCredentials();
                    }

                    finish();
                } else {
                    // Show an error message for unsuccessful login
                    Toast.makeText(login.this, "Invalid credentials. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to check if the entered email is valid
    private boolean isValidEmail(String email) {
        // Basic email validation
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Method to check if the entered password is valid
    private boolean isValidPassword(String password) {
        // Basic password validation: at least one digit and one character
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z]).{6,}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    // Method to save email and password in SharedPreferences
    private void saveCredentials(String email, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.putBoolean(KEY_REMEMBER_ME, true);
        editor.apply();
    }

    // Method to clear saved credentials in SharedPreferences
    private void clearCredentials() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY_EMAIL);
        editor.remove(KEY_PASSWORD);
        editor.putBoolean(KEY_REMEMBER_ME, false);
        editor.apply();
    }
}
