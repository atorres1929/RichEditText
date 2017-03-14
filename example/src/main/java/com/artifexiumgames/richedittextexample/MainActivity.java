package com.artifexiumgames.richedittextexample;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import com.artifexiumgames.richedittext.RichEditText;

public class MainActivity extends AppCompatActivity {

    private RichEditText editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
