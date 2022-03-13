         BR main 
filter:  .EQUATE 65520 ; Mask for divisible bits.
remain:  .BLOCK 2
input:   .BLOCK 2

main:    DECI input,d ; Store user input to 'input'.
         LDWA input,d ; Load user input in to accumulator.
         ANDA filter,i ; Filter the quotient using an and statement.
         STWA remain,d ; Store the quotient to 'remain'.
         LDWA input,d ; Load the original user input to the accumulator again.
         SUBA remain,d ; Subtract the quotient to get the remainder.
         STWA remain,d ; Store the remainder to 'remain'.
         DECO remain,d ; Print the stored remainder as a decimal.
.END