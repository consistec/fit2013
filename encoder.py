#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
encode.py has a mapping of all the chars in the english alphabet. A
big assumption how the encoding should look like.

usage: ./encode.py <input_file> <output_file>
"""

__author__ = "Jochen Breuer <brejoc@gmail.com>"
__license__ = "GPLv3"


import os
import sys
import string


ABC = string.lowercase + string.uppercase
MAPPING = [39, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 40, 12, 25, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 16, 17, 18, 19, 20, 21, 22, 23, 24, 15, 14, 13]

def encode(input):
    """\
    Encode input with the assumed mapping.
    """
    output_string = ""
    for char in input:
        pos = ABC.find(char)
        if pos >= 0:
            output_string += ABC[MAPPING[pos]]
        else:
            output_string += char
    return output_string


def main():
    """\
    Reads input file, gets encoding and saves to output file.
    """
    if len(sys.argv) < 3:
        print("usage: %s <input_file> <output_file>" % ( sys.argv[0], ))
        sys.exit(1)
        
    input_file = sys.argv[1]
    output_file = sys.argv[2]

    input_string = ""
    if os.path.isfile(input_file):
        with open(input_file, "r") as f:
            input_string = f.read()
        output_string = encode(input_string)
        with open(output_file, "w") as fw:
            fw.write(output_string)
    else:
        sys.stderr.write("error: input file is not existing.")
        sys.exit(2)


if __name__ == "__main__":
    main()


