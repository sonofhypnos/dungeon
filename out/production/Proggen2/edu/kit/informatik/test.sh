#!/usr/bin/expect -f

set timeout -1

#command for intellij stuff
spawn /home/tassilo/.jdks/corretto-11.0.10/bin/java -javaagent:/snap/intellij-idea-ultimate/341/lib/idea_rt.jar=43395:/snap/intellij-idea-ultimate/341/bin -Dfile.encoding=UTF-8 -classpath /home/tassilo/IdeaProjects/Proggen2/out/production/Proggen2 edu.kit.informatik.Application

# Welcome to Runa's Strive\r\nSelect Runa's character class\r\n1) Warrior\r\n2) Mage\r\n3) Paladin\r\nEnter number [1
# --3]:\r\n
#escape brackets!
#
expect -exact "Welcome to Runa's Strive\r\nSelect Runa's character class\r\n1) Warrior\r\n2) Mage\r\n3) Paladin\r\nEnter number \[1--3\]:\r\n"

send -- "1\n"
expect -exact "1\n\r
To shuffle ability cards and monsters, enter two seeds\r
Enter seeds \[1--2147483647\] separated by comma:\r
"

send -- "32,23\r"

expect -exact "32,23\r"

expect -exact "Runa enters Stage 1 of Level 1\r
----------------------------------------\r
Runa (50/50 HP, 1/4 FP)\r
vs.\r
Ghost (15 HP, 0 FP): attempts Focus(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
Enter number [1--2]:"
\r
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)\r
Enter dice roll [1--4]:"
send -- "4\r"
expect exact "4\r"
expect -exact "Ghost takes 10 phy. damage\r
Ghost uses Focus(1)\r
----------------------------------------\r
Runa (50/50 HP, 1/4 FP)\r
vs.\r
Ghost (5 HP, 0 FP): attempts Ice(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)\r
Enter dice roll [1--4]:\r
"
send -- "3\r"
expect exact "3\r"
expect -exact "Ghost takes 9 phy. damage\r
Ghost dies\r
Choose Runa's reward\r
1) new ability cards\r
2) next player dice\r
Enter number [1--2]:\r
"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa upgrades her die to a d6\r
Runa enters Stage 2 of Level 1\r
----------------------------------------\r
Runa (50/50 HP, 1/6 FP)\r
vs.\r
Spider (15 HP, 0 FP): attempts Bite(1) next\r
Rat (14 HP, 0 FP): attempts Block(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
Enter number [1--2]:\r
"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Parry(1)\r
Spider uses Bite(1)\r
Runa takes 3 phy. damage\r
Rat uses Block(1)\r
----------------------------------------\r
Runa (47/50 HP, 1/6 FP)\r
vs.\r
Spider (15 HP, 0 FP): attempts Block(1) next\r
Rat (14 HP, 0 FP): attempts Claw(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
Enter number [1--2]:\r
"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Parry(1)\r
Spider uses Block(1)\r
Rat uses Claw(1)\r
----------------------------------------\r
Runa (47/50 HP, 1/6 FP)\r
vs.\r
Spider (15 HP, 0 FP): attempts Bite(1) next\r
Rat (14 HP, 0 FP): attempts Block(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Select Runa's target.\r
1) Spider\r
2) Rat\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)\r
Enter dice roll [1--6]:\r
"
send -- "6\r"
expect exact "6\r"
expect -exact "Spider takes 9 phy. damage\r
Spider uses Bite(1)\r
Runa takes 10 phy. damage\r
Rat uses Block(1)\r
----------------------------------------\r
Runa (37/50 HP, 1/6 FP)\r
vs.\r
Spider (6 HP, 0 FP): attempts Block(1) next\r
Rat (14 HP, 0 FP): attempts Claw(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Select Runa's target.\r
1) Spider\r
2) Rat\r
Enter number [1--2]:\r
"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Thrust(1)\r
Enter dice roll [1--6]:\r
"
send -- "5\r"
expect exact "5\r"
expect -exact "Rat takes 4 phy. damage\r
Spider uses Block(1)\r
Rat uses Claw(1)\r
Runa takes 6 phy. damage\r
----------------------------------------\r
Runa (31/50 HP, 1/6 FP)\r
vs.\r
Spider (6 HP, 0 FP): attempts Bite(1) next\r
Rat (10 HP, 0 FP): attempts Block(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Select Runa's target.\r
1) Spider\r
2) Rat\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)\r
Enter dice roll [1--6]:\r
"
send -- "6\r"
expect exact "6\r"
expect -exact "Spider takes 9 phy. damage\r
Spider dies\r
Rat uses Block(1)\r
----------------------------------------\r
Runa (31/50 HP, 1/6 FP)\r
vs.\r
Rat (10 HP, 0 FP): attempts Claw(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)\r
Enter dice roll [1--6]:\r
"
send -- "6\r"
expect exact "6\r"
expect -exact "Rat takes 9 phy. damage\r
Rat uses Claw(1)\r
Runa takes 6 phy. damage\r
----------------------------------------\r
Runa (25/50 HP, 1/6 FP)\r
vs.\r
Rat (1 HP, 0 FP): attempts Block(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)\r
Enter dice roll [1--6]:\r
"
send -- "6\r"
expect exact "6\r"
expect -exact "Rat takes 16 phy. damage\r
Rat dies\r
Choose Runa's reward\r
1) new ability cards\r
2) next player dice\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Pick 2 card(s) as loot\r
1) Fire(1)\r
2) Slash(1)\r
3) Lightning(1)\r
4) Ice(1)\r
Enter numbers [1--4] separated by comma:\r
"
send -- "2,3\r"
expect exact "2,3\r"
expect -exact "Runa gets Slash(1)\r
Runa gets Lightning(1)\r
Runa (25/50 HP) can discard ability cards for healing (or none)\r
1) Thrust(1)\r
2) Parry(1)\r
3) Slash(1)\r
4) Lightning(1)\r
Enter numbers [1--4] separated by comma:\r
"
send -- "3\r"
expect exact "3\r"
expect -exact "Runa gains 10 health\r
Runa enters Stage 3 of Level 1\r
----------------------------------------\r
Runa (35/50 HP, 1/6 FP)\r
vs.\r
Frog (16 HP, 0 FP): attempts Focus(1) next\r
Gorgon (13 HP, 0 FP): attempts Focus(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
3) Lightning(1)\r
Enter number [1--3]:\r
"
send -- "3\r"
expect exact "3\r"
expect -exact "Select Runa's target.\r
1) Frog\r
2) Gorgon\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Lightning(1)\r
Frog takes 9 mag. damage\r
Frog uses Focus(1)\r
Gorgon uses Focus(1)\r
----------------------------------------\r
Runa (35/50 HP, 1/6 FP)\r
vs.\r
Frog (7 HP, 0 FP): attempts Water(1) next\r
Gorgon (13 HP, 0 FP): attempts Fire(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
3) Lightning(1)\r
Enter number [1--3]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Select Runa's target.\r
1) Frog\r
2) Gorgon\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)\r
Enter dice roll [1--6]:\r
"
send -- "6\r"
expect exact "6\r"
expect -exact "Frog takes 16 phy. damage\r
Frog dies\r
Gorgon gains 1 focus\r
Gorgon uses Fire(1)\r
Runa takes 14 mag. damage\r
----------------------------------------\r
Runa (21/50 HP, 1/6 FP)\r
vs.\r
Gorgon (13 HP, 0 FP): attempts Focus(1) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(1)\r
2) Parry(1)\r
3) Lightning(1)\r
Enter number [1--3]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)\r
Enter dice roll [1--6]:\r
"
send -- "6\r"
expect exact "6\r"
expect -exact "Gorgon takes 16 phy. damage\r
Gorgon dies\r
Choose Runa's reward\r
1) new ability cards\r
2) next player dice\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Pick 2 card(s) as loot\r
1) Reflect(1)\r
2) Swing(1)\r
3) Pierce(1)\r
4) Focus(1)\r
Enter numbers [1--4] separated by comma:\r
"
send -- "3,4\r"
expect exact "3,4\r"
expect -exact "Runa gets Pierce(1)\r
Runa gets Focus(1)\r
Runa (21/50 HP) can discard ability cards for healing (or none)\r
1) Thrust(1)\r
2) Parry(1)\r
3) Lightning(1)\r
4) Pierce(1)\r
5) Focus(1)\r
Enter numbers [1--5] separated by comma:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa gains 10 health\r
Runa enters Stage 4 of Level 1\r
----------------------------------------\r
Runa (31/50 HP, 1/6 FP)\r
vs.\r
Spider King (50 HP, 0 FP): attempts Bite(1) next\r
----------------------------------------\r
Select card to play\r
1) Parry(1)\r
2) Lightning(1)\r
3) Pierce(1)\r
4) Focus(1)\r
Enter number [1--4]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Parry(1)\r
Spider King uses Bite(1)\r
Runa takes 3 phy. damage\r
----------------------------------------\r
Runa (28/50 HP, 1/6 FP)\r
vs.\r
Spider King (50 HP, 0 FP): attempts Block(1) next\r
----------------------------------------\r
Select card to play\r
1) Parry(1)\r
2) Lightning(1)\r
3) Pierce(1)\r
4) Focus(1)\r
Enter number [1--4]:\r
"
send -- "4\r"
expect exact "4\r"
expect -exact "Runa uses Focus(1)\r
Spider King uses Block(1)\r
Runa gains 1 focus\r
----------------------------------------\r
Runa (28/50 HP, 2/6 FP)\r
vs.\r
Spider King (50 HP, 0 FP): attempts Focus(1) next\r
----------------------------------------\r
Select card to play\r
1) Parry(1)\r
2) Lightning(1)\r
3) Pierce(1)\r
4) Focus(1)\r
Enter number [1--4]:\r
"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Lightning(1)\r
Spider King takes 16 mag. damage\r
Spider King uses Focus(1)\r
----------------------------------------\r
Runa (28/50 HP, 1/6 FP)\r
vs.\r
Spider King (34 HP, 0 FP): attempts Lightning(1) next\r
----------------------------------------\r
Select card to play\r
1) Parry(1)\r
2) Lightning(1)\r
3) Pierce(1)\r
4) Focus(1)\r
Enter number [1--4]:\r
"
send -- "3\r"
expect exact "3\r"
expect -exact "Runa uses Pierce(1)\r
Enter dice roll [1--6]:\r
"
send -- "6\r"
expect exact "6\r"
expect -exact "Spider King takes 18 phy. damage\r
Spider King gains 1 focus\r
Spider King uses Lightning(1)\r
Runa takes 16 mag. damage\r
----------------------------------------\r
Runa (12/50 HP, 1/6 FP)\r
vs.\r
Spider King (16 HP, 0 FP): attempts Bite(1) next\r
----------------------------------------\r
Select card to play\r
1) Parry(1)\r
2) Lightning(1)\r
3) Pierce(1)\r
4) Focus(1)\r
Enter number [1--4]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Parry(1)\r
Spider King uses Bite(1)\r
Runa takes 3 phy. damage\r
----------------------------------------\r
Runa (9/50 HP, 1/6 FP)\r
vs.\r
Spider King (16 HP, 0 FP): attempts Block(1) next\r
----------------------------------------\r
Select card to play\r
1) Parry(1)\r
2) Lightning(1)\r
3) Pierce(1)\r
4) Focus(1)\r
Enter number [1--4]:\r
"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Lightning(1)\r
Spider King takes 9 mag. damage\r
Spider King uses Block(1)\r
----------------------------------------\r
Runa (9/50 HP, 1/6 FP)\r
vs.\r
Spider King (7 HP, 0 FP): attempts Focus(1) next\r
----------------------------------------\r
Select card to play\r
1) Parry(1)\r
2) Lightning(1)\r
3) Pierce(1)\r
4) Focus(1)\r
Enter number [1--4]:\r
"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Lightning(1)\r
Spider King takes 9 mag. damage\r
Spider King dies\r
Runa gets Thrust(2)\r
Runa gets Parry(2)\r
Runa (9/50 HP) can discard ability cards for healing (or none)\r
1) Parry(1)\r
2) Lightning(1)\r
3) Pierce(1)\r
4) Focus(1)\r
5) Thrust(2)\r
6) Parry(2)\r
Enter numbers [1--6] separated by comma:\r
"
send -- "1,2,3,4\r"
expect exact "1,2,3,4\r"
expect -exact "Runa gains 40 health\r
To shuffle ability cards and monsters, enter two seeds\r
Enter seeds [1--2147483647] separated by comma:\r
"
send -- "42,24\r"
expect exact "42,24\r"
expect -exact "Runa enters Stage 1 of Level 2\r
----------------------------------------\r
Runa (49/50 HP, 1/6 FP)\r
vs.\r
Mushroomlon (50 HP, 0 FP): attempts Deflect(2) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(2)\r
2) Parry(2)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(2)\r
Enter dice roll [1--6]:\r
"
send -- "6\r"
expect exact "6\r"
expect -exact "Mushroomlon takes 26 phy. damage\r
Mushroomlon uses Deflect(2)\r
----------------------------------------\r
Runa (49/50 HP, 1/6 FP)\r
vs.\r
Mushroomlon (24 HP, 0 FP): attempts Scratch(2) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(2)\r
2) Parry(2)\r
Enter number [1--2]:\r
"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Parry(2)\r
Mushroomlon uses Scratch(2)\r
----------------------------------------\r
Runa (49/50 HP, 1/6 FP)\r
vs.\r
Mushroomlon (24 HP, 0 FP): attempts Block(2) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(2)\r
2) Parry(2)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(2)\r
Enter dice roll [1--6]:\r
"
send -- "5\r"
expect exact "5\r"
expect -exact "Mushroomlon takes 17 phy. damage\r
Mushroomlon uses Block(2)\r
----------------------------------------\r
Runa (49/50 HP, 1/6 FP)\r
vs.\r
Mushroomlon (7 HP, 0 FP): attempts Deflect(2) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(2)\r
2) Parry(2)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(2)\r
Enter dice roll [1--6]:\r
"
send -- "5\r"
expect exact "5\r"
expect -exact "Mushroomlon takes 3 phy. damage\r
Mushroomlon uses Deflect(2)\r
----------------------------------------\r
Runa (49/50 HP, 1/6 FP)\r
vs.\r
Mushroomlon (4 HP, 0 FP): attempts Scratch(2) next\r
----------------------------------------\r
Select card to play\r
1) Thrust(2)\r
2) Parry(2)\r
Enter number [1--2]:\r
"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(2)\r
Enter dice roll [1--6]:\r
"
send -- "6\r"
expect exact "6\r"
expect -exact "Mushroomlon takes 26 phy. damage\r
Mushroomlon dies\r
Choose Runa's reward\r
1) new ability cards\r
2) next player dice\r
Enter number [1--2]:\r
"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa upgrades her die to a d8\r
Runa (49/50 HP) can discard ability cards for healing (or none)\r
1) Thrust(2)\r
2) Parry(2)\r
Enter number [1--2]:\r
"
send -- "quit\r"
expect exact "quit\r"
expect eof
