package com.android.individuallessons;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.individuallessons.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "@@@SecondActivity";

    private ActivitySecondBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        binding = ActivitySecondBinding.inflate ( getLayoutInflater () ); // наполняем binding, обращаемся к методу который из Activity берет макет
        setContentView ( binding.getRoot () );
        Log.d ( TAG, "SecondActivity onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );

        binding.buttonBack.setOnClickListener ( v -> {
            finish ();
            Toast.makeText ( this, R.string.activity_1, Toast.LENGTH_SHORT ).show ();

        } );
    }

    @Override
    protected void onStart() {
        super.onStart ();
        Log.d ( TAG, "onStart() SecondActivity" );
    }

    @Override
    protected void onResume() {
        super.onResume ();
        Log.d ( TAG, "onResume() SecondActivity" );
    }

    @Override
    protected void onPause() {
        super.onPause ();
        Log.d ( TAG, "onPause() SecondActivity" );
    }

    @Override
    protected void onStop() {
        super.onStop ();
        Log.d ( TAG, "onStop() SecondActivity" );
    }

    @Override
    protected void onDestroy() {
        Log.d ( TAG, "onDestroy() SecondActivity" );
        super.onDestroy ();
    }
}