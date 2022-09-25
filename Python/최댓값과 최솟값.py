def solution(s):
    answer = ''
    arr = list(map(int, s.split()))
    answer = str(min(arr)) + " " + str(max(arr))
    print("arr : ", arr)
    print("min : ", min(arr))
    print("max : ", max(arr))
    return answer