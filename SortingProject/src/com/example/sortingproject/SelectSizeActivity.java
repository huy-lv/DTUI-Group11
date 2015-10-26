package com.example.sortingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SelectSizeActivity extends AppCompatActivity {

	Button btSelectSize;
	EditText etSize;
	int algorithm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_size);
		Intent intent = getIntent();
		algorithm = intent.getIntExtra("algorithm", 0);  
		
		btSelectSize = (Button)findViewById(R.id.btSelectSize);
		etSize = (EditText)findViewById(R.id.etSize);
		
		
		btSelectSize.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(SelectSizeActivity.this,ChosenActivity.class);
				i.putExtra("size", Integer.parseInt(etSize.getText().toString()));
				i.putExtra("algorithm", algorithm);
				startActivity(i);
			}
		});
	}
}
