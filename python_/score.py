import unittest


def score(dice):
    mapping = {
        "1": 100,
        "5": 50,
        "111": 1000,
        "666": 600,
        "555": 500,
        "444": 400,
        "333": 300,
        "222": 200
    }
    freq = {}
    for d in dice:
        if d not in freq:
            freq[d] = 1
        else:
            freq[d] += 1

    total = 0
    for k, v in freq.items():
        while v >= 3:
            key = str(k) * 3
            if key in mapping:
                total += mapping[key]
                v -= 3
        for _ in range(v):
            if str(k) in mapping:
                total += mapping[str(k)]

    return total


class TestScore(unittest.TestCase):
    def setUp(self):
        self.tests = [
            ([5, 1, 3, 4, 1], 250),
            ([1, 1, 1, 3, 1], 1100),
            ([2, 3, 4, 6, 2], 0),
            ([4, 4, 4, 3, 3], 400),
            ([2, 4, 4, 5, 4], 450),
        ]

    def test_score(self):
        for input, expected in self.tests:
            with self.subTest(input=input, expected=expected):
                result = score(input)
                self.assertEqual(result, expected)


def main():
    print(score([5, 1, 3, 4, 1]))

if __name__ == "__main__":
    unittest.main()
    # main()
