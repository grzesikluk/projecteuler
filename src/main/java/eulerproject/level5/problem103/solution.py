import itertools
import logging
import time

logging.basicConfig(level=logging.INFO, format='%(relativeCreated)6d %(threadName)s %(message)s')


def get_subsets(input_set, n):
    return set(itertools.combinations(input_set, n))


def get_middle_elements(input_set):
    l = len(input_set)
    if (l % 2 == 1):
        return [input_set[int(l / 2)]]
    else:
        return input_set[int(l / 2) - 1: int(l / 2) + 1]


def get_subset_list_from_previous_optimal_list(input_list):
    n = len(input_list)
    result = []

    # now generate sets (b, b+a1, b+a2, b+a3 ..., b+an)
    for middle in get_middle_elements(input_list):
        result.append(tuple([middle] + _add_val_to_list(middle, input_list)))

    return result


def get_product_list_from_range(input_list, r=0):
    converted_input_list = []
    for element in input_list:
        range1 = filter(lambda x: x > 0, range(element - r, element + r + 1))
        converted_input_list.append(list(range1))
    return list(itertools.product(*converted_input_list))


def remove_non_unique_lists(input_list):
    return list(filter(lambda x: len(x) == len(set(x)), input_list))


def remove_duplicated_tuples(input_list):
    tuple_set = set([])
    for t in input_list:
        tuple_set.add(tuple(sorted(list(t))))

    return list(tuple_set)


def _add_val_to_list(k, input_list):
    return [x + k for x in input_list]


def is_maybe_optional(input):
    # generate subsets of n size
    logging.debug("is optimal %s", input)
    subsets = [[]] * (len(input))

    for i in range(0, len(input)):
        sets = get_subsets(input, i + 1)
        for s in sets:
            subsets[i] = [set(item) for item in sets]

    # check if all lenghts are different
    flat_subset_sums = [sum(item) for set in subsets for item in set]
    if len(flat_subset_sums) != len(set(flat_subset_sums)):
        return False

    max_sums = [get_max_sum(subset) for subset in subsets]
    min_sums = [get_min_sum(subset) for subset in subsets]
    for i in range(0, len(max_sums) - 1):
        if max_sums[i] >= min_sums[i + 1]:
            return False

    return True

def get_optimal_set(initial_set, start=1):
    results = {}
    logging.debug("Got get_optimal_set size = %d ", len(initial_set))

    for input_set in initial_set:
        if is_maybe_optional(input_set):
            results[sum(input_set)] = input_set

    minimum_s = min(results.keys())
    return tuple(sorted(results[minimum_s])), minimum_s


def get_optimal(n):
    if n == 1:
        return (1), 1
    if n == 2:
        return (1, 2), 3
    if n > 2:
        input_set = get_subset_list_from_previous_optimal_list(get_optimal(n - 1)[0])
        product = []
        for set in input_set:
            product.extend(get_product_list_from_range(set, 3))
        unique_product = remove_non_unique_lists(product)
        input_list = remove_duplicated_tuples(unique_product)
        return get_optimal_set(input_list)


def get_max_sum(input):
    return max([sum(set1) for set1 in input])


def get_min_sum(input):
    return min([sum(set1) for set1 in input])


def _start():
    return time.time_ns()


def _stop(start):
    return (time.time_ns() - start) / (1e9)


if __name__ == '__main__':
    start = _start()
    print(get_optimal(7))
    print(_stop(start))
