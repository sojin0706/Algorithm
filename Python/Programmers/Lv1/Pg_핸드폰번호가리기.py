def solution(phone_number):
    num = len(phone_number)
    str = ""
    str += (num-4)*"*"
    str += phone_number[-4:]

    return str
