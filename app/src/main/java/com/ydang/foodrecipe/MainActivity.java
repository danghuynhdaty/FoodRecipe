package com.ydang.foodrecipe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listRecipesView;
    String[] recipeNames = {"margarita", "margarita","margarita","margarita","margarita"};
    int[] recipeImages = { R.drawable.margarita,R.drawable.margarita,R.drawable.margarita,R.drawable.margarita};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listRecipesView = findViewById(R.id.listRecipes);
        CustomAdapter adapter = new CustomAdapter();
        listRecipesView.setAdapter(adapter);

        listRecipesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),FoodRecipesListActivity.class);
                intent.putExtra("name", recipeNames[position]);
                intent.putExtra("image", recipeImages[position]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return recipeImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View detailsView = getLayoutInflater().inflate(R.layout.food_recipe_item, null);

            TextView recipeName = detailsView.findViewById(R.id.recipeName);
            ImageView recipeImage = detailsView.findViewById(R.id.recipeImage);

            recipeName.setText(recipeNames[position]);
            recipeImage.setImageResource(recipeImages[position]);
            return detailsView;
        }
    }
}
