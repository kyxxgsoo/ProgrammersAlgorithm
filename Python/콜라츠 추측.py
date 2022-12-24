def solution(num):
    answer = 0
    count = 0
    while num != 1:
        if count >= 500:
            answer = -1
            break
        count += 1
        if num % 2 == 0:
            num /= 2
        else:
            num = num * 3 + 1
        answer = count
    return answer