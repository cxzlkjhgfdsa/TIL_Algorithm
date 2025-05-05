# N 마리 중 N/2 마리 소유 가능
# 같은 종류의 폰켓몬은 동일 번호


def solution(nums):
    del_dup = set(nums)
    return len(del_dup) if len(del_dup) <= len(nums)/2 else len(nums)/2