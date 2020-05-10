from unittest import TestCase

from eulerproject.level5.problem103.solution import get_subsets, is_maybe_optional, get_optimal, \
    get_subset_list_from_previous_optimal_list, get_product_list_from_range, get_optimal, \
    remove_non_unique_lists


class Test(TestCase):
    def test_get_subsets(self):
        self.assertEqual(get_subsets(set([1, 2, 3, 4, 5]), 3),
                         {(2, 3, 5), (1, 2, 3), (1, 3, 5), (1, 4, 5),
                          (1, 2, 4), (1, 3, 4), (2, 4, 5), (3, 4, 5),
                          (2, 3, 4), (1, 2, 5)})

    def test_is_optimal(self):
        self.assertTrue(is_maybe_optional(set([1, 2])))
        self.assertTrue(is_maybe_optional(set([2, 3, 4])))
        self.assertTrue(is_maybe_optional(set([3, 5, 6, 7])))
        self.assertTrue(is_maybe_optional(set([6, 9, 11, 12, 13])))
        self.assertTrue(is_maybe_optional(set([11, 18, 19, 20, 22, 25])))
        self.assertTrue(is_maybe_optional(set([11, 17, 20, 22, 23, 24])))

    def test_is_not_optimal(self):
        self.assertFalse(is_maybe_optional(set([2, 3, 7])))
        self.assertFalse(is_maybe_optional(set([11, 18, 19, 20, 22, 26])))

    def test_get_optimal(self):
        self.assertEqual(((1, 2), 3), get_optimal(2))
        self.assertEqual(((2, 3, 4), 9), get_optimal(3))
        self.assertEqual(((3, 5, 6, 7), 21), get_optimal(4))
        self.assertEqual(((6, 9, 11, 12, 13), 51), get_optimal(5))
        self.assertEqual(((11, 18, 19, 20, 22, 25), 115), get_optimal(6))

    def test_get_subset_list_from_previous_optimal_list(self):
        self.assertEqual([(3, 5, 6, 7)],
                         get_subset_list_from_previous_optimal_list([2, 3, 4]))
        self.assertEqual([(5, 8, 10, 11, 12), (6, 9, 11, 12, 13)],
                         get_subset_list_from_previous_optimal_list([3, 5, 6, 7]))

    def test_get_product_list_from_range(self):
        l1 = get_product_list_from_range([2, 4, 6])
        self.assertIn((2, 4, 6), l1)

        l2 = get_product_list_from_range([2, 4, 6], 1)

        self.assertIn((2, 4, 6), l2)
        self.assertIn((3, 5, 7), l2)
        self.assertIn((1, 4, 6), l2)
        self.assertIn((2, 3, 6), l2)
        self.assertIn((2, 4, 5), l2)
        self.assertIn((1, 3, 5), l2)
        # out of range
        self.assertNotIn((2, 4, 8), l2)
        self.assertNotIn((0, 4, 6), l2)

    def test_get_product_list_from_range_negative(self):
        l1 = get_product_list_from_range([1, 2], 3)
        self.assertIn((1, 2), l1)
        self.assertIn((1, 3), l1)
        self.assertIn((1, 4), l1)
        self.assertIn((1, 5), l1)

        self.assertNotIn((0, 2), l1)
        self.assertNotIn((0, 1), l1)
        # self.assertNotIn((2, 2), l1)
        self.assertNotIn((-1, 2), l1)

    def test_remove_non_unique_lists(self):
        self.assertIn((1, 2, 3), remove_non_unique_lists([(1, 2, 3), (1, 2, 2), (1, 3, 3)]))
