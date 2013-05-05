all: build

build: main.c
	gcc main.c -o encoder
	
clean:
	rm -f encoder encoder.exe