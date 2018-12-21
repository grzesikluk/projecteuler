import math


def getU(n):
    return n**0 + n**2 + n**4 + n**6 + n**8 + n**10 - n**1 - n**3 - n**5 - n**7 - n**9


def getUPoints(n_max):
    return [point(i, getU(i)) for i in range(0, n_max + 1)]

class point:
    def __init__(self, x=0L, y=0L):
        self.x = x
        self.y = y


def interpolate(data, xi, n):
    """Interpolate with Lagrange formula. Data is an array of points, xi is input value, result returns the value."""
    result = 0
    for i in range(1, n + 1):
        term = data[i].y
        for j in range(1, n + 1):
            if j != i:
                term = term * (xi - data[j].x) / float(data[i].x - data[j].x)
        result += term
    # return int(math.ceil(result))
    return int(round(result))


def getFirstIncorrectTerm(values, n):
    if n < len(values):
        return interpolate(values, n + 1, n)
    else:
        raise AttributeError("Wrong values as input for this function")


def solve(u_points, order):
    sum = 0

    for i in range(1, order + 1):
        FIT = getFirstIncorrectTerm(u_points, i)
        sum += FIT

    return sum


if __name__ == "__main__":
    print("Sum is {}".format(solve(getUPoints(50), 10)))
