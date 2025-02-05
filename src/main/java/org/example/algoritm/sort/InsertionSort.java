package org.example.algoritm.sort;

/**
 * Сортировка вставками. Сложность O(n^2). Память O(n) или O(1) если извернуться ;).
 */
public class InsertionSort implements Sort {

	@Override
	public int[] sort(int[] array) {
		int len = array.length;
		if (len <= 1) {
			return array;
		}
		for (int resultLen = 0; resultLen < len; resultLen++) {
			int el = array[resultLen];
			for (int i = resultLen - 1; i >= 0; i--) {
				if (el >= array[i]) {
					array[i + 1] = el;
					break;
				} else {
					array[i + 1] = array[i];
					array[i] = el;
				}
			}
		}
		return array;
	}
}
