package com.example.luca.asynctaskloaderexample;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

/**
 * Created by Luca on 12/02/2018.
 */

public class MyAsyncTaskLoader extends AsyncTaskLoader<String> {
    public MyAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public String loadInBackground() {
        for(int i=0; i<100; i++){
            try {

                Thread.sleep(50);
                Log.i("TAG","LoadInBackground: "+ i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return "Task result";
    }

    @Override
    protected void onStartLoading() {
      forceLoad();
    }
}
