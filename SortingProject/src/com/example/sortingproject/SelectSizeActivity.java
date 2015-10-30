package com.example.sortingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SelectSizeActivity extends AppCompatActivity {

	Button btSelectSize;
	EditText etSize;
	int algorithm;
	TextView tvAlgorithmName;
	Toolbar actionbar; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_size);
		Intent intent = getIntent();
		algorithm = intent.getIntExtra("algorithm", 0);  
		
		actionbar = (Toolbar)findViewById(R.id.toolBar);
		setSupportActionBar(actionbar);
		
		tvAlgorithmName = (TextView)findViewById(R.id.tvAlgorithmName);
		btSelectSize = (Button)findViewById(R.id.btSelectSize);
		etSize = (EditText)findViewById(R.id.etSize);
		
		switch (algorithm) {
		case 1:
			tvAlgorithmName.setText("QUICK SORT");
			break;
		case 2:
			tvAlgorithmName.setText("SELECTION SORT");
			break;
		case 3:
			tvAlgorithmName.setText("INSERTION SORT");
			break;
		default:
			break;
		}
		
		btSelectSize.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int size = Integer.parseInt(etSize.getText().toString());
				if(size <= 10 && size >0){
					Intent i = new Intent(SelectSizeActivity.this,ChosenActivity.class);
					i.putExtra("size", size);
					i.putExtra("algorithm", algorithm);
					startActivity(i);
				}else{
					Toast.makeText(getApplicationContext(), "Out of range value!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
