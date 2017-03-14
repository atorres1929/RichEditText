package com.artifexiumgames.richedittextexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.artifexiumgames.richedittext.RichEditText;

public class MainActivity extends AppCompatActivity {

    private RichEditText editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editor = (RichEditText) findViewById(R.id.editor);

    }
}
