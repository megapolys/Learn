package org.example.algoritm.sort;

import java.util.Arrays;

/**
 * Быстрая сортировка. Сложность O(n log n).
 */
public class QuickSort implements Sort {

	@Override
	public int[] sort(int[] array) {
		System.out.println(Arrays.toString(array));
//		return sort(array, array.length);
		quickSort(array, 0, array.length - 1);
		return array;
	}

	private int[] sort(int[] array, int len) {
		assert len != 0;
		if (len == 1) {
			return new int[]{array[0]};
		}
		int pivot = array[0];
		int lessI = 0;
		int[] lessArray = new int[len];
		int gatherI = 0;
		int[] gatherArray = new int[len];
		for (int i = 1; i < len; i++) {
			if (array[i] <= pivot) {
				lessArray[lessI++] = array[i];
			} else {
				gatherArray[gatherI++] = array[i];
			}
		}
		int[] lessArraySorted;
		int[] gatherArraySorted;
		if (lessI == 0) {
			lessArraySorted = new int[0];
		} else {
			lessArraySorted = sort(lessArray, lessI);
		}
		if (gatherI == 0) {
			gatherArraySorted = new int[0];
		} else {
			gatherArraySorted = sort(gatherArray, gatherI);
		}
		int[] sortArray = new int[lessArraySorted.length + gatherArraySorted.length + 1];
		for (int i = 0; i < sortArray.length; i++) {
			if (i < lessArraySorted.length) {
				sortArray[i] = lessArraySorted[i];
			} else if (i == lessArraySorted.length) {
				sortArray[i] = pivot;
			} else {
				sortArray[i] = gatherArraySorted[i - lessArraySorted.length - 1];
			}
		}
		return sortArray;
	}

	private void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(arr, low, high);
			quickSort(arr, low, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		System.out.printf("pivot = %d, low = %d, high = %d%n", pivot, low, high);
		int left = low + 1;
		int right = high;
		while (true) {
			while (left <= right && arr[left] <= pivot) {
				left++;
			}
			while (right >= left && arr[right] >= pivot) {
				right--;
			}
			if (right < left) {
				break;
			} else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				if (left != right) {
					System.out.println(Arrays.toString(arr));
				}
			}
		}
		int temp = arr[low];
		arr[low] = arr[right];
		arr[right] = temp;
		if (low != right) {
			System.out.println(Arrays.toString(arr));
		}
		return right;
	}
}
