package com.example.sortingproject;

import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ChosenActivity extends AppCompatActivity {

	TextView tvNumbers;
	TextView tvIntro;
	Button btNextChosen;
	int size;
	int[] numbers;
	String textNumbers="";
	Intent intent;
	int algorithm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chosen);
		intent = getIntent();
		size = intent.getIntExtra("size", 0);
		algorithm = intent.getIntExtra("algorithm", 0);
		btNextChosen = (Button) findViewById(R.id.btNextChosen);
		
		tvIntro = (TextView) findViewById(R.id.tvIntro);
		tvNumbers = (TextView) findViewById(R.id.tvNumbers);
		tvIntro.setText("Chosen array for sorting. There are " + size
				+ " numbers");
		numbers = new int[size];

		int max = 100;
		int min = 1;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				int randomNum = (new Random()).nextInt((max - min) + 1) + min;
				numbers[i] = randomNum;
				textNumbers+=randomNum+ " ";
			}
		}
		tvNumbers.setText(textNumbers);
		
		
		
		
		btNextChosen.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent = new Intent(ChosenActivity.this,ResultActivity.class);
				intent.putExtra("size", size);
				intent.putExtra("algorithm", algorithm);
				intent.putExtra("numbers", numbers);
				startActivity(intent);
			}
		});
		
	}

}
