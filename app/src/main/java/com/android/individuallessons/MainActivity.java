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

    private static final String TAG = "@@@MainActivity";

    //    private Button buttonActivity = null;
    private final TextView counterTextView = null;
    private int counter = 0;
//    private final Counter counter = null;

    private ActivityMainBinding binding = null;// переменная определяющая все элементы в Activity через класс ActivityMainBinding

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater () ); // наполняем binding, обращаемся к методу который из Activity берет макет
//        binding= DataBindingUtil.setContentView ( this, R.layout.activity_main );
        setContentView ( binding.getRoot () );
        Log.d ( TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );

//        buttonActivity = findViewById ( R.id.button_activity2 );
//
//        findViewById ( R.id.button_increment ).setOnClickListener ( v -> {
//            Toast.makeText ( this, R.string.increment, Toast.LENGTH_SHORT ).show ();
//            counter.increment ();
//            counterTextView.setText ( String.format ( "Нажали %d раз", counter.getCounter () ) );
//        } );
//
//        findViewById ( R.id.button_decrement ).setOnClickListener ( v -> {
//            Toast.makeText ( this, R.string.decrement, Toast.LENGTH_SHORT ).show ();
//            counter.decrement ();
//            counterTextView.setText ( String.format ( "Нажали %d раз", counter.getCounter () ) );
//        } );
//
//
//        buttonActivity.setOnClickListener ( v -> {
//            Log.d ( TAG, "MainActivity -> SecondActivity" );
//            Toast.makeText ( this, R.string.button_activity_2, Toast.LENGTH_SHORT ).show ();
//
//            Intent intent = new Intent ( MainActivity.this, SecondActivity.class );
//            startActivity ( intent );
//        } );

        binding.buttonIncrement.setOnClickListener ( v -> {
            Toast.makeText ( this, R.string.increment, Toast.LENGTH_SHORT ).show ();
            counter++;
            updateCounterView ();
//            counter.increment ();
//            counterTextView.setText ( String.format ( "Нажали %d раз", counter.getCounter () ) );
        } );

        binding.buttonDecrement.setOnClickListener ( v -> {
            Toast.makeText ( this, R.string.decrement, Toast.LENGTH_SHORT ).show ();
            counter--;
            updateCounterView ();
//            counter.decrement ();
//            counterTextView.setText ( String.format ( "Нажали %d раз", counter.getCounter () ) );
        } );

        binding.buttonActivity2.setOnClickListener ( v -> {
            Log.d ( TAG, "MainActivity -> SecondActivity" );
            Toast.makeText ( this, R.string.button_activity_2, Toast.LENGTH_SHORT ).show ();

            Intent intent = new Intent ( MainActivity.this, SecondActivity.class );
            startActivity ( intent );
        } );
    }

    private void updateCounterView() {//  создали функцию которую будем вызывать при обработке кнопки и запуске активити
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
        //todo

        super.onSaveInstanceState ( outState );
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