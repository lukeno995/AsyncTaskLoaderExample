package com.example.luca.asynctaskloaderexample;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    TextView mTextView;
    LoaderManager mLoaderManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoaderManager= getLoaderManager();//Return the Loader with the given id or null if no matching Loader is found.
        mTextView =  findViewById(R.id.tv_result);
        /* initLoader
        Ensures a loader is initialized and active. If the loader doesn't already exist, one is created and (if the activity/fragment is currently started) starts the loader. Otherwise the last created loader is re-used.
         */
        if(mLoaderManager.getLoader(1)!= null){
            mLoaderManager.initLoader(1,null,this);//deliver result after screen rotation
        }
    }

    public void startMyAsyncTask(View view) {
        mLoaderManager.initLoader(1,null,this);
    }
    /*
    Instantiate and return a new Loader for the given ID.
     */
    @Override
    public Loader<String> onCreateLoader(int i, Bundle bundle) {
        return new MyAsyncTaskLoader(this);
    }
    /*
    Called when a previously created loader has finished its load.
     */
    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        mTextView.setText(data);
    }

    @Override
    /*
    Called when a previously created loader is being reset, and thus making its data unavailable.
     */
    public void onLoaderReset(Loader<String> loader) {

    }
}
