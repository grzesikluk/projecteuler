MAX = 100000
K = 10000


def primeFactors(n):
    result = []
    i = 2
    while i < n ** 2:
        while n % i == 0:
            n = n / i
            result.append(i)
        i = i + 1

    return result


def rad(n):
    primes = set(primeFactors(n))
    r = 1
    for p in primes:
        r *= p
    return r


def solve(k, max=MAX):
    rad_map = {}
    for i in range(1, max + 1):
        rad_map[i] = rad(i)

    s = sorted(rad_map.items(), key=lambda x: x[1], reverse=False)
    return s[k - 1][0]


if __name__ == "__main__":
    print(solve(K))
