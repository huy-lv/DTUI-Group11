package com.example.sortingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
	
	TextView tvAlgorithmName;
	TextView tvDesc;
	StringBuffer text;
	int size;
	int[] listNumber;
	int algorithm;
	
	int[] numbers;
	int number;
	int step;
	Toolbar actionbar;
	Button btReset;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		actionbar = (Toolbar)findViewById(R.id.toolBar);
		setSupportActionBar(actionbar);
		
		btReset = (Button)findViewById(R.id.btReset);
		tvAlgorithmName = (TextView)findViewById(R.id.tvAlgorithmName);
		tvDesc = (TextView)findViewById(R.id.tvDesc);
		Intent intent = getIntent();
		size = intent.getIntExtra("size", 0);
		listNumber = intent.getIntArrayExtra("numbers");
		algorithm = intent.getIntExtra("algorithm", 0);
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
		text = new StringBuffer();
		step =1;
		
		switch (algorithm) {
		case 1:
			quickSort(listNumber);
			break;
		case 2:
			doSelectionSort(listNumber);
			break;
		case 3:
			insertionSort(listNumber);
			break;
		default:
			break;
		}
		tvDesc.setText(text);
		
		btReset.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i =new Intent(ResultActivity.this,MainActivity.class);
				startActivity(i);
			}
		});
	}
	
	private void doSelectionSort(int[] arr){
        
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
      
            text.append("Step "+step+":\n");
            step+=1;
			for(int b:arr){
				text.append(b+ " ");
			}
			text.append("\n");
			
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            
			text.append("   (swap "+arr[index]+" & "+arr[i]+") \n");

        }
    }
	
	public void quickSort(int[] values) {
		// check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;

		doQuickSort(0, number - 1);
	}

	private void doQuickSort(int low, int high) {
		int i = low, j = high;
		// Get the pivot element from the middle of the list
		int pivot = numbers[low + (high - low) / 2];

		// Divide into two lists
		while (i <= j) {
			while (numbers[i] < pivot) {
				i++;
			}
			while (numbers[j] > pivot) {
				j--;
			}
			if (i <= j) {
//				for (int b : numbers) {
//					System.out.print(b + " ");
//				}
//				System.out.print("\n");
				text.append("Step "+step+":\n");
				step+=1;
				for(int b:numbers){
					text.append(b+ " ");
				}
				text.append("\n");
				text.append("   (swap "+numbers[i]+" & "+numbers[j]+") \n");
				exchange(i, j);
				
				i++;
				j--;
			}
		}
		if (low < j)
			doQuickSort(low, j);
		if (i < high)
			doQuickSort(i, high);
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	
	void insertionSort(int[] input) {
		int temp;
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					text.append("Step "+step+":\n");
					step+=1;
					for(int b:input){
						text.append(b+ " ");
					}
					text.append("\n");
					text.append("   (swap "+input[j]+" & "+input[j-1]+") \n");
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
	}
	
}
