def solution(n, lost, reserve):
 # n:학생수 lost: 도난당한 학생 번호 reserve:여벌 체육복 가져온 학생 번호
 # python set은 remove,add,discard가능
    # 체육복 있는 사람이 도난당한 경우를 위한 조건
    real_lost = set(lost)-set(reserve)
    real_reserve = set(reserve)-set(lost)

    for i in real_reserve:
        if i-1 in real_lost:
            real_lost.remove(i-1)
        elif i+1 in real_lost:
            real_lost.remove(i+1)

    return n-len(real_lost)
