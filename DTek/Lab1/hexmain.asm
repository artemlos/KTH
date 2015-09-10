  # hexmain.asm
  # Written 2015-09-04 by F Lundevall
  # Copyright abandonded - this file is in the public domain.

	.text
main:
	li	$a0,3		# change this to test different values

	jal	hexasc		# call hexasc
	nop			# delay slot filler (just in case)	

	move	$a0,$v0		# copy return value to argument register

	li	$v0,11		# syscall with v0 = 11 will print out
	syscall			# one byte from a0 to the Run I/O window
	
stop:	j	stop		# stop after one run
	nop			# delay slot filler (just in case)

  # You can write your own code for hexasc here
  #
  
 
hexasc:
	andi	$a0, $a0, 0xF	# remove all bits except the 4 lsb.
	
	addi	$v0, $0, 0x30
	
	addi	$t0, $0, 0x9
	
	ble	$a0, $t0, converter
	
	addi	$v0, $v0, 0x7
	
converter:

	add	$v0, $a0, $v0
	
	jr	$ra
