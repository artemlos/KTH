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

---

trise = *trise & 0xfff1; or *trise& ~0xe (masking the 3 2 1) or TRISECLR = 0xe;

either we set up a pointer to a certain memory location or use pic32mx.h where we have
predefined commands such as TRISE, TRISECLR, PORTE.


1:64 - 110

80 M / 64

in C, you can use compiler flags, such as if.

#if TMRPREIOD > 0xFFFF
#error "Timer period too big"
#endif


pic32 uses 3.3 V for the pins

(look up big endian)


a port has a set of pins.
each port is contolled by TRISx and PORTx registers, x is the letter for the port of interest (A-G)
* Tris is tells if it is an input (1) or output (0). 
* Port is the actual value
NB: a port of this kind refers to several ins/outs. thus, TRIS = 0xFF00 means that 8 GPIO pins will output while the remaning input.

ex.
PORTDSET = 0b0101;
PORTDCLR = 0b1000;

This will target the ones only. So, it wil first set the 1st and 3rd bit while it clears the 4th.

