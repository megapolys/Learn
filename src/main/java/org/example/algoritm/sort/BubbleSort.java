package org.example.algoritm.sort;

/**
 * Сортировка пузырьком. Сложность: O(n^2). Память O(1).
 */
public class BubbleSort implements Sort {

	@Override
	public int[] sort(int[] array) {
		int len = array.length;
		if (len <= 1) {
			return array;
		}
		for (int counter = 0; counter < len - 1; counter++) {
			for (int i = 0; i < len - 1; i++) {
				if (array[i] > array[i + 1]) {
					int el = array[i];
					array[i] = array[i + 1];
					array[i + 1] = el;
				}
			}
		}
		return array;
	}
}
