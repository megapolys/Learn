package org.example.algoritm.sort;

/**
 * Сортировка слиянием. Сложность O(n log n).
 */
public class MergeSort implements Sort {

	@Override
	public int[] sort(int[] array) {
		int[][] oldArrays = new int[array.length][];
		for (int i = 0; i < array.length; i++) {
			oldArrays[i] = new int[]{array[i]};
		}

		int[][] newArrays = new int[oldArrays.length / 2][];
		while (oldArrays.length > 1) {
			for (int i = 0; i < oldArrays.length / 2; i++) {
				newArrays[i] = merge(oldArrays[i * 2], oldArrays[i * 2 + 1]);
			}
			if (oldArrays.length % 2 == 1) {
				newArrays[0] = merge(newArrays[0], oldArrays[oldArrays.length - 1]);
			}
			oldArrays = newArrays;
			newArrays = new int[oldArrays.length / 2][];
		}
		return oldArrays[0];
	}

	private int[] merge(int[] array1, int[] array2) {
		int[] resultArray = new int[array1.length + array2.length];
		int index1 = 0;
		int index2 = 0;
		for (int i = 0; i < array1.length + array2.length; i++) {
			if (index1 < array1.length && index2 < array2.length) {
				if (array1[index1] <= array2[index2]) {
					resultArray[i] = array1[index1++];
				} else {
					resultArray[i] = array2[index2++];
				}
			} else {
				if (index1 < array1.length) {
					resultArray[i] = array1[index1++];
				} else {
					resultArray[i] = array2[index2++];
				}
			}
		}
		return resultArray;
	}
}
