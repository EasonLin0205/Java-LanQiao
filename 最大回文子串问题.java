import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// 输入字符串
		String s = input.next();

		// 记录最长回文子串的下标和长度
		int maxStart = 0;
		int maxLen = 1;

		// dp二维数组记录了i-j区间的回文子串长度 若区间内不是回文，长度为0
		int[][] dp = isSubstring(s);
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				// 如果该子串大于最大子串长度
				if (dp[i][j] != 0 && dp[i][j] > maxLen) {
					maxLen = dp[i][j];
					maxStart = i;
				}
				// System.out.print(dp[i][j] + " ");
			}
			// System.out.println();
		}
		System.out.println(s.substring(maxStart, maxStart + maxLen));
		input.close();
	}

	static int[][] isSubstring(String s) {
		// 将字符串转化为字符型数组方便比较
		char[] value = s.toCharArray();

		int[][] dp = new int[value.length][value.length];

		// 由后到前遍历，防止出现无效访问
		for (int i = value.length - 1; i >= 0; i--) {
			for (int j = i; j < value.length; j++) {
				// 如果第i个字符与第j个字符不相等，说明这个区间内没有回文
				if (value[i] != value[j]) {
					dp[i][j] = 0;
				} else { // 第i和第j个字符相等
					if (j - i <= 2) { // 如果是 aba/bab aaa/bbb aa/bb a/b 这种形式
						dp[i][j] = j - i + 1; // 记录有效回文长度
					} else { // 此时要检查(i+1)-(j-1)区间是否符合回文
						if (dp[i + 1][j - 1] == 0) { // 说明子区间内没有回文
							dp[i][j] = 0;
						} else {
							dp[i][j] = dp[i + 1][j - 1] + 2; // 如果i-j的子串是回文 则i-j也是回文
						}
					}
				}
			}
		}

		return dp;
	}
}
