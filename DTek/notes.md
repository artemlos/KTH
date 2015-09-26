stack = static memory
heap = dynamic memory

high language -> (compiler) -> assembly code -> (assembler) -> object file -> (linker) -> executable -> (loader) -> memory

linker = particularly useful for large programs with many files

pseudo instructions use the $at register at the temoporary register.

exception = processor will always jump to 0x80000180 (MIPS) no matter the cause (eg. division by zero, key press)

Converting from Two's complement to decimal
--

2^N-X, N = no. of bits, X is the value.

ex. 110 is 2^3-6=8-6=2 => -2

ex. 110 is 001+001 = 010 = 2 (by inverting bits)

(they are in reversed order)

floating points are a bit special.

MIPS: instructions have to be word alligned