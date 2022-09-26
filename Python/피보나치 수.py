def solution(n):
    answer = 0

    if n == 2:
        return 1

    i2 = 1
    i1 = 1

    for _ in range(3, n + 1):
        answer = i2 + i1
        i1 = i2
        i2 = answer

    return answer % 1234567