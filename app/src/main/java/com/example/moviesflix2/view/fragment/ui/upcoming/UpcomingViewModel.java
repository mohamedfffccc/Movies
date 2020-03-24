package com.example.moviesflix2.view.fragment.ui.upcoming;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesflix2.data.model.viedos.Result;
import com.example.moviesflix2.data.model.viedos.Viedos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.moviesflix2.data.api.MoviesClient.getClient;

public class UpcomingViewModel extends ViewModel {
MutableLiveData<List<Result>> upcomingdata = new MutableLiveData<>();
public void getUpcomingData(String api_key , int page)
{
    getClient().getUpcoming(api_key,page).enqueue(new Callback<Viedos>() {
        @Override
        public void onResponse(Call<Viedos> call, Response<Viedos> response) {
            upcomingdata.setValue(response.body().getResults());
        }

        @Override
        public void onFailure(Call<Viedos> call, Throwable t) {

        }
    });
}
}