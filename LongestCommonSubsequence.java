public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // 2D array to store the lengths of longest common subsequences
        int[][] dp = new int[m + 1][n + 1];
        // Iterate through both strings in reverse order
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    // If characters match, increment the length of the common subsequence by 1
                    if (text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    } else {
                        // If characters don't match, take the maximum length of common subsequences
                        dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                }
            }

            // Return the length of the longest common subsequence between the entire strings
            return dp[0][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("The length of the longest common subsequence is: " + solution.longestCommonSubsequence(text1, text2));
    }
}