package com.example.rangi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yuku.ambilwarna.AmbilWarnaDialog;

public class colourSelection extends AppCompatActivity {

    // this is the default color of the preview box
    private int mDefaultColor, mDefaultColor2;
    // view box to preview the selected color
    private View mColorPreview, mColorPreview2, mColorPreview3;
    private Button getColorButton, mPickColorButton, mPickColorButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colour_selection);
        mPickColorButton = findViewById(R.id.pick_color_button1);
        mPickColorButton2 = findViewById(R.id.pick_color_button2);
        getColorButton = findViewById(R.id.get_suggestion_button);

        // preview of the color chosen by the user
        mColorPreview = findViewById(R.id.preview_selected_color1);
        mColorPreview2 = findViewById(R.id.preview_selected_color2);
        mColorPreview3 = findViewById(R.id.suggested_color);
        // button open the AmbilWanra color picker dialog.
        mPickColorButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // to make code look cleaner the color
                        // picker dialog functionality are
                        // handled in openColorPickerDialogue()
                        // function
                        openColorPickerDialogue();
                    }
                });
        mPickColorButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // to make code look cleaner the color
                        // picker dialog functionality are
                        // handled in openColorPickerDialogue()
                        // function
                        openColorPickerDialogue2();
                    }
                });
        getColorButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // to make code look cleaner the color
                        // picker dialog functionality are
                        // handled in openColorPickerDialogue()
                        // function
                        generateThird();
                    }
                }
        );
    }

    public void openColorPickerDialogue() {

        // the AmbilWarnaDialog callback needs 3 parameters
        // one is the context, second is default color,
        final AmbilWarnaDialog colorPickerDialogue = new AmbilWarnaDialog(this, mDefaultColor,
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                        // leave this function body as
                        // blank, as the dialog
                        // automatically closes when
                        // clicked on cancel button
                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        // change the mDefaultColor to
                        // change the GFG text color as
                        // it is returned when the OK
                        // button is clicked from the
                        // color picker dialog
                        mDefaultColor = color;

                        // now change the picked color
                        // preview box to mDefaultColor
                        mColorPreview.setBackgroundColor(mDefaultColor);
                    }
                });
        colorPickerDialogue.show();
    }

    public void openColorPickerDialogue2() {

        // the AmbilWarnaDialog callback needs 3 parameters
        // one is the context, second is default color,
        final AmbilWarnaDialog colorPickerDialogue = new AmbilWarnaDialog(this, mDefaultColor2,
                new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {
                        // leave this function body as
                        // blank, as the dialog
                        // automatically closes when
                        // clicked on cancel button
                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        // change the mDefaultColor to
                        // change the GFG text color as
                        // it is returned when the OK
                        // button is clicked from the
                        // color picker dialog
                        mDefaultColor2 = color;

                        // now change the picked color
                        // preview box to mDefaultColor
                        mColorPreview2.setBackgroundColor(mDefaultColor2);
                    }
                });
        colorPickerDialogue.show();
    }

    public void generateThird() {
        int thirdColor = (mDefaultColor + mDefaultColor2) / 2;
        mColorPreview3.setBackgroundColor(thirdColor);
    }
}