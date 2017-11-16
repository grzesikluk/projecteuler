import math
import sys


class Solution():
    def __init__(self, k):
        self.k = k

    def solve(self):
        return sum(set(self.mps()))

    def product(self, array=[]):
        result = 1
        for i in array:
            result *= i
        return result

    def sum(self, array=[]):
        result = 0
        for i in array:
            result += i
        return result

    def getN(self, array):
        return self.product(array) - self.sum(array)

    def getMaxFactor(self, k):
        return int(math.log(k, 2) + 1)

    def mps(self):
        result = []
        max_value = 2 * self.k
        max_factor = self.getMaxFactor(max_value)

        for i in range(self.k + 1):
            result.append(sys.maxint)

        factors = self.getAllFactors(max_value)

        for i in range(2, max_factor):

            for factor in self.getByLength(factors, i):

                mps = self.product(factor)
                n = self.getN(factor)
                k = n + len(factor)

                if k >= len(result):
                    pass
                else:
                    if result[k] > mps:
                        result[k] = mps

        for i in range(0, len(result)):
            if result[i] == sys.maxint:
                result[i] = 0

        return result

    def allFactors(self, max, min_divisor=2):
        """Implemenation that should generate it more efficiently"""
        if max == 1:
            yield []
        for divisor in range(min_divisor, max + 1):
            if max % divisor == 0:
                for product in self.allFactors(max // divisor, divisor):
                    yield product + [divisor]

    def getAllFactors(self, max):
        result = []

        for k in range(2, max + 1):
            result.extend(list(self.allFactors(k)))

        return result

    def getByLength(self, input, length):
        return [i for i in input if len(i) == length]


if __name__ == "__main__":
    s = Solution(12000)
    print s.solve()
