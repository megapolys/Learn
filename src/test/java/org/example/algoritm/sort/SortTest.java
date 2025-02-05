package org.example.algoritm.sort;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

	private final BubbleSort bubbleSort = new BubbleSort();
	private final InsertionSort insertionSort = new InsertionSort();
	private final SelectionSort selectionSort = new SelectionSort();

	private static Stream<Arguments> testSource() {
		return Stream.of(
			Arguments.of((Object) new int[] {1}),
			Arguments.of((Object) new int[] {1, 2}),
			Arguments.of((Object) new int[] {2, 1}),
			Arguments.of((Object) new int[] {1, 1}),
			Arguments.of((Object) new int[] {3, 2, 1}),
			Arguments.of((Object) new int[] {5, 4, 1, 2, 3}),
			Arguments.of((Object) new int[] {5, 4, 2, 2, 3}),
			Arguments.of((Object) new int[] {1, 3, 5, 2, 1}),
			Arguments.of((Object) new int[] {10, 9, 8, 7, 6, 6, 5, 4, 3, 2, 1})
		);
	}

	@ParameterizedTest
	@MethodSource(value = "testSource")
	void bubbleSort(int[] array) {
		int[] expected = Arrays.copyOf(array, array.length);
		Arrays.sort(expected);

		int[] actual = bubbleSort.sort(array);

		assertArrayEquals(expected, actual);
	}

	@ParameterizedTest
	@MethodSource(value = "testSource")
	void insertionSort(int[] array) {
		int[] expected = Arrays.copyOf(array, array.length);
		Arrays.sort(expected);

		int[] actual = insertionSort.sort(array);

		assertArrayEquals(expected, actual);
	}

	@ParameterizedTest
	@MethodSource(value = "testSource")
	void selectionSort(int[] array) {
		int[] expected = Arrays.copyOf(array, array.length);
		Arrays.sort(expected);

		int[] actual = selectionSort.sort(array);

		assertArrayEquals(expected, actual);
	}
}