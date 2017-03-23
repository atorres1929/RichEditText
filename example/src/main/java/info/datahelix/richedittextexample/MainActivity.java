package com.artifexiumgames.richedittextexample;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import info.datahelix.richedittext.RichEditText;

import java.util.ArrayList;

import info.datahelix.richedittextexample.R;

public class MainActivity extends AppCompatActivity {

    private RichEditText editor;

    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        editor = (RichEditText) findViewById(R.id.editor);

        if (getIntent().hasExtra("text")) {
            editor.setText(getIntent().getCharSequenceExtra("text"));
        }

        /*
         ***********
         * SETTINGS
         ***********
         */
        //Default color list, these are the default colors that will be provided to the user.
        ArrayList<RichEditText.ColorString> colorList = new ArrayList<>();
        colorList.add(new RichEditText.ColorString("Green", 0x008000));
        colorList.add(new RichEditText.ColorString("Blue", 0x0000FF));
        colorList.add(new RichEditText.ColorString("Purple", 0x800080));
        colorList.add(new RichEditText.ColorString("Red", 0xFF0000));
        colorList.add(new RichEditText.ColorString("Orange", 0xFFA500));
        colorList.add(new RichEditText.ColorString("Yellow", 0xFFFF00));
        colorList.add(new RichEditText.ColorString("Hot Pink", 0xFF69B4));
        colorList.add(new RichEditText.ColorString("Light Blue", 0x00FFF9));
        colorList.add(new RichEditText.ColorString("Brown", 0xA52A2A));

        //Number of spaces in a tab
        int numTabs = 4;

        //Relative size of superscript and subscript text (Relative to the standard text)
        float relativeSize = 0.5f;

        //Alpha of the highlighted text, read documentation in setSettings() to learn more. TL;DR you need some alpha, and it's a value from 0 to 255
        int alpha = 191;

        //Primary color, the color the text will be by default
        int primaryColor = ContextCompat.getColor(getApplicationContext(), R.color.textColorPrimary);

        //Background color, the color the text's background will be by default
        int backgroundColor = ContextCompat.getColor(getApplicationContext(), R.color.textColorBackground);


        editor.setSettings(primaryColor, backgroundColor, colorList, numTabs, relativeSize, alpha);

        ToggleButton boldButton = (ToggleButton) findViewById(R.id.bold);
        ToggleButton italicButton = (ToggleButton) findViewById(R.id.italic);
        ToggleButton underlineButton = (ToggleButton) findViewById(R.id.underline);
        underlineButton.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        ToggleButton strikethroughButton = (ToggleButton) findViewById(R.id.strikethrough);
        strikethroughButton.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        ImageButton indentButton = (ImageButton) findViewById(R.id.indent);
        ImageButton unindentButton = (ImageButton) findViewById(R.id.unindent);

        ImageButton textColorButton = (ImageButton) findViewById(R.id.textcolor);
        ImageButton textHighlightButton = (ImageButton) findViewById(R.id.highlighter);

        ImageButton subscriptButton = (ImageButton) findViewById(R.id.subscript);
        ImageButton superscriptButton = (ImageButton) findViewById(R.id.superscript);
        editor.setAllButtons(boldButton, italicButton, underlineButton, strikethroughButton, subscriptButton, superscriptButton, unindentButton, indentButton, textColorButton, textHighlightButton);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.action_dayMode:
                getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("text", editor.getText());
                finish();
                startActivity(intent);
                return true;
            case R.id.action_nightMode:
                getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("text", editor.getText());
                finish();
                startActivity(intent);
                return true;
            case R.id.action_github:
                //TODO link to github
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

}
