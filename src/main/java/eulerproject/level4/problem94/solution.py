class Solution():
    max = int(1e+9)

    @classmethod
    def is_int(cls, a):
        return a == int(a)

    @classmethod
    def isSquare(cls, k):

        if Solution.is_int(k):
            x = k // 2
            seen = set([x])
            while x * x != k:
                x = (x + (k // x)) // 2
                if x in seen: return False
                seen.add(x)
            return True
        else:
            return False

    def solve(self):
        solution = []
        gen = Generator_A120893()
        i = gen.next()

        while 3 * i < int(self.max):
            t1 = Triangle(i, i, i - 1)
            t2 = Triangle(i, i, i + 1)
            area1 = t1.getArraySqrt()
            area2 = t2.getArraySqrt()
            if (Solution.isSquare(area1)):
                solution.append(3 * i - 1)
                print t1
            if (Solution.isSquare(area2)):
                solution.append(3 * i + 1)
                print t2
            i = gen.next()

        print sum(solution)


class Triangle():
    def __init__(self, a, b, c):
        self.a, self.b, self.c = a, b, c

    def getPerimeter(self):
        return self.a + self.b + self.c

    def getArraySqrt(self):
        s = self.getPerimeter() / 2.0
        return s * (s - self.a) * (s - self.b) * (s - self.c)

    def __str__(self):
        return "a={} b={} c={}".format(self.a, self.b, self.c)


class Generator_A120893:
    def __init__(self):
        self.a_0 = 1
        self.a_1 = 1
        self.n = 2

    def __iter__(self):
        return self

    def __next__(self):
        return self.next()

    def next(self):
        # a(n)=2*{2*a(n-1) + (-1)^n} - a(n-2) ; a(0)=1,a(1)=1.
        a_n = 2 * (2 * self.a_0 + self.__powminusone(self.n)) - self.a_1

        self.a_1 = self.a_0
        self.a_0 = a_n
        self.n += 1

        return a_n

    def __powminusone(self, n):
        if (n % 2) == 0:
            return 1
        else:
            return -1


if __name__ == "__main__":
    Solution().solve()
