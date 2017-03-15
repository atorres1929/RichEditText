package com.artifexiumgames.richedittextexample;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import com.artifexiumgames.richedittext.RichEditText;

public class MainActivity extends AppCompatActivity {

    private RichEditText editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        editor = (RichEditText) findViewById(R.id.editor);

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
        switch (item.getItemId()){
            case R.id.action_dayMode:
                getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                finish();
                startActivity(getIntent());
                return true;
            case R.id.action_nightMode:
                getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                finish();
                startActivity(getIntent());
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
