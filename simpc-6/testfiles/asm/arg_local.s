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

calc:
pushq %rbp
movq %rsp, %rbp
subq $8, %rsp
Missing code gen for lang.ast.IdUse@27ddd392
pushq %rax
Missing code gen for lang.ast.IdUse@19e1023e
movq %rax, %rbx
popq %rax
addq %rbx, %rax
