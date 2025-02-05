package org.example.algoritm.sort;

/**
 * Сортировка выбором. Сложность O(n^2). Память O(1).
 */
public class SelectionSort implements Sort {

	@Override
	public int[] sort(int[] array) {
		int len = array.length;
		if (len < 2) {
			return array;
		}
		for (int i = 0; i < len; i++) {
			int minI = i;
			for (int j = i; j < len; j++) {
				if (array[j] < array[minI]) {
					minI = j;
				}
			}
			int el = array[minI];
			array[minI] = array[i];
			array[i] = el;
		}
		return array;
	}
}
