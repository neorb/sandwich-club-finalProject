package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import org.json.JSONException;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
    private TextView placeOfOrigin;
    private TextView alsoKnownAs;
    private TextView ingredients;
    private TextView description;
    Sandwich sandwich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /*
         * Using findViewById, we get a reference to our TextView from xml. This allows us to
         * do things like set the text of the TextView.
         */

        ImageView ingredientsIv = findViewById(R.id.image_iv);
        placeOfOrigin = (TextView) findViewById(R.id.origin_tv);
        alsoKnownAs = (TextView) findViewById(R.id.also_known_tv);
        ingredients = (TextView) findViewById(R.id.ingredients_tv);
        description = (TextView) findViewById(R.id.description_tv);


        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        sandwich = null;



        try{
            sandwich = JsonUtils.parseSandwichJson(json);
        }catch (JSONException e){
            e.printStackTrace();
        }
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI();
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI() {

        //Populating place of origin text with JSON
        TextView placeOfOriginText = (TextView) findViewById(R.id.origin_tv);
        placeOfOriginText.setText(sandwich.getPlaceOfOrigin());

        //Populating also known as text with JSON
        TextView alsoKnownAsText = (TextView) findViewById(R.id.also_known_tv);
        alsoKnownAsText.setText(sandwich.getAlsoKnownAs() + ", ");

        //Populating ingredients text with JSON
        TextView ingredientsText = (TextView) findViewById(R.id.ingredients_tv);
        ingredientsText.setText(sandwich.getIngredients() + ", ");


        //Populating description text with JSON
        TextView descriptionText = (TextView) findViewById(R.id.description_tv);
        descriptionText.setText(sandwich.getDescription());
    }
}
