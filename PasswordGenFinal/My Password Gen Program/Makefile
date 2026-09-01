CC := cc
CFLAGS := -Wall -Wextra -std=c11
TARGET := GenPass
SOURCES := $(wildcard *.c)
OBJECTS := $(SOURCES:.c=.o)
PACKAGE := $(TARGET).tar.gz

.PHONY: all clean package

all: $(TARGET)

$(TARGET): $(OBJECTS)
	$(CC) $(CFLAGS) $^ -o $@

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

package: $(PACKAGE)

$(PACKAGE): $(SOURCES) $(wildcard *.h) Makefile
	tar -czf $@ $^

clean:
	rm -f $(OBJECTS) $(TARGET) $(PACKAGE)
