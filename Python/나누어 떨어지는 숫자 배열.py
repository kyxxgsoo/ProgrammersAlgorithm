def solution(arr, divisor):
    answer = []
    return sorted([int(i) for i in arr if i % divisor == 0]) or [-1]