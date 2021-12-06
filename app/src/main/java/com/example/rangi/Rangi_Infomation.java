package com.example.rangi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.rangi.databinding.ActivityRangiInfomationBinding;

public class Rangi_Infomation extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "TestToolBar";
    static String optionText = "Rangi is an Application that helps you to '\n'match colours that can look together by '\n' comparing the first";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangi_infomation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Color Is a language that everyone Understands!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.rangi_info, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi) {
        switch(mi.getItemId()) {
            case R.id.bucket_icon:
                Log.d("Toolbar", "This is a color Bucket");
                Snackbar.make(findViewById(R.id.bucket_icon), optionText, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;

            case R.id.colorpaint_icon:
                Log.d("Toolbar", "This is a color Painting icon");
                AlertDialog.Builder builder = new AlertDialog.Builder(Rangi_Infomation.this);
                builder.setTitle(R.string.dialog_title)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User clicked OK button
                                Intent resultIntent = new Intent(  );
                                setResult(Activity.RESULT_OK, resultIntent);
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        })
                        .show();
                break;

            case R.id.color_filler:
                Log.d("Toolbar", "This is a color Filling Icon");
                AlertDialog.Builder builder2 = new AlertDialog.Builder(Rangi_Infomation.this);
                // Get the layout inflater
                LayoutInflater inflater = this.getLayoutInflater();
                final View customDialogLayout = inflater.inflate(R.layout.activity_custom_layout, null);

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder2.setView(customDialogLayout)
                        // Add action buttons
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                optionText = ((EditText) customDialogLayout.findViewById(R.id.NewMessage)).getText().toString();

                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        })
                        .show();
                break;

            case R.id.action_about:
                Log.d("Toolbar", "About Action is Clicked");
                CharSequence text = "Version 1.0, Designed by Yvonne, Dennis, Tino, Michael and Raul";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(getApplicationContext() ,text ,duration);
                toast.show();
                break;
        }

        return true;
    }
}