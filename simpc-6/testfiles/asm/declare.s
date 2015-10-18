.global _start
.data
buf: .skip 1024
.text
_start:

call main
exit:
movq $0, %rdi
movq $60, %rax
syscall

main:
pushq %rbp
movq %rsp, %rbp
subq $8, %rsp
movq $250, %rax
