from eulerproject.pyeuler.sets import is_special_sum_set


def solve(filename):
    result = 0
    for s in read_sets_from_file(filename):
        if is_special_sum_set(s):
            result += sum(s)

    return result


def read_sets_from_file(filename):
    result = []

    with open(filename) as fh:
        line = fh.readline();

        while (line):
            result.append(set([int(x) for x in line.replace("\n", "").split(",")]))
            line = fh.readline()

    return result


if __name__ == '__main__':
    print(solve("./sets.txt"))
