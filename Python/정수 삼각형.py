def solution(triangle):
    dp = [[0] * i for i in range(1, len(triangle) + 1)]

    dp[0][0] = triangle[0][0]
    for i in range(1, len(triangle)):
        for j in range(0, i):
            # left 비교
            left = dp[i - 1][j] + triangle[i][j]
            # right 비교
            right = dp[i - 1][j] + triangle[i][j + 1]
            if dp[i][j] < left:
                dp[i][j] = left
            if dp[i][j + 1] < right:
                dp[i][j + 1] = right

    return max(dp[len(triangle) - 1])