package com.example.tanner.recipereaderapp;

import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.InputStream;


public class HomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Initialize views
        TextView recipeView = (TextView)findViewById(R.id.recipeView);

        //System.out.println("Creating assetManager and call getAssets()");
        AssetManager assetManager = getAssets();

        InputStream input;
        //System.out.println("InputStream declared");

        try{

            input = assetManager.open("test_recipe.txt");
            //Log.d("readFile->try", "Trying to open file.");
            //System.out.println("Input: " + input);

            int size = input.available();
            //System.out.println("Size: " + size);

            //System.out.println("Creating byte buffer");
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            //System.out.println("Byte buffer closed");

            String text = new String(buffer);
            //System.out.println("Text: " + text);

            //System.out.println("Setting the text to display in the textBox for filename");
            recipeView.setText(text);
        }
        catch(Exception e){

            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
