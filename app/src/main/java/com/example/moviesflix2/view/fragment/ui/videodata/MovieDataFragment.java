package com.example.moviesflix2.view.fragment.ui.videodata;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.moviesflix2.R;
import com.example.moviesflix2.data.model.viedos.Result;
import com.example.moviesflix2.view.activity.PlayerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDataFragment extends Fragment {
    public Result result;
    @BindView(R.id.iv_movie_poster)
    ImageView ivMoviePoster;
    @BindView(R.id.tv_movietitle)
    TextView tvMovietitle;
    @BindView(R.id.tv_moviedesc)
    TextView tvMoviedesc;
    @BindView(R.id.btn_play)
    Button btnPlay;
    MovieDataViewModel movieDataViewModel;
    String key;
    @BindView(R.id.ratbar_vote)
    RatingBar ratbarVote;
    private String s;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_movie_data, container, false);
        ButterKnife.bind(this, root);
        movieDataViewModel = ViewModelProviders.of(this).get(MovieDataViewModel.class);
        Glide.with(getActivity()).load("https://image.tmdb.org/t/p/w500" + result.getPosterPath())
                .into(ivMoviePoster);
        tvMovietitle.setText(result.getTitle());
        tvMoviedesc.setText(result.getOverview());
        ratbarVote.setRating((float) (result.getVoteAverage() /2));
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getViedoKey();
//         Toast.makeText(getActivity() , key , Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return root;
    }

    public void getViedoKey() {
        movieDataViewModel.getKEy(result.getId(), "eb21205664da6f9c97fc2f0980dac647");
        movieDataViewModel.data.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent i = new Intent(getActivity(), PlayerActivity.class);
                i.putExtra("key", s);
                getActivity().startActivity(i);
            }
        });
    }

}
