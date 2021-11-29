package com.android.individuallessons;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.individuallessons.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;// переменная определяющая все элементы в Activity через класс ActivityMainBinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater () ); // наполняем binding, обращаемся к методу который из Activity берет макет
        setContentView ( R.layout.activity_main );
    }
}