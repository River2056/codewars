import unittest


def sum_of_intervals(intervals):
    intervals.sort(key=lambda x: x[0])
    unique_intervals = []
    for interval in intervals:
        if len(unique_intervals) == 0:
            unique_intervals.append(list(interval))
        else:
            prev = unique_intervals[-1]
            if prev[1] > interval[0]:
                prev[1] = max(interval[1], prev[1])
            else:
                unique_intervals.append(list(interval))

    return sum(list(map(lambda x: x[1] - x[0], unique_intervals)))


class TestSumOfIntervals(unittest.TestCase):
    def setUp(self):
        self.tests = [
            ([(1, 5)], 4),
            ([(1, 5), (6, 10)], 8),
            ([(1, 5), (1, 5)], 4),
            ([(1, 4), (7, 10), (3, 5)], 7),
        ]

    def test_sum_of_intervals(self):
        for input, expected in self.tests:
            with self.subTest(input=input, expected=expected):
                result = sum_of_intervals(input)
                self.assertEqual(result, expected)


if __name__ == "__main__":
    # unittest.main()
    print(sum_of_intervals([(1, 5), (1, 5)]))
