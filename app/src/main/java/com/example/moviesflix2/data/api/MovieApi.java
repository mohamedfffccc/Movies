package com.example.moviesflix2.data.api;

import com.example.moviesflix2.data.model.vdata.Vdata;
import com.example.moviesflix2.data.model.viedos.Viedos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("movie/upcoming")
    Call<Viedos> getUpcoming(@Query("api_key") String api_key , @Query("page") int page);
    @GET("movie/popular")
    Call<Viedos> getPopular(@Query("api_key") String api_key , @Query("page") int page);
    @GET("movie/top_rated")
    Call<Viedos> getToprated(@Query("api_key") String api_key , @Query("page") int page);
    @GET("movie/now_playing")
    Call<Viedos> getnowplaying(@Query("api_key") String api_key , @Query("page") int page);
    @GET("movie/{movie_id}/videos")
    Call<Vdata> getMovieData(@Path ("movie_id") int id ,
                             @Query("api_key") String api_key );
}
