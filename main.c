#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <libgen.h>

//oversized for our example, but should perform better for large files
#define	BUFSIZE		4096

struct settings {
	char *files[2];
};

void process(struct settings *settings) {
	FILE *infile = NULL;
	FILE *outfile = NULL;
	
	if(strcmp(settings->files[0], "-") == 0)
		infile = stdin;
	if(strcmp(settings->files[1], "-") == 0)
		outfile = stdout;
	
	if(infile == NULL) {
		infile = fopen(settings->files[0], "r");
		if(infile == NULL) {
			fprintf(stderr, "Can't open input file %s\n", settings->files[0]);
			exit(1);
		}
	}
	
	if(outfile == NULL) {
		outfile = fopen(settings->files[1], "w");
		if(outfile == NULL) {
			fprintf(stderr, "Can't open output file %s\n", settings->files[1]);
			fclose(infile);
			exit(1);
		}
	}
	
	char buf[BUFSIZE];
	size_t nread;
	while(!feof(infile)) {
		nread = fread((void*) buf, sizeof(char), BUFSIZE, infile);
		
		int i;
		for(i=0; i<nread; i++) {
			if(buf[i] >= 'A' && buf[i] <= 'N') {
				buf[i] -= 2;
				if(buf[i] < 'A') {
					buf[i] += 14;
				}
				buf[i] += 0x20;
			}
			else if(buf[i] >= 'O' && buf[i] <= 'Z') {
				buf[i] += 2;
				if(buf[i] > 'Z') {
					buf[i] -= 12;
				}
				buf[i] += 0x20;
			}
			else if(buf[i] >= 'a' && buf[i] <= 'n') {
				buf[i] -= 1;
				if(buf[i] < 'a') {
					buf[i] += 14;
				}
				buf[i] -= 0x20;
			}
			else if(buf[i] >= 'o' && buf[i] <= 'z') {
				buf[i] += 1;
				if(buf[i] > 'z') {
					buf[i] -= 12;
				}
				buf[i] -= 0x20;
			}
		}
		
		int nwritten = fwrite((void*) buf, sizeof(char), nread, outfile);
		if(nwritten != nread) {
			fprintf(stderr, "A write error occured. Aborting.\n");
			fclose(infile);
			fclose(outfile);
			exit(2);
		}
	}
	
	fclose(infile);
	fclose(outfile);
}

void printUsageExit(FILE *stream, char pname[]) {
	fprintf(stream, "Usage: %s INFILE OUTFILE\n", pname);
	fprintf(stream, "Encodes files for the 2013 cosistec FIT Prrogramming Contest\n");
	fprintf(stream, "'-' (without quotes) as a filename is recoginzed as stdin/stdout\n\n");
	fprintf(stream, "-h --help\tPrint this help page and exit\n");
	fprintf(stream, "-v --version\tPrint version and legal information and exit\n");
	fprintf(stream, "\nThis program was written by Jannis Froese\nEmail: s9jafroeATstudDOTuni-saarlandDOTde");
	exit(1);
}

void printVersionExit(FILE *stream) {
	fprintf(stream, "FIT2013encodeJF 1.00\n");
	fprintf(stream, "Copyright (C) 2013 Jannis Froese\n");
	fprintf(stream, "Starting from 2013-05-07 (7th May 2013) this software is free software\n");
	fprintf(stream, "From that day forth, you may redistribute binaries and/or source code\n");
	fprintf(stream, "under the terms of CC0 <http://creativecommons.org/publicdomain/zero/1.0/>\n\n");
	fprintf(stream, "\nThis program was written by Jannis Froese\nEmail: s9jafroeATstudDOTuni-saarlandDOTde");
	exit(1);
}

int main(int argc, char *argv[]) {
	struct settings settings;
	char* pname = basename(argv[0]);
	
	if(argc == 2) {
		if(strcmp(argv[1], "-v") == 0 || strcmp(argv[1], "--version") == 0) {
			printVersionExit(stdout);
		} else if (strcmp(argv[1], "-h") == 0 || strcmp(argv[1], "--help") == 0) {
			printUsageExit(stdout, pname);
		} else {
			fprintf(stderr, "Unrecognized option %s or too few arguments. Exiting.\n\n");
			printUsageExit(stderr, pname);
		}
	}
	
	if(argc != 3) {
		fprintf(stderr, "Wrong number of arguments. Exiting.\n\n");
		printUsageExit(stderr, pname);
	} else {
		settings.files[0] = argv[1];
		settings.files[1] = argv[2];
	}
	
	process(&settings);
	return 0;
}