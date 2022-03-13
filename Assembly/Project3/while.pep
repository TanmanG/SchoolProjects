; Tanner Good, 11/25/2020, Project 3 Phase 3, CMPSCI-122 49960
; This program will- given a decimal value 'maxLoop'- will
; loop through 'while' maxLoop number of times.
         BR main
maxLoop: .BLOCK 2
curLoop: .BLOCK 2
loopTxt: .ASCII " inside the loop is Less Than \x00"
loopEnd: .ASCII " is equal or exceeds \x00"
loopBrk: .ASCII "\n\x00"
main:    DECI maxLoop,d ; Store input for maxLoop.
         BR whileChk ; Branch to loop start.
whileChk:LDWA curLoop,d ; Start of while ( true/false ) test.
         CPWA maxLoop,d
         BRLT while 
         BR whileEnd ; End of true/false test.
while:   DECO curLoop,d ; Start of loop body.
         STRO loopTxt,d
         DECO maxLoop,d
         STRO loopBrk,d ; End of loop body.
         ADDA 1,i ; Start of code to change loop control variable.
         STWA curLoop,d 
         BR whileChk ; End of current loop & code to change loop control variable.
whileEnd:DECO curLoop,d ; Loop end, jump here when loop is done.
         STRO loopEnd,d
         DECO maxLoop,d
         BR end
end:     .END