class Solution:
    def maximumCandies(self, A, k):
        l, r = 0, int(1e7)
        while l < r:
            m = (l + r + 1) // 2
            s = sum(p // m for p in A)
            if s < k:
                r = m - 1
            else:
                l = m
        return l