package com.example.sortingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener{

	Button btQuickSort,btSelectionSort,btInsertionSort;
	Toolbar toolbar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        
		btQuickSort = (Button)findViewById(R.id.btQuickSort);
		btSelectionSort = (Button)findViewById(R.id.btSelectionSort);
		btInsertionSort = (Button)findViewById(R.id.btInsertionSort);
		
		btQuickSort.setOnClickListener(this);
		btSelectionSort.setOnClickListener(this);
		btInsertionSort.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		Intent i;
		i = new Intent(this,SelectSizeActivity.class);
		switch (v.getId()) {
		case R.id.btQuickSort:
			i.putExtra("algorithm", 1);
			break;
		case R.id.btSelectionSort:
			i.putExtra("algorithm", 2);
			break;
		case R.id.btInsertionSort:
			i.putExtra("algorithm", 3);
			break;
		default:
			break;
		}
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	
}
