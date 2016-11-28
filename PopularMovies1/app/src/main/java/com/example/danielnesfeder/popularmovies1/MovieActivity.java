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
        MovieInfo movieInfo1 = new MovieInfo();
        movieInfo1.setImageUrl("https://image.tmdb.org/t/p/w500/6I2tPx6KIiBB4TWFiWwNUzrbxUn.jpg");
        movieInfo1.setTitle("Fantastic Beasts and Where to Find Them");
        movieInfo1.setOverview("In 1926, Newt Scamander arrives at the Magical Congress of the United States of America" +
                " with a magically expanded briefcase, which houses a number of dangerous creatures and their habitats. " +
                "When the creatures escape from the briefcase, it sends the American wizarding authorities after Newt, " +
                "and threatens to strain even further the state of magical and non-magical relations.");
        movieInfo1.setReleaseDate("2016-10-25");
        movieInfo1.setVoteAverage(7.2);
        movieInfos.add(movieInfo1);
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
