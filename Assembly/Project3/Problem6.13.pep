         BR main
input:   .BLOCK 1
dollSign:.ASCII "$\x00"
A:       .ASCII "A\x00"
Z:       .ASCII "Z\x00"
a:       .ASCII "a\x00"
z:       .ASCII "z\x00"
main:    LDBA 0xFC15,d
         STBA input,d
         BR ifA
ifA:     CPBA A,d ; Check for char greater/equal to than A.
         BRGE ifZ
         BR ifa
ifZ:     CPBA Z,d ; Check for char smaller/equal to than Z.
         BRLE true1
         BR ifa
true1:   STRO A,d ; Print A if value is between A and Z.
         BR end
ifa:     CPBA a,d  ; Check for char smaller/equal to than a.
         BRGE ifz
         BR else
ifz:     CPBA z,d ; Check for char smaller/equal to than z.
         BRLE true2
         BR else
true2:   STRO a,d ; Print a if value is between a and z while not between A and Z.
         BR end
else:    STRO dollSign,d ; Else statement when none of the prior conditions are met.
end:     .END 