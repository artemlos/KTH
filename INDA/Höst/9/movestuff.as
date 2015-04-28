// moves the word a value 0xff that is stored at position 0x80 to 0xff in RAM.	
	word a 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0xff
	
	loadc r1 a	// initialize array.


	addc r1 0x58	// add 0x58 to the index. We will end up at 0x80 after this.
	loadr r2 r1	// store the value, i.e. 0xff in register r2.
	move r2 r3	// create a copy of r2 in r3.
	loadc r2 0	// r2 := 0.
	storer r2 r1	// store zero (r2) at the previous position of 0xff.
	addc r1 126	// add 126 to the index count. this will be position 0xff in memory.
	storer r3 r1	// store 0xff value in r3 in memory position 0xff (in RAM)
	
	
