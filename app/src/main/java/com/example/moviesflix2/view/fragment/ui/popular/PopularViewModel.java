package com.example.moviesflix2.view.fragment.ui.popular;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesflix2.data.model.viedos.Result;
import com.example.moviesflix2.data.model.viedos.Viedos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.moviesflix2.data.api.MoviesClient.getClient;

public class PopularViewModel extends ViewModel {
    public int maxpage;

    ArrayList<Result> list = new ArrayList<>();

    MutableLiveData<List<Result>> populardata = new MutableLiveData<>();
    public void getPopular(String api_token , int page)
    {
        getClient().getPopular(api_token,page).enqueue(new Callback<Viedos>() {
            @Override
            public void onResponse(Call<Viedos> call, Response<Viedos> response) {
                populardata.postValue(response.body().getResults());
                maxpage=response.body().getTotalPages();
                Log.d("max" , maxpage+"");
            }

            @Override
            public void onFailure(Call<Viedos> call, Throwable t) {

            }
        });
    }
}