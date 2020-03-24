package com.example.moviesflix2.view.fragment.ui.upcoming;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesflix2.view.activity.HomePage;
import com.example.moviesflix2.adapter.MovieAdapter;
import com.example.moviesflix2.R;
import com.example.moviesflix2.data.model.viedos.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.moviesflix2.data.helper.HelperMethod.dismissProgressDialog;
import static com.example.moviesflix2.data.helper.HelperMethod.showProgressDialog;

public class UpcomingFragment extends Fragment {
    @BindView(R.id.rv_upcoming)
    RecyclerView rvPopularlist;
    GridLayoutManager popularlayoutmanger;
    MovieAdapter adapter;

    private UpcomingViewModel upcomingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        upcomingViewModel =
                ViewModelProviders.of(this).get(UpcomingViewModel.class);
        View root = inflater.inflate(R.layout.upcoming, container, false);
        ButterKnife.bind(this, root);
        popularlayoutmanger=new GridLayoutManager(getActivity() , 3);

        rvPopularlist.setLayoutManager(popularlayoutmanger);
        getUpcoming();
        return root;
    }
    public void getUpcoming()
    {
        showProgressDialog((HomePage) getActivity() , "wait");
        upcomingViewModel.getUpcomingData("eb21205664da6f9c97fc2f0980dac647",1);
        upcomingViewModel.upcomingdata.observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                dismissProgressDialog();
                adapter=new MovieAdapter(results , getActivity(),(HomePage) getActivity());
                rvPopularlist.setAdapter(adapter);
            }
        });

    }
}