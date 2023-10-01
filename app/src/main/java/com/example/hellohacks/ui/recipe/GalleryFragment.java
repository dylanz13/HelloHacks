package com.example.hellohacks.ui.recipe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.hellohacks.MainActivity;
import com.example.hellohacks.R;
import com.example.hellohacks.databinding.FragmentGalleryBinding;
import com.example.hellohacks.ui.home.HomeFragment;

public class GalleryFragment extends Fragment {
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ImageButton b1 = (ImageButton) view.findViewById(R.id.Recipe1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.everydayhealth.com/diet-nutrition/pescatarian-diet-food-list-meal-plan-benefits-risks-more/"));
                startActivity(browserIntent);

            }
        });
        ImageButton b2 = (ImageButton) view.findViewById(R.id.Recipe2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eatwell101.com/corn-avocado-pasta-salad-recipe"));
                startActivity(browserIntent);
            }
        });
        ImageButton b3 = (ImageButton) view.findViewById(R.id.Recipe3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://dranthonygustin.com/low-carb-vs-keto-ketosis-different-low-carb-diet/"));
                startActivity(browserIntent);
            }
        });
    }
}