def solution(n):
    answer = 0

    for i in range(1, 1000001):
        if bin(n).count('1') == bin(n + i).count('1'):
            answer = n + i
            break
    return answer