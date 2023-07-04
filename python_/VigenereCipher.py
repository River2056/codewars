import unittest


class VigenereCipher(object):
    def __init__(self, key, alphabet):
        self.key = key
        self.alphabet = alphabet
        self.amount = len(self.alphabet)

    def encode(self, text):
        res = []
        for idx, character in enumerate(text):
            if character in self.alphabet:
                shift = self.alphabet.index(self.key[idx % len(self.key)])
                res.append(self.alphabet[(self.alphabet.index(character) + shift) % self.amount])
            else:
                res.append(character)
        return "".join(res)

    def decode(self, text):
        res = []
        for idx, character in enumerate(text):
            if character in self.alphabet:
                shift = self.alphabet.index(self.key[idx % len(self.key)])
                res.append(self.alphabet[(self.alphabet.index(character) - shift) % self.amount])
            else:
                res.append(character)
        return "".join(res)


class TestVinegereCipher(unittest.TestCase):
    def setUp(self):
        self.alphabet = "abcdefghijklmnopqrstuvwxyz"
        self.key = "password"
        self.newInstance = VigenereCipher(self.key, self.alphabet)

    def test_vigenereCipher(self):
        self.assertEqual(self.newInstance.encode("codewars"), "rovwsoiv")

    def test_2(self):
        self.assertEqual(self.newInstance.decode("rovwsoiv"), "codewars")


def main():
    v = VigenereCipher("password", "abcdefghijklmnopqrstuvwxyz")
    print(v.encode("codewars"))
    print(v.decode("rovwsoiv"))


if __name__ == "__main__":
    unittest.main()
    # main()
