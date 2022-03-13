         BR main
input:   .BLOCK 2
text1:   .ASCII " inside the switch matches \x00"
text2:   .ASCII "Switch done.\x00"
linebrk: .ASCII "\n\x00"
main:    DECI input,d
         LDWA input,d
         BR switch
switch:  CPWA 0,i
         BREQ case0
         CPWA 1,i
         BREQ case1
         CPWA 2,i
         BREQ case2
         CPWA 3,i
         BREQ case3
         CPWA 4,i
         BREQ case4
         BR default
case0:   DECO input,d
         STRO text1,d
         DECO 0,i
         STRO linebrk,d
         BR default
case1:   DECO input,d
         STRO text1,d
         DECO 1,i
         STRO linebrk,d
         BR default
case2:   DECO input,d
         STRO text1,d 
         DECO 2,i
         STRO linebrk,d
         BR default
case3:   DECO input,d
         STRO text1,d
         DECO 3,i
         STRO linebrk,d
         BR default
case4:   DECO input,d
         STRO text1,d
         DECO 4,i
         STRO linebrk,d
         BR default
default: BR end
end:     STRO text2,d
         .END