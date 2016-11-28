package com.example.danielnesfeder.popularmovies1;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by plk5227 on 10/22/16.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    private CardView movieCard;
    public NetworkImageView moviePoster;
    public MovieInfo movieInfo;

    public MovieViewHolder(final View itemView) {
        super(itemView);

        moviePoster = (NetworkImageView) itemView.findViewById(R.id.niw_movie_poster);
        movieCard = (CardView) itemView.findViewById(R.id.cv_movie_card);
        movieCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }
}
