package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    /**
     * Create a "private static String" for each description
     */
    private final static String name ="name";
    private final static String main_name= "mainName";
    private final static String also_known_as = "alsoKnownAs";
    private final static String place_origin = "placeOfOrigin";
    private final static String descriptions ="description";
    private final static String images ="image";
    private final static String ingredient= "ingredients";



    public static Sandwich parseSandwichJson(String Json) throws JSONException {
        Sandwich sandwich = null;

        //Create a condition "if" if Empty
        if (Json != null && !Json.isEmpty()){

            JSONObject sandwich_JSON = new JSONObject(Json);

            JSONObject name_JSON = sandwich_JSON.optJSONObject(name);
            JSONArray alsoKnownAs_JSON = name_JSON.optJSONArray(also_known_as);
            JSONArray ingredients_JSON = sandwich_JSON.optJSONArray(ingredient);

            //create a for loop to iterate
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i=0; i < alsoKnownAs_JSON.length(); i++){
                String alsoKnownAsName = alsoKnownAs_JSON.optString(i);
                alsoKnownAs.add(alsoKnownAsName);
            }

            String mainName = name_JSON.optString(main_name);
            String placeOfOrigin = sandwich_JSON.optString(place_origin);
            String description = sandwich_JSON.optString(descriptions);
            String image = sandwich_JSON.optString(images);

            //create a for loop to iterate
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredients_JSON.length(); i++){
                String ingredient = ingredients_JSON.optString(i);
                ingredients.add(ingredient);
            }
            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        }


        return sandwich;
    }
}
