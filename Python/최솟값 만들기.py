def solution(A, B):
    answer = 0
    sum = 0
    A.sort()
    B.sort(reverse=True)

    for i in range(len(A)):
        sum += A[i] * B[i]

    answer = sum
    return answer