package com.example.hellohacks.ui.profile;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hellohacks.DatabaseHelper;
import com.example.hellohacks.R;
import com.example.hellohacks.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private EditText nameEditText, emailEditText, usernameEditText, ageEditText, genderEditText, goalEditText;
    private Button saveButton;
    private DatabaseHelper dbHelper;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        dbHelper = new DatabaseHelper(getActivity());
        nameEditText = (EditText) view.findViewById(R.id.editTextText);
        emailEditText = (EditText) view.findViewById(R.id.editTextText5);
        usernameEditText = (EditText) view.findViewById(R.id.editTextText2);
        ageEditText = (EditText) view.findViewById(R.id.editTextText3);
        genderEditText = (EditText) view.findViewById(R.id.editTextText4);
        goalEditText = (EditText)view.findViewById(R.id.editTextText7);
        saveButton = (Button) view.findViewById(R.id.button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
            }
        });

    }

    private void saveUserData() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        int age = Integer.parseInt(ageEditText.getText().toString().trim());
        String gender = genderEditText.getText().toString().trim();
        String goal = goalEditText.getText().toString().trim();

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("username", username);
        values.put("age", age);
        values.put("gender", gender);
        values.put("goal", goal);

        try {
            long newRowId = db.insert("user", null, values);
            if (newRowId != -1) {
                Toast.makeText(getActivity(), "Data saved successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Error saving data.", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
