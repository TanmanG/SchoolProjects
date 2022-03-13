; Tanner Good, 11/25/2020, Project 3 Phase 2, CMPSCI-122 49960
; Takes two inputs ('condit' and 'check' respectively) and
; compares them ('>=' equivalent); branching to true or false
; based on the results.
         BR main
condit:  .BLOCK 2 ; Space in memory for condition value.
check:   .BLOCK 2 ; Space in memory for checked value.
text1:   .ASCII " is Greater Than or Equal to \x00"
text2:   .ASCII " is Less Than \x00"
main:    DECI condit,d ; Storing of condition.
         DECI check,d ; Storing of check.
         LDWA check,d ; Start of if ( true/false ) test.
         CPWA condit,d
         BRGE true
         BR false ; End of true/false test.
         STOP
true: DECO check,d ; Start of code to execute when true (larger/equal).
         STRO text1,d
         DECO condit,d
         BR stop ; End of code to execute when true (larger/equal).
false:    DECO check,d ; Start of code to execute when false (smaller).
         STRO text2,d
         DECO condit,d
         BR stop ; End of code to execute when false (smaller).
stop:     .END