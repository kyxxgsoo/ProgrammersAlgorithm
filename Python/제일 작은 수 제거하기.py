def solution(arr):
    answer = []
    arr.remove(min(arr))
    if not arr:
        return [-1]
    else:
        return arr