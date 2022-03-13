         br main 
main:    LDBA 0xFC15,d ; Load the user's char input to the accumulator.
         SUBA 1,i ; Subtract 1 from the stored input's value.
         STBA charOut,d ; Print the char value of the accumulator.
.END