package com.ydang.foodrecipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodRecipesListActivity extends AppCompatActivity {
    TextView recipeName;
    ImageView recipeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_recipes_list);

        recipeImage = findViewById(R.id.recipeImage);
        recipeName = findViewById(R.id.recipeName);

        Intent intent = new Intent();
        recipeName.setText(intent.getStringExtra("name"));
        recipeImage.setImageResource(intent.getIntExtra("image", 0));
    }
}
