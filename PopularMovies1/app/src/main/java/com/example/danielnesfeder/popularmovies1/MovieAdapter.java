package com.example.danielnesfeder.popularmovies1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private ImageLoader loader;
    private ArrayList<MovieInfo> movies;

    MovieAdapter(ArrayList<MovieInfo> movieInfo, Context context) {
        this.movies = movieInfo;
        this.loader = VolleySingleton.getInstance(context).getImageLoader();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_card_layout, parent, false);

        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieInfo movieInfo = movies.get(position);
        holder.moviePoster.setImageUrl(movieInfo.getImageUrl(), loader);
        holder.movieInfo = movieInfo;
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
