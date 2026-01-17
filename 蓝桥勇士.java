import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		// v数组用于存放对手战力值
		long[] v = new long[n];
		// path数组存放以第i人作为最后一个对手时
		// 能挑战的最多的人数数量
		int[] path = new int[n];
		for (int i = 0; i < n; i++) {
			// 输入对手战力值
			v[i] = input.nextLong();
			// 初始化v数组每一项为1，即仅挑战自己
			path[i] = 1;
		}
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if(v[j] > v[i]) {
					// 如果当前敌人j战力大于i敌人，则可以让上一个战斗的敌人为i敌人
					a[i][j] = 1 + path[i];
				}else {
					// 如果上一个敌人是i敌人，但是j敌人战力太小，只能为1
					a[i][j] = 1;
				}
				// 更新path中的最新数据
				path[i] = arrMax(a,i);
			}
		}
		System.out.println(arrMax(path));
		input.close();
	}
	
	// 寻找二维数组中指定列的最大元素并返回
	static int arrMax(int[][]a,int index) {
		int max = a[0][index];
		for(int i = 0;i<a.length;i++) {
			if(a[i][index] > max) {
				max = a[i][index];
			}
		}
		return max;
	}
	
	// 寻找一维数组中的最大元素并返回
	static int arrMax(int[] a) {
		int max = a[0];
		for(int i : a) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
}
