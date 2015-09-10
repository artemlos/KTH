  # timetemplate.asm
  # Written 2015 by F Lundevall
  # Copyright abandonded - this file is in the public domain.

.macro	PUSH (%reg)
	addi	$sp,$sp,-4
	sw	%reg,0($sp)
.end_macro

.macro	POP (%reg)
	lw	%reg,0($sp)
	addi	$sp,$sp,4
.end_macro

	.data
	.align 2
mytime:	.word 0x5957
timstr:	.ascii "text more text lots of text\0"
	.text
main:
	# print timstr
	la	$a0,timstr
	li	$v0,4
	syscall
	nop
	# wait a little
	li	$a0,2
	jal	delay
	nop
	# call tick
	la	$a0,mytime
	jal	tick
	nop
	# call your function time2string
	la	$a0,timstr
	la	$t0,mytime
	lw	$a1,0($t0)
	jal	time2string
	nop
	# print a newline
	li	$a0,10
	li	$v0,11
	syscall
	nop
	# go back and do it all again
	j	main
	nop
# tick: update time pointed to by $a0
tick:	lw	$t0,0($a0)	# get time
	addiu	$t0,$t0,1	# increase
	andi	$t1,$t0,0xf	# check lowest digit
	sltiu	$t2,$t1,0xa	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x6	# adjust lowest digit
	andi	$t1,$t0,0xf0	# check next digit
	sltiu	$t2,$t1,0x60	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa0	# adjust digit
	andi	$t1,$t0,0xf00	# check minute digit
	sltiu	$t2,$t1,0xa00	# if digit < a, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0x600	# adjust digit
	andi	$t1,$t0,0xf000	# check last digit
	sltiu	$t2,$t1,0x6000	# if digit < 6, okay
	bnez	$t2,tiend
	nop
	addiu	$t0,$t0,0xa000	# adjust last digit
tiend:	sw	$t0,0($a0)	# save updated result
	jr	$ra		# return
	nop

  # you can write your code for subroutine "hexasc" below this line
  #
  
  
 hexasc:
	andi	$a2, $a2, 0xF	# remove all bits except the 4 lsb.
	
	addi	$v0, $0, 0x30
	
	addi	$t0, $0, 0x9
	
	ble	$a2, $t0, converter
	
	addi	$v0, $v0, 0x7
	
converter:

	add	$v0, $a2, $v0
	
	jr	$ra


delay:
	jr $ra
	nop
	
	
time2string:
	add	$t5, $0, $a1
	srl	$t1, $a1, 4	# 1st 
	srl	$t2, $a1, 8
	srl	$t3, $a1, 12
	
	move	$a2, $t3
	jal	hexasc
	sb	$v0, 0($a0)
	
	move	$a2, $t2
	jal	hexasc
	sb	$v0, 1($a0)
	
	addi	$t4, $0, 0x3A
	sb	$t4, 2($a0)
		
	move	$a2, $t1
	jal	hexasc
	sb	$v0, 3($a0)
	
		
	move	$a2, $t5
	jal	hexasc
	sb	$v0, 4($a0)
	
	addi	$t4, $0, 0x0
	sb	$t4, 5($a0)
	
	jr	$ra
	nop
	