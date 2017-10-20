package com.example.cobeosijek.carsapp.utils;

import android.content.res.Resources;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import com.example.cobeosijek.carsapp.R;

/**
 * Created by cobeosijek on 20/10/2017.
 */

public class StringUtils {

    public static boolean checkPassword(String password, EditText editText) {
        if (password.length() < 6) {
            editText.setError(Resources.getSystem().getString(R.string.password_error));
            editText.setText("");

            return false;
        }
        return true;
    }

    public static boolean checkText(String text, EditText editText) {
        if (!TextUtils.isEmpty(text) && Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
            return true;
        }
        editText.setError(Resources.getSystem().getString(R.string.invalid_mail));
        editText.setText("");

        return false;
    }
}
