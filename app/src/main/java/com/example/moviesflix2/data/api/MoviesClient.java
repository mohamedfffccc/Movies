package com.example.moviesflix2.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesClient {
    public static  String BASE_URL = "https://api.themoviedb.org/3/";
    public static MovieApi getClient()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MovieApi.class);
    }
}
