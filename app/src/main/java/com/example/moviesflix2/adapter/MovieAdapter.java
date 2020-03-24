package com.example.moviesflix2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesflix2.R;
import com.example.moviesflix2.data.model.viedos.Result;
import com.example.moviesflix2.view.activity.HomePage;
import com.example.moviesflix2.view.fragment.ui.videodata.MovieDataFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

;import static com.example.moviesflix2.data.helper.HelperMethod.replace;


/**
 * Created by medo on 13/11/2016.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ArticlesViewHolder> {

    private Context context;
    private List<Result> articleslist = new ArrayList<>();
    public boolean pressed = false;
    int PostId;
    View myview;
    public boolean IsFav;
    HomePage activity;

    public MovieAdapter(List<Result> articleslist, Context context,HomePage activity) {
        this.articleslist = articleslist;
        this.context = context;
        this.activity=activity;

    }

    @NonNull
    @Override
    public ArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new ArticlesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticlesViewHolder holder, int position) {

        Result article = articleslist.get(position);
        holder.tvTitle.setText(article.getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+article.getPosterPath())
                .into(holder.ivPoster);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieDataFragment fragment = new MovieDataFragment();
                fragment.result=articleslist.get(position);
                replace( fragment, activity.getSupportFragmentManager(), R.id.nav_host_fragment
                        , null, "movie");

            }
        });


    }

    @Override
    public int getItemCount() {
        return articleslist.size();
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_poster)
        ImageView ivPoster;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        public ArticlesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

    }


}
