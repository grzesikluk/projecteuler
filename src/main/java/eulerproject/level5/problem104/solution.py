def solve():
    pass


def fibonacci():
    a = 1
    b = 1
    counter = 1

    while True:
        if counter == 1:
            yield counter, 1
        elif counter == 2:
            yield counter, 1
        else:
            c = a + b
            a = b
            b = c
            yield counter, c

        counter = counter + 1


def fibonacciModulo(modulo=1000000000):
    a = 1
    b = 1
    counter = 1

    while True:
        if counter == 1:
            yield counter, 1
        elif counter == 2:
            yield counter, 1
        else:
            c = (a + b) % modulo
            a = b
            b = c
            yield counter, c

        counter = counter + 1


def fibonacciSqrt(n):
    if n <= 0:
        return 0
    i = n - 1
    a, b = 1, 0
    c, d = 0, 1
    while i > 0:
        if i % 2 == 1:
            a, b = d * b + c * a, d * (b + a) + c * b
        c, d = c ** 2 + d ** 2, d * (2 * c + d)
        i = i / 2
    return a + b


def getLastDigits(i, d):
    return str(i)[0:d]


def getFirstDigits(i, d):
    return str(i)[-d:]


def isPanDigit(s):
    return "1" in s and "2" in s and "3" in s and "4" in s and "5" in s and \
           "6" in s and "7" in s and "8" in s and "9" in s


if __name__ == "__main__":
    MAX = 100000000
    fib = fibonacciModulo(1000000000)
    k = 0

    while k < MAX:
        k, f = next(fib)
        if isPanDigit(getFirstDigits(f, 9)):

            v = fibonacciSqrt(k)

            if isPanDigit(getLastDigits(v, 9)):
                print "{} {} {}".format(k, v, getLastDigits(v, 9))
                break
