  # labwork.S
  # Written 2015 by F Lundevall
  # Skeleton file for IS1200/IS1500 lab 1 2015-2016.
  # The macros PUSH and POP are in the public domain.

.global delay
.global time2string

.macro	PUSH reg
	addi	$sp,$sp,-4
	sw	\reg,0($sp)
.endm

.macro	POP reg
	lw	\reg,0($sp)
	addi	$sp,$sp,4
.endm


.data
.align 2

.text

main:


delay:
	# mv is in $a0.
	
loop:
	ble	$a0, $0, stop
	
	nop
	
	addi	$a0, $0, -1
	li	$t6, 20000000
	addi	$t7, $0, -1
	
	forloop:
		addi	$t7, $t7, 1
		ble	$t7, $t6, forloop
		nop
	
	j	loop
	nop
	
stop:	
	jr 	$ra
	nop


hexasc:
	andi	$a0, $a0, 0xF	# remove all bits except the 4 lsb.
	
	addi	$v0, $0, 0x30
	
	addi	$t0, $0, 0x9
	
	ble	$a0, $t0, converter
	
	nop
	
	addi	$v0, $v0, 0x7
	
converter:

	add	$v0, $a0, $v0
	
	jr	$ra
	
	nop


time2string:
	PUSH	$s5
	PUSH	$s1
	PUSH	$s2
	PUSH	$s3
	PUSH	$ra
	PUSH	$s4

	add	$s5, $0, $a1
	srl	$s1, $a1, 4	# 1st 
	srl	$s2, $a1, 8
	srl	$s3, $a1, 12

	add	$s4, $0, $a0
	
	move	$a0, $s3
	jal	hexasc
	nop
	sb	$v0, 0($s4)
	
	move	$a0, $s2
	jal	hexasc
	nop
	sb	$v0, 1($s4)
	
	addi	$t4, $0, 0x3A
	sb	$t4, 2($s4)
		
	move	$a0, $s1
	jal	hexasc
	nop
	sb	$v0, 3($s4)
	
		
	move	$a0, $s5
	jal	hexasc
	nop
	sb	$v0, 4($s4)


	andi	$s5, $s5, 1
	bne	$s5, 1, even
	nop
	
	addi	$t4, $0, 0x44
	sb	$t4, 5($s4)
	
	j	slut
	nop
	
	even:
	addi	$t4, $0, 0x45
	sb	$t4, 5($s4)
	
	slut:
	addi	$t4, $0, 0x0
	sb	$t4, 6($s4)
	

	
	POP	$s4
	POP	$ra
	POP	$s3
	POP	$s2
	POP	$s1
	POP	$s5
	

	jr	$ra
	nop
