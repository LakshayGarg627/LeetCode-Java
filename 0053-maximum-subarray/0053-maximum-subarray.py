class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        countNeg=0
        for x in nums:
            if(x<0):
                countNeg=countNeg+1
        
        if(countNeg==n):
            return max(nums)
        else:
            currSum=0
            maxSum=0
            for x in nums:
                currSum=currSum+x
                if(currSum<0):
                    currSum=0
                maxSum=max(maxSum,currSum)
            return maxSum



        