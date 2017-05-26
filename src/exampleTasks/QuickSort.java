package exampleTasks;

import java.io.Serializable;

import compute.Task;

public class QuickSort implements Task<String[]>, Serializable{

	private static final long serialVersionUID = 1L;
	private String[] lines;
	private int low;
	private int high;
	
	public QuickSort(String[] lines, int low, int high){
		this.lines = lines;
		this.low = low;
		this.high = high;
	}

	@Override
	public String[] execute() {
		quicksort(lines, low, high);
		return lines;
	}
	
	public void quicksort(String []lines, int low, int high){
		if(low < high){
			int p = partition(lines, low, high);
			quicksort(lines, low, p);
			quicksort(lines, p+1, high);
		}
	}
	
	int partition(String[] lines, int low, int high){
		String pivot = lines[low];
		String temp;
		int i = low - 1;
		int j = high + 1;
		while(true){
			do{
				i = i + 1;
			}while(lines[i].compareTo(pivot) < 0);
			do{
				j = j - 1;
			}while(lines[j].compareTo(pivot) > 0);
			
			if(i >= j){
				return j;
			}
			temp = lines[i];
			lines[i] = lines[j];
			lines[j] = temp;
		}
	}

}
