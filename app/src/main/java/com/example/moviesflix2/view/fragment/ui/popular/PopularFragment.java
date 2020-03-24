package com.example.moviesflix2.view.fragment.ui.popular;

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
import com.example.moviesflix2.data.helper.OnEndLess;
import com.example.moviesflix2.R;
import com.example.moviesflix2.data.model.viedos.Result;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.moviesflix2.data.helper.HelperMethod.dismissProgressDialog;
import static com.example.moviesflix2.data.helper.HelperMethod.showProgressDialog;

public class PopularFragment extends Fragment {
    ArrayList<Result> list;

    @BindView(R.id.rv_popularlist)
    RecyclerView rvPopularlist;
    private PopularViewModel homeViewModel;
    GridLayoutManager popularlayoutmanger;
    MovieAdapter adapter;
    private OnEndLess onEndLess;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(PopularViewModel.class);
        View root = inflater.inflate(R.layout.popular, container, false);
        ButterKnife.bind(this, root);
        popularlayoutmanger=new GridLayoutManager(getActivity() , 3);
list=new ArrayList<>();
        rvPopularlist.setLayoutManager(popularlayoutmanger);
        getDataPopular(1);
        onEndLess = new OnEndLess(popularlayoutmanger
                , 1) {
            @Override
            public void onLoadMore(int current_page) {

                if (current_page <= homeViewModel.maxpage) {
                    if (homeViewModel.maxpage != 0 && current_page != 1) {
                        onEndLess.previous_page = current_page;
                        getDataPopular(current_page);
                        adapter.notifyDataSetChanged();
                    } else {
                        onEndLess.current_page = onEndLess.previous_page;
                    }
                } else {
                    onEndLess.current_page = onEndLess.previous_page;

                }


            }
        };
        rvPopularlist.addOnScrollListener(onEndLess);

        return root;
    }
    public void getDataPopular(int page)
    {
        showProgressDialog((HomePage) getActivity() , "wait");
        homeViewModel.getPopular("eb21205664da6f9c97fc2f0980dac647",page);
        homeViewModel.populardata.observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                dismissProgressDialog();

                list.addAll(results);
                adapter=new MovieAdapter(list , getActivity() , (HomePage) getActivity());
                rvPopularlist.setAdapter(adapter);
            }
        });

    }
}