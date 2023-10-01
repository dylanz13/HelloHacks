package com.example.hellohacks.ui.recipe;

import android.widget.Button;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Recipes");
    }

    public Button findViewById(int view) {
        return (Button) findViewById(view);
    }

    public LiveData<String> getText() {
        return mText;
    }
}