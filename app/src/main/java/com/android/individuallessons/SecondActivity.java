package com.android.individuallessons;

import static com.android.individuallessons.MainActivity.COUNTER_KEY;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.individuallessons.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "@@@SecondActivity";
    public static final String COUNTER_SECOND_KEY = "counter_second_key";


    private ActivitySecondBinding binding = null;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        binding = ActivitySecondBinding.inflate ( getLayoutInflater () ); // наполняем binding, обращаемся к методу который из Activity берет макет
        setContentView ( binding.getRoot () );
        Log.d ( TAG, "SecondActivity onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );

        if (COUNTER_KEY != null) {
            counter = getIntent ().getExtras ().getInt ( COUNTER_KEY );
        } else {
            counter = 10;
        }
        ((TextView) findViewById ( R.id.second_text_view )).setText ( String.valueOf ( counter ) );

        binding.buttonIncrement.setOnClickListener ( v -> {
            Toast.makeText ( this, R.string.increment, Toast.LENGTH_SHORT ).show ();
            counter++;
            updateCounterViewSecond ();
        } );

        binding.buttonDecrement.setOnClickListener ( v -> {
            Toast.makeText ( this, R.string.decrement, Toast.LENGTH_SHORT ).show ();
            counter--;
            updateCounterViewSecond ();
        } );

        binding.buttonBack.setOnClickListener ( v -> {
            Toast.makeText ( this, R.string.activity_1, Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( SecondActivity.this, MainActivity.class );
            intent.putExtra ( COUNTER_KEY, counter );
            startActivity ( intent );
            finish ();
        } );
    }

    private void updateCounterViewSecond() {//  функция. кладем значение в TextView
        binding.secondTextView.setText ( String.valueOf ( counter ) );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState ( outState );
        outState.putInt ( COUNTER_KEY, counter );
        Log.d ( TAG, "Second_onSaveInstanceState()" );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d ( TAG, "Second_onRestoreInstanceState()" );
        super.onRestoreInstanceState ( savedInstanceState );
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