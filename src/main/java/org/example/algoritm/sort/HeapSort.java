package org.example.algoritm.sort;

/**
 * Пирамидальная сортировка. Сложность O(n log n).
 */
public class HeapSort implements Sort {

	@Override
	public int[] sort(int[] array) {
		int len = array.length;
		if (len < 2) {
			return array;
		}
		// build heap
		for (int i = len / 2; i >= 0; i--) {
			heapify(array, i, len);
		}
		// sort by extract max node
		for (int i = len - 1; i > 0; i--) {
			swap(array, i, 0);
			heapify(array, 0, i);
		}
		return array;
	}

	private void heapify(int[] array, int index, int len) {
		int leftIndex = index * 2 + 1;
		int rightIndex = index * 2 + 2;
		int largestChildI = index;
		while (true) {
			if (leftIndex < len && array[leftIndex] > array[largestChildI]) {
				largestChildI = leftIndex;
			}
			if (rightIndex < len && array[rightIndex] > array[largestChildI]) {
				largestChildI = rightIndex;
			}
			if (index == largestChildI) {
				break;
			} else {
				swap(array, largestChildI, index);
			}
			index = largestChildI;
			leftIndex = index * 2 + 1;
			rightIndex = index * 2 + 2;
		}
	}

	private void swap(int[] array, int i1, int i2) {
		int el = array[i1];
		array[i1] = array[i2];
		array[i2] = el;
	}
}
