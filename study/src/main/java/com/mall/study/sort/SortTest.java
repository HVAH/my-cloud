package com.mall.study.sort;

import java.util.Arrays;

/**
 * @description: 常见排序
 * @author: huangjiang  2018年6月11日 下午6:14:35
 */
public class SortTest {
	
	public static void main(String[] args) {
		/*int[] arr = {44,12,3,5,2,7,22,86,9,11};
		selectSort(arr);
		System.out.println("=============================");
		int[] arr2 = {44,12,3,5,2,7,22,86,9,11};
		maopaoSort(arr2);*/
		int[] arr3 = {44,12,3,5,2,7,22,86,9,11};
		quicklySort(0, arr3.length - 1, arr3);
		System.out.println(halfSearch(arr3, -10, arr3.length / 2));
		System.out.println(halfSearch(arr3, 2, arr3.length / 2));
		System.out.println(halfSearch(arr3, 8, arr3.length / 2));
		System.out.println(halfSearch(arr3, 22, arr3.length / 2));
		System.out.println(halfSearch(arr3, 86, arr3.length / 2));
		System.out.println(halfSearch(arr3, 100, arr3.length / 2));
		System.out.println("=============================");
		System.out.println(halfSearch(arr3, -10));
		System.out.println(halfSearch(arr3, 2));
		System.out.println(halfSearch(arr3, 8));
		System.out.println(halfSearch(arr3, 22));
		System.out.println(halfSearch(arr3, 86));
		System.out.println(halfSearch(arr3, 100));
	}
	
	/**
	 * @description: 选择排序 每一次外循环完成,最小的往前排
	 * @author: huangjiang  2018年6月11日 下午6:30:57
	 *
	 * @param arr
	 * @return
	 */
	public static int [] selectSort(int [] arrSource) {
		int count = 0;
		for (int i = 0; i < arrSource.length - 1; i++) {
			for (int j = i + 1; j < arrSource.length; j++) {
				if (arrSource[j] < arrSource[i]) {
					int temp = arrSource[i];
					arrSource[i] = arrSource[j];
					arrSource[j] = temp;
					count ++;
				}
			}
			System.out.println("第" + (i + 1) + "次外循环完成,结果: " + Arrays.toString(arrSource));
		}
		System.out.println("共进行了 " + count + " 次排序");
		return arrSource;
	}
	
	/**
	 * @description: 冒泡排序  每次内循环,小的排前面,大的排后面
	 * @author: huangjiang  2018年6月11日 下午6:30:57
	 *
	 * @param
	 * @return
	 */
	public static int [] maopaoSort (int [] arrSource) {
		int count = 0;
		for (int i = 0; i < arrSource.length - 1; i++) {
			for (int j = 0; j < arrSource.length - 1; j++) {
				if (arrSource[j] > arrSource[j + 1]) {
					int temp = arrSource[j + 1];
					arrSource[j + 1] = arrSource[j];
					arrSource[j] = temp;
					count ++;
				}
			}
			System.out.println("第" + (i + 1) + "次外循环完成,结果: " + Arrays.toString(arrSource));
		}
		System.out.println("共进行了 " + count + " 次排序");
		return arrSource;
	}
	
	
	/**
	 * @description: 快速排序
	 *               设置两个指针：i和j，分别指向第一个和最后一个，i像后移动，j向前移动，
	 *               选第一个数为标准（一般这样做，当然快排的关键就是这个“标准”的选取），
	 *               从后面开始，找到第一个比标准小的数，互换位置，然后再从前面，找到第一个比标准大的数，
	 *               互换位置，第一趟的结果就是标准左边的都小于标准，右边的都大于标准（但不一定有序），
	 *               分成两拨后，继续递归的使用上述方法，最终有序
	 * @author: huangjiang 2018年6月11日 下午6:30:57
	 *
	 * @param
	 * @return
	 */
	public static int[] quicklySort(int left, int right, int[] arrSource) {
		if (left < right) {
			int result = quicklySort(arrSource, left, right);
			quicklySort(left, result - 1, arrSource);
			quicklySort(result + 1, right, arrSource);
		}
		return arrSource;
	}


	public static int quicklySort(int[] arrSource, int left, int right) {
		int key = arrSource[left];
		while (left < right) {
			// 高位索引向前移,直到其值小于key值
			while (left < right && arrSource[right] >= key) {
				right--;
			}
			// 将第一个比key值小的值赋给低位索引
			arrSource[left] = arrSource[right];
			// 低位索引向后移动,直到其值大于key值
			while (left < right && arrSource[left] <= key) {
				left++;
			}
			// 将第一个比key值大的值赋值给高位索引
			arrSource[right] = arrSource[left];
		}
		arrSource[left] = key;
		return left;
	}
	
	/**
	 * @description:  二分查找  适用于有序的列表查找 
	 * 				    递归实现
	 * @author: huangjiang  2018年6月12日 上午11:19:08
	 *
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int halfSearch(int[] arr, int value, int middleIndex) {
		if (value < arr[0] || value > arr[arr.length - 1]) {
			return -1;
		}else if (value > arr[middleIndex] && value < arr[middleIndex + 1]) {
			return -1;
		}
		if (middleIndex >= 0 && middleIndex < arr.length) {
			if (value < arr[middleIndex]) {
				middleIndex = middleIndex / 2;
			} else if (value > arr[middleIndex]) {
				middleIndex = (middleIndex + arr.length) / 2;
			} else if (value == arr[middleIndex]) {
				return middleIndex;
			} 
			return halfSearch(arr, value, middleIndex);
		}
		return -1;
	}
	/**
	 * @description: 二分查找,循环实现 
	 * @author: huangjiang  2018年6月12日 下午1:51:39
	 *
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int halfSearch(int [] arr, int value) {
		// 高位索引
		int high = arr.length - 1;
		// 低位索引
		int low = 0;
		if (value < arr[0] || value > arr[arr.length - 1]) {
			return -1;
		}
		while (low <= high) {
			// 对半索引
			int middleIndex = (high + low) / 2;
			// 要找的值在左边
			if (value < arr[middleIndex]) {
				high = middleIndex - 1;
			// 要找的值在右边
			} else if (value > arr[middleIndex]) {
				low = middleIndex + 1;
			} else {
				return middleIndex;
			}
		}
		return -1;
	}
}
