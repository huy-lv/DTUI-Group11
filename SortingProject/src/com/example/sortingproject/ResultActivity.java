package com.example.sortingproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
	
	TextView tvAlgorithm;
	TextView tvDesc;
	StringBuffer text;
	int size;
	int[] listNumber;
	int algorithm;
	
	int[] numbers;
	int number;
	int step;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		tvAlgorithm = (TextView)findViewById(R.id.tvAlgorithm);
		tvDesc = (TextView)findViewById(R.id.tvDesc);
		Intent intent = getIntent();
		size = intent.getIntExtra("size", 0);
		listNumber = intent.getIntArrayExtra("numbers");
		algorithm = intent.getIntExtra("algorithm", 0);
		text = new StringBuffer();
		step =1;
		
		switch (algorithm) {
		case 1:
			
			quicksort(listNumber);
			tvDesc.setText(text);
			break;
		case 2:
			
			doSelectionSort(listNumber);
			tvDesc.setText(text);
			break;
		case 3:
			
			break;
			
		default:
			break;
		}
	}
	
	private void doSelectionSort(int[] arr){
        
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
      
            int smallerNumber = arr[index]; 
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            
            text.append("Step "+step+":\n");
            step+=1;
			for(int b:arr){
				text.append(b+ " ");
			}
			text.append("\n");
//            for(int b:arr){
//            	System.out.print(b+" ");
//            }
//            System.out.println("");
        }
    }
	
	public void quicksort(int[] values) {
		// check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		this.numbers = values;
		number = values.length;

		xquicksort(0, number - 1);
	}

	private void xquicksort(int low, int high) {
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
				exchange(i, j);
				i++;
				j--;
			}
		}
		if (low < j)
			xquicksort(low, j);
		if (i < high)
			xquicksort(i, high);
	}

	private void exchange(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
