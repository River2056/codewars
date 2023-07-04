import sys
import argparse


def snake_case_to_camel_case(name):
    arr = name.split("_")
    return arr[0] + "".join(e.title() for e in arr[1:])


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("-n", "--name", help="file name and main function name")
    args = parser.parse_args()

    if not args or not args.name:
        print("please provide a file name!")
        sys.exit(1)

    with open(f"./{args.name}.py", "wt", encoding="utf-8") as output:
        content = f"""
import unittest


def {args.name}():
    pass


class Test{snake_case_to_camel_case(args.name).title()}(unittest.TestCase):
    def setUp(self):
        self.tests = []

    def test_{args.name}(self):
        for input, expected in self.tests:
            with self.subTest(input=input, expected=expected):
                result = {args.name}()
                self.assertEqual(result, expected)


if __name__ == "__main__":
    unittest.main()
        """
        output.write(content)



if __name__ == "__main__":
    main()
