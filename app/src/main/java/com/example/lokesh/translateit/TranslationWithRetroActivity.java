package com.example.lokesh.translateit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TranslationWithRetroActivity extends AppCompatActivity {

    public String BASE_URL = "https://www.googleapis.com/language/translate/", TAG = "TWRA*****";
    public List<String> sourceList  = new ArrayList<>();
    private RestAdapter adapter;
    private DetailsAPI api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation_with_retro);

        createSourceList();

       adapter = new RestAdapter.Builder().setEndpoint(BASE_URL).build();
        api = adapter.create(DetailsAPI.class);

        for (int i = 0; i < sourceList.size(); i++) {
            translateThis(sourceList.get(i));
        }

    }

    public void translateThis(String translate){
        api.insertUser("AIzaSyD0K3AWq35Mrnk63_IkJFgwSRZgRJ_2vFg", translate, "te", "en", new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {
                Log.d(TAG, "success: " + jsonObject.toString());
                System.out.print(jsonObject.toString());
                /*{"data":{"translations":[{"translatedText":"మీ వయస్సు ఎంత?"}]}} */

            }

            @Override
            public void failure(RetrofitError error) {
                Log.d(TAG, "failure: " + error.getMessage());
            }
        });
    }

    private void createSourceList() {
        sourceList.add("who is our president?");
        sourceList.add("who is our chief minister?");
        sourceList.add("My name is lokesh.");
        sourceList.add("what is your name?");
        sourceList.add("what is your father?");
        sourceList.add("what is your mother?");
        sourceList.add("what is your favorite book?");
        sourceList.add("How old are you?");
        sourceList.add("what is your favorite color?");
        sourceList.add("what is your profession?");
    }



}
