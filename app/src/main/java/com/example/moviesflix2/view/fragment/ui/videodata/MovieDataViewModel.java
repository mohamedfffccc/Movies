package com.example.moviesflix2.view.fragment.ui.videodata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesflix2.data.model.vdata.Vdata;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.moviesflix2.data.api.MoviesClient.getClient;

public class MovieDataViewModel extends ViewModel {
MutableLiveData<String> data=new MutableLiveData<>();
public void  getKEy(int id , String api_key)
{
    getClient().getMovieData(id,api_key).enqueue(new Callback<Vdata>() {
        @Override
        public void onResponse(Call<Vdata> call, Response<Vdata> response) {
            data.setValue(response.body().getResults().get(0).getKey());
        }

        @Override
        public void onFailure(Call<Vdata> call, Throwable t) {

        }
    });
}
}
