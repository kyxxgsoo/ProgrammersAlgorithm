def solution(phone_number):
    answer = ''
    return (len(phone_number) - 4) * '*' + str(phone_number[-4:])