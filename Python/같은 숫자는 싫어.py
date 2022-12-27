def solution(arr):
    answer = [arr[0]]
    index = 0
    for i in range(len(arr)):
        if arr[i] != answer[-1]:
            answer.append(arr[i])
    return answer