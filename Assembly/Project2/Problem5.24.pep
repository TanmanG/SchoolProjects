         BR main
num1:    .BLOCK 2
num2:    .BLOCK 2 
main:    DECI num1,d ; Take input from the user and store it to 'num1'.
         DECI num2,d ; Take the second input from the user and store it to 'num2'.
         DECO num1,d ; Output the user's first input.
         LDBA '\n',i ; Load a newline character to the accumulator.
         STBA charOut,d ; Print the newline character.
         DECO num2,d ; Print the user's second input.
.END