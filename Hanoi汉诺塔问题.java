import java.util.*;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		Stack<Integer> a = new Stack<Integer>();
		Stack<Integer> b = new Stack<Integer>();
		Stack<Integer> c = new Stack<Integer>();
		for (int i = n; i >= 1; i--) {
			a.add(i);
		}

		hanoi(n, a, b, c, 1, 2, 3);
		input.close();
	}

	static void hanoi(int n, Stack<Integer> from, Stack<Integer> temp, Stack<Integer> target, int fromId, int tempId,
			int targetId) {
		// 当只需要移动一个盘子时
		if (n == 1) {
			int t = from.pop();
			target.add(t);
			// 输出移动路径
			System.out.println("move " + t + " from " + fromId + " to " + targetId + ".");
			return;
		}

		// 将除去from最低下一个盘子的其他n-1个盘子进行移动
		hanoi(n - 1, from, target, temp, fromId, targetId, tempId);

		// 那n-1个盘子已经就位，现在手动处理最大的盘子
		int t = from.pop();
		target.push(t);
		System.out.println("move " + t + " from " + fromId + " to " + targetId + ".");

		// 将剩下的n-1个盘子继续进行递归处理
		hanoi(n - 1, temp, from, target, tempId, fromId, targetId);
	}
}
