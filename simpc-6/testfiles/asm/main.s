		.global _start
		.data
		buf: .skip 1024
		.text
		_start:
		call main
		main:
		pushq %rbp
		movq %rsp, %rbp
	subq $16, %rsp
        movq -16(%rbp), %rsi
        movq -24(%rbp), %rsi
		movq %rbp, %rsp
		popq %rbp
		ret
		gcd:
		pushq %rbp
		movq %rsp, %rbp
		movq %rbp, %rsp
		popq %rbp
		ret
		gcd2:
		pushq %rbp
		movq %rsp, %rbp
		movq %rbp, %rsp
		popq %rbp
		ret
		exit:
		movq $0, %rdi
		movq $60, %rax
		syscall
