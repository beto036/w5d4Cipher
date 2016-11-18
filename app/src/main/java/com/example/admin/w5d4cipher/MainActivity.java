package com.example.admin.w5d4cipher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyCipher myCipher;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCipher = new MyCipher();
        textView = (TextView) findViewById(R.id.aMainTxt);
        editText = (EditText) findViewById(R.id.aMainEdit);
    }

    public void encrypt(View view) {
        String text = editText.getText().toString();
        String result = "";
        try {
            result = MyCipher.byteArrayToHexString(myCipher.encrypt(text));

        } catch (Exception e) {
            result = "Error";
        }

        textView.setText(result);

    }

    public void decrypt(View view) {
        String text = textView.getText().toString();
        String result = "";

        try {
            result = new String(myCipher.decrypt(text));
        } catch (Exception e) {
            result = "Error";
        }
        textView.setText(result);
    }
}
