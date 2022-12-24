def solution(x):
    sum = 0
    origin = x
    while x / 10 > 0:
        sum += x % 10
        x //= 10

    if origin % sum == 0:
        return True
    else:
        return False