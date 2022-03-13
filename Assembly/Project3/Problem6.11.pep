         BR main 
filter:  .EQUATE 65534 ; Mask for divisible bits.
remain:  .BLOCK 2
input:   .BLOCK 2
text1:   .ASCII "Even\n\x00"
text2:   .ASCII "Odd\n\x00" 

even:    STRO text1,d 
         BR end

odd:     STRO text2,d
         BR end

main:    DECI input,d ; Store user input to 'input'.
         LDWA input,d ; Load user input in to accumulator.
         ANDA filter,i ; Filter the quotient using an and statement.
         STWA remain,d ; Store the quotient to 'remain'.
         LDWA input,d ; Load the original user input to the accumulator again.
         SUBA remain,d ; Subtract the quotient to get the remainder.
         CPWA 1,i
         BREQ odd
         BR even
end:     .END