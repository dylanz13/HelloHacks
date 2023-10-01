package com.example.hellohacks.ui.recipe;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.core.app.NavUtils;

public class ORecipe extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return false;
    }
}
