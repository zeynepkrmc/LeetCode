// You are given an array `prices` where `prices[i]` is the price of a given stock on the `ith` day, and an integer `fee` representing a transaction fee.

// Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

// **Note:**

// - You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
// - The transaction fee is only charged once for each stock purchase and sale.

class ClimbingStairsMemoization {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo){
        if (n==0 || n==1){
            return 1;
        }
        if (!memo.containsKey(n)){
            memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
        }
        return memo.get(n);
    }
}