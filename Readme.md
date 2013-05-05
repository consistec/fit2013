# My Solution

## Usage

Assuming gcc is installed (MinGW on Windows works fine):
make
encoder file1 file2

If make is not installed, "gcc main.c -o encoder" does just fine.

Some standard command line parameters are available, just type "encoder --help"

## Output

Output for lorem_ipsum.txt is supplied in output_lorem_ipsum.txt

## Unit Tests

I used test.txt (a concatenation of all 3 inputs) using
encoder text.txt -
and compared manually with the expected output.
Pretty low-tech, but completely sufficient since I don't need to keep this code working over 50 versions.

## Contact

You can reach me at s9jafroeATstudDOTuni-saarlandDOTde