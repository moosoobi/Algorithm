def solution(nums):
    numDict={}
    for num in nums:
        numDict[hash(num)]=num
    
    return min(len(numDict), len(nums) // 2)