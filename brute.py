#!/usr/bin/env python
# -*- coding: utf-8 -*-


"""
brute.py reads all input and output files and maps the chars.
With the gained knowledge from the given files brute.py then tries
to encode the string passed to it.

usage: ./brute.py <input_file> <output_file>
"""

__author__ = "Jochen Breuer <brejoc@gmail.com>"
__license__ = "GPLv3"


import os
import sys
import string


# returns the absolute path to this file extended by the parameter
abs_path = lambda parameter: os.path.join(
    os.path.dirname(os.path.abspath(__file__)),
    parameter)


def map_input_output():
    """\
    Returns the dynamic mapping between input and output.
    """
    input, output = read_input_output()
    return { key:output[i-1] for i, key in enumerate(input, 1) } 


def read_input_output():
    """\
    Returns the strings for all input and output files.
    """
    input_directory = abs_path("input")
    output_directory = abs_path("output")
    return read_files_in(input_directory), read_files_in(output_directory)

def read_files_in(directory):
    """\
    Reads and returns the content of all txt files from the given folder.
    """
    files_string = ""
    for root,dirs,files in os.walk(directory):
        files.sort()
        for file in files:
            if file.endswith(".txt"):
                with open(os.path.join(root, file), 'r') as f:
                    files_string += f.read()
    return files_string

def encode(input):
    output = ""
    mapping = map_input_output()
    for char in input:
        try:
            output += mapping[char]
        except:
            output += char
            print("Character '%s' is not in mapping" % char)
    return output


def main():
    if len(sys.argv) < 3:
        print("usage: %s <input_file> <output_file>" % ( sys.argv[0], ))
        sys.exit(1)
        
    # comes from agrv
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
