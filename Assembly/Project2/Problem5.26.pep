         br main 
amount:  .EQUATE 10000 ; Get the hexadecimal value of 10,000.
num:     .BLOCK 2
sum:     .BLOCK 2
sumText: .ASCII "sum = \x00" 
return:  .ASCII "\n\x00"
main:    DECI num,d ; Store user input to 'num'.
         LDWA num,d ; Load user input to the accumulator.
         ADDA amount,i ; Add 10,000 to the accumulator.
         STWA sum,d ; Store the new value to 'sum'.
         STRO sumText,d ; Print out the base text.
         DECO sum,d ; Print out the contents of 'sum'.
         STRO return,d ; Print a new line statement.
.END