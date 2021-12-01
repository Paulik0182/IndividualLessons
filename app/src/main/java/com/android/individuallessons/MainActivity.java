package com.android.individuallessons;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.individuallessons.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    public static final String COUNTER_KEY = "counter_key";
    private static final String TAG = "@@@MainActivity";

    private final TextView counterTextView = null;

    private ActivityMainBinding binding = null;// переменная определяющая все элементы в Activity через класс ActivityMainBinding
    private int counter = 0;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater () ); // наполняем binding, обращаемся к методу который из Activity берет макет
        setContentView ( binding.getRoot () );//не забыть дать Root права
        Log.d ( TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );

        binding.buttonIncrement.setOnClickListener ( v -> {
            Toast.makeText ( this, R.string.increment, Toast.LENGTH_SHORT ).show ();
            counter++;
            updateCounterView ();
        } );

        binding.buttonDecrement.setOnClickListener ( v -> {
            Toast.makeText ( this, R.string.decrement, Toast.LENGTH_SHORT ).show ();
            counter--;
            updateCounterView ();
        } );

        binding.buttonActivity2.setOnClickListener ( v -> {
            Log.d ( TAG, "MainActivity -> SecondActivity" );
            Toast.makeText ( this, R.string.button_activity_2, Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( MainActivity.this, SecondActivity.class );
            startActivity ( intent );
        } );
    }

    private void updateCounterView() {//  функция. кладем значение в TextView
        binding.counterTextView.setText ( String.valueOf ( counter ) );
    }

    @Override
    protected void onStart() {
        super.onStart ();
        Log.d ( TAG, "onStart() called" );
    }

    @Override
    protected void onResume() {
        super.onResume ();
        Log.d ( TAG, "onResume() called" );
    }

    @Override
    protected void onPause() {
        super.onPause ();
        Log.d ( TAG, "onPause() called" );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState ( outState );
        outState.putInt ( "COUNTER_KEY", counter );
        Log.d ( TAG, "onSaveInstanceState()" );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState ( savedInstanceState );
        Log.d ( TAG, "onRestoreInstanceState()" );
    }

    @Override
    protected void onStop() {
        //todo

        super.onStop ();
        Log.d ( TAG, "onStop() called" );
    }

    @Override
    protected void onDestroy() {
        Log.d ( TAG, "onDestroy() called" );
        super.onDestroy ();
    }
}