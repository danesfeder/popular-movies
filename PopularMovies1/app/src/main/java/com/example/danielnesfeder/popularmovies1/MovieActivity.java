package com.example.danielnesfeder.popularmovies1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {

    private MovieAdapter movieAdapter;
    private RecyclerView movieList;
    private GridLayoutManager layoutManager;
    private ArrayList<MovieInfo> movieInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        prepareFakeMovieData();

        // Set up the RecyclerView with a GridLayoutManager with a span of 4
        movieList = (RecyclerView) findViewById(R.id.rv_movie_list);
        movieList.setLayoutManager(new GridLayoutManager(this, 2));
        movieList.setHasFixedSize(true);
        movieList.setItemAnimator(new DefaultItemAnimator());

        // Create and set the adapter
        movieAdapter = new MovieAdapter(movieInfos, getApplicationContext());
        movieList.setAdapter(movieAdapter);
    }

    private void prepareFakeMovieData() {
        movieInfos = new ArrayList<>();
        movieInfos.add(new MovieInfo("Fight Club", "https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
        movieInfos.add(new MovieInfo("Fantastic Beasts", "https://image.tmdb.org/t/p/w500/6I2tPx6KIiBB4TWFiWwNUzrbxUn.jpg"));
        movieInfos.add(new MovieInfo("Fight Club", "https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
        movieInfos.add(new MovieInfo("Fight Club", "https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
        movieInfos.add(new MovieInfo("Fight Club", "https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
        movieInfos.add(new MovieInfo("Fight Club", "https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
        movieInfos.add(new MovieInfo("Fight Club", "https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
        movieInfos.add(new MovieInfo("Fight Club", "https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
        movieInfos.add(new MovieInfo("Fight Club", "https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
        movieInfos.add(new MovieInfo("Fight Club", "https://image.tmdb.org/t/p/w500/8uO0gUM8aNqYLs1OsTBQiXu0fEv.jpg"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
