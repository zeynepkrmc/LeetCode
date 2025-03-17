def levenshtein_distance(str1, str2):
    # Initialize a matrix with dimensions (len(str1)+1) x (len(str2)+1)
    rows = len(str1) + 1
    cols = len(str2) + 1
    dp = [[0 for _ in range(cols)] for _ in range(rows)]

    # Fill the base cases
    for i in range(rows):
        dp[i][0] = i  # Cost of deleting all characters in str1
    for j in range(cols):
        dp[0][j] = j  # Cost of inserting all characters in str2

    # Populate the matrix
    for i in range(1, rows):
        for j in range(1, cols):
            if str1[i - 1] == str2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1]  # Characters are the same, no cost
            else:
                dp[i][j] = min(
                    dp[i - 1][j],    # Deletion
                    dp[i][j - 1],    # Insertion
                    dp[i - 1][j - 1] # Substitution
                ) + 1

    # The bottom-right cell contains the Levenshtein Distance
    return dp[-1][-1]

# Example usage
str1 = "kitten"
str2 = "sitting"
print(f"The Levenshtein distance between '{str1}' and '{str2}' is {levenshtein_distance(str1, str2)}.")
