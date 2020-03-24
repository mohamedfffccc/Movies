package com.example.moviesflix2.view.fragment.ui.current;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesflix2.data.model.viedos.Result;
import com.example.moviesflix2.data.model.viedos.Viedos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.moviesflix2.data.api.MoviesClient.getClient;

public class CurrentViewModel extends ViewModel {
MutableLiveData<List<Result>> nowplayingdata = new MutableLiveData<>();
    public void getNowplaying(String api_token , int page) {
        getClient().getnowplaying(api_token, page).enqueue(new Callback<Viedos>() {
            @Override
            public void onResponse(Call<Viedos> call, Response<Viedos> response) {
                nowplayingdata.setValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<Viedos> call, Throwable t) {

            }
        });
    }
}