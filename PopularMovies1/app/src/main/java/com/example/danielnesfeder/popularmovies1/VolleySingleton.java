package com.example.danielnesfeder.popularmovies1;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by danielnesfeder on 11/27/16.
 *
 */

public class VolleySingleton {
    private static VolleySingleton mInstance = null;
    private ImageLoader mImageLoader;

    private VolleySingleton(Context context) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(context, new HurlStack() {
            @Override
            protected HttpURLConnection createConnection(URL url) throws IOException {

                HttpURLConnection connection = super.createConnection(url);
                connection.setInstanceFollowRedirects(true);
                return connection;
            }
        });
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<>(10);
            @Override
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
        });
    }

    static VolleySingleton getInstance(Context context){
        if (mInstance == null) {
            mInstance = new VolleySingleton(context);
        }
        return mInstance;
    }

    ImageLoader getImageLoader() {
        return this.mImageLoader;
    }
}
