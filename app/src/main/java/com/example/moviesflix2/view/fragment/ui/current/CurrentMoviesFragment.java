package com.example.moviesflix2.view.fragment.ui.current;

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

public class CurrentMoviesFragment extends Fragment {

    private CurrentViewModel shareViewModel;
    @BindView(R.id.rv_current)
    RecyclerView rvcurrent;

    GridLayoutManager currentlayoutmanger;
    MovieAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(CurrentViewModel.class);
        View root = inflater.inflate(R.layout.current, container, false);
        ButterKnife.bind(this, root);
        currentlayoutmanger=new GridLayoutManager(getActivity() , 3);

        rvcurrent.setLayoutManager(currentlayoutmanger);
        getNowPlaying();

        return root;
    }
    public void getNowPlaying()
    {
        showProgressDialog((HomePage) getActivity() , "wait");
        shareViewModel.getNowplaying("eb21205664da6f9c97fc2f0980dac647",1);
        shareViewModel.nowplayingdata.observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                dismissProgressDialog();
                adapter=new MovieAdapter(results , getActivity(),(HomePage) getActivity());
                rvcurrent.setAdapter(adapter);
            }
        });

    }
}