package com.example.blogtest;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextIngredient;
    private Button addIngredientButton;
    private LinearLayout ingredientListLayout;

    private List<String> ingredientList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextIngredient = findViewById(R.id.editTextIngredient);
        addIngredientButton = findViewById(R.id.addIngredientButton);
        ingredientListLayout = findViewById(R.id.ingredientListLayout);

        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ingredient = editTextIngredient.getText().toString().trim();
                if (!ingredient.isEmpty()) {
                    addIngredientToList(ingredient);
                    editTextIngredient.setText("");
                }
            }
        });
    }

    private void addIngredientToList(final String ingredient) {
        TextView ingredientTextView = new TextView(this);
        ingredientTextView.setText(ingredient);
        ingredientTextView.setTextSize(18);
        ingredientTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performNaverSearch(ingredient);
            }
        });
        ingredientListLayout.addView(ingredientTextView);
    }

    private void performNaverSearch(String query) {
        if (!query.contains("레시피")) {
            query += " 레시피";
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.naver.com/search.naver?query=" + Uri.encode(query)));
        startActivity(intent);
    }
}