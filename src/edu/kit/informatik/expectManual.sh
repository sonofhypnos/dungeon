#!/usr/bin/expect -f

set timeout -1

#command for intellij stuff
spawn /home/tassilo/.jdks/corretto-11.0.10/bin/java -javaagent:/snap/intellij-idea-ultimate/341/lib/idea_rt.jar=43395:/snap/intellij-idea-ultimate/341/bin -Dfile.encoding=UTF-8 -classpath /home/tassilo/IdeaProjects/Proggen2/out/production/Proggen2 edu.kit.informatik.Application

expect -exact "Welcome to Runa's Strive\r\nSelect Runa's character class\r\n1) Warrior\r\n2) Mage\r\n3) Paladin\r\nEnter number \[1--3\]:\r\n"

send -- "1\n"
expect -exact ""
expect -exact "1\n\r"

expect -exact "To shuffle ability cards and monsters, enter two seeds\r
Enter seeds \[1--2147483647\] separated by comma:\r"

send -- "32,23\r"

expect -exact "32,23\r"

expect -exact "Runa enters Stage 1 of Level 1
----------------------------------------
Runa (50/50 HP, 1/4 FP)
vs.
Ghost (15 HP, 0 FP): attempts Focus(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)
Enter dice roll [1--4]:"
send -- "4\r"
expect exact "4\r"
expect -exact "Ghost takes 10 phy. damage
Ghost uses Focus(1)
----------------------------------------
Runa (50/50 HP, 1/4 FP)
vs.
Ghost (5 HP, 0 FP): attempts Ice(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)
Enter dice roll [1--4]:"
send -- "3\r"
expect exact "3\r"
expect -exact "Ghost takes 9 phy. damage
Ghost dies
Choose Runa's reward
1) new ability cards
2) next player dice
Enter number [1--2]:"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa upgrades her die to a d6
Runa enters Stage 2 of Level 1
----------------------------------------
Runa (50/50 HP, 1/6 FP)
vs.
Spider (15 HP, 0 FP): attempts Bite(1) next
Rat (14 HP, 0 FP): attempts Block(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
Enter number [1--2]:"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Parry(1)
Spider uses Bite(1)
Runa takes 3 phy. damage
Rat uses Block(1)
----------------------------------------
Runa (47/50 HP, 1/6 FP)
vs.
Spider (15 HP, 0 FP): attempts Block(1) next
Rat (14 HP, 0 FP): attempts Claw(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
Enter number [1--2]:"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Parry(1)
Spider uses Block(1)
Rat uses Claw(1)
----------------------------------------
Runa (47/50 HP, 1/6 FP)
vs.
Spider (15 HP, 0 FP): attempts Bite(1) next
Rat (14 HP, 0 FP): attempts Block(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Select Runa's target.
1) Spider
2) Rat
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)
Enter dice roll [1--6]:"
send -- "6\r"
expect exact "6\r"
expect -exact "Spider takes 9 phy. damage
Spider uses Bite(1)
Runa takes 10 phy. damage
Rat uses Block(1)
----------------------------------------
Runa (37/50 HP, 1/6 FP)
vs.
Spider (6 HP, 0 FP): attempts Block(1) next
Rat (14 HP, 0 FP): attempts Claw(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Select Runa's target.
1) Spider
2) Rat
Enter number [1--2]:"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Thrust(1)
Enter dice roll [1--6]:"
send -- "5\r"
expect exact "5\r"
expect -exact "Rat takes 4 phy. damage
Spider uses Block(1)
Rat uses Claw(1)
Runa takes 6 phy. damage
----------------------------------------
Runa (31/50 HP, 1/6 FP)
vs.
Spider (6 HP, 0 FP): attempts Bite(1) next
Rat (10 HP, 0 FP): attempts Block(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Select Runa's target.
1) Spider
2) Rat
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)
Enter dice roll [1--6]:"
send -- "6\r"
expect exact "6\r"
expect -exact "Spider takes 9 phy. damage
Spider dies
Rat uses Block(1)
----------------------------------------
Runa (31/50 HP, 1/6 FP)
vs.
Rat (10 HP, 0 FP): attempts Claw(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)
Enter dice roll [1--6]:"
send -- "6\r"
expect exact "6\r"
expect -exact "Rat takes 9 phy. damage
Rat uses Claw(1)
Runa takes 6 phy. damage
----------------------------------------
Runa (25/50 HP, 1/6 FP)
vs.
Rat (1 HP, 0 FP): attempts Block(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)
Enter dice roll [1--6]:"
send -- "6\r"
expect exact "6\r"
expect -exact "Rat takes 16 phy. damage
Rat dies
Choose Runa's reward
1) new ability cards
2) next player dice
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Pick 2 card(s) as loot
1) Fire(1)
2) Slash(1)
3) Lightning(1)
4) Ice(1)
Enter numbers [1--4] separated by comma:"
send -- "2,3\r"
expect exact "2,3\r"
expect -exact "Runa gets Slash(1)
Runa gets Lightning(1)
Runa (25/50 HP) can discard ability cards for healing (or none)
1) Thrust(1)
2) Parry(1)
3) Slash(1)
4) Lightning(1)
Enter numbers [1--4] separated by comma:"
send -- "3\r"
expect exact "3\r"
expect -exact "Runa gains 10 health
Runa enters Stage 3 of Level 1
----------------------------------------
Runa (35/50 HP, 1/6 FP)
vs.
Frog (16 HP, 0 FP): attempts Focus(1) next
Gorgon (13 HP, 0 FP): attempts Focus(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
3) Lightning(1)
Enter number [1--3]:"
send -- "3\r"
expect exact "3\r"
expect -exact "Select Runa's target.
1) Frog
2) Gorgon
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Lightning(1)
Frog takes 9 mag. damage
Frog uses Focus(1)
Gorgon uses Focus(1)
----------------------------------------
Runa (35/50 HP, 1/6 FP)
vs.
Frog (7 HP, 0 FP): attempts Water(1) next
Gorgon (13 HP, 0 FP): attempts Fire(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
3) Lightning(1)
Enter number [1--3]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Select Runa's target.
1) Frog
2) Gorgon
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)
Enter dice roll [1--6]:"
send -- "6\r"
expect exact "6\r"
expect -exact "Frog takes 16 phy. damage
Frog dies
Gorgon gains 1 focus
Gorgon uses Fire(1)
Runa takes 14 mag. damage
----------------------------------------
Runa (21/50 HP, 1/6 FP)
vs.
Gorgon (13 HP, 0 FP): attempts Focus(1) next
----------------------------------------
Select card to play
1) Thrust(1)
2) Parry(1)
3) Lightning(1)
Enter number [1--3]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(1)
Enter dice roll [1--6]:"
send -- "6\r"
expect exact "6\r"
expect -exact "Gorgon takes 16 phy. damage
Gorgon dies
Choose Runa's reward
1) new ability cards
2) next player dice
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Pick 2 card(s) as loot
1) Reflect(1)
2) Swing(1)
3) Pierce(1)
4) Focus(1)
Enter numbers [1--4] separated by comma:"
send -- "3,4\r"
expect exact "3,4\r"
expect -exact "Runa gets Pierce(1)
Runa gets Focus(1)
Runa (21/50 HP) can discard ability cards for healing (or none)
1) Thrust(1)
2) Parry(1)
3) Lightning(1)
4) Pierce(1)
5) Focus(1)
Enter numbers [1--5] separated by comma:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa gains 10 health
Runa enters Stage 4 of Level 1
----------------------------------------
Runa (31/50 HP, 1/6 FP)
vs.
Spider King (50 HP, 0 FP): attempts Bite(1) next
----------------------------------------
Select card to play
1) Parry(1)
2) Lightning(1)
3) Pierce(1)
4) Focus(1)
Enter number [1--4]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Parry(1)
Spider King uses Bite(1)
Runa takes 3 phy. damage
----------------------------------------
Runa (28/50 HP, 1/6 FP)
vs.
Spider King (50 HP, 0 FP): attempts Block(1) next
----------------------------------------
Select card to play
1) Parry(1)
2) Lightning(1)
3) Pierce(1)
4) Focus(1)
Enter number [1--4]:"
send -- "4\r"
expect exact "4\r"
expect -exact "Runa uses Focus(1)
Spider King uses Block(1)
Runa gains 1 focus
----------------------------------------
Runa (28/50 HP, 2/6 FP)
vs.
Spider King (50 HP, 0 FP): attempts Focus(1) next
----------------------------------------
Select card to play
1) Parry(1)
2) Lightning(1)
3) Pierce(1)
4) Focus(1)
Enter number [1--4]:"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Lightning(1)
Spider King takes 16 mag. damage
Spider King uses Focus(1)
----------------------------------------
Runa (28/50 HP, 1/6 FP)
vs.
Spider King (34 HP, 0 FP): attempts Lightning(1) next
----------------------------------------
Select card to play
1) Parry(1)
2) Lightning(1)
3) Pierce(1)
4) Focus(1)
Enter number [1--4]:"
send -- "3\r"
expect exact "3\r"
expect -exact "Runa uses Pierce(1)
Enter dice roll [1--6]:"
send -- "6\r"
expect exact "6\r"
expect -exact "Spider King takes 18 phy. damage
Spider King gains 1 focus
Spider King uses Lightning(1)
Runa takes 16 mag. damage
----------------------------------------
Runa (12/50 HP, 1/6 FP)
vs.
Spider King (16 HP, 0 FP): attempts Bite(1) next
----------------------------------------
Select card to play
1) Parry(1)
2) Lightning(1)
3) Pierce(1)
4) Focus(1)
Enter number [1--4]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Parry(1)
Spider King uses Bite(1)
Runa takes 3 phy. damage
----------------------------------------
Runa (9/50 HP, 1/6 FP)
vs.
Spider King (16 HP, 0 FP): attempts Block(1) next
----------------------------------------
Select card to play
1) Parry(1)
2) Lightning(1)
3) Pierce(1)
4) Focus(1)
Enter number [1--4]:"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Lightning(1)
Spider King takes 9 mag. damage
Spider King uses Block(1)
----------------------------------------
Runa (9/50 HP, 1/6 FP)
vs.
Spider King (7 HP, 0 FP): attempts Focus(1) next
----------------------------------------
Select card to play
1) Parry(1)
2) Lightning(1)
3) Pierce(1)
4) Focus(1)
Enter number [1--4]:"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Lightning(1)
Spider King takes 9 mag. damage
Spider King dies
Runa gets Thrust(2)
Runa gets Parry(2)
Runa (9/50 HP) can discard ability cards for healing (or none)
1) Parry(1)
2) Lightning(1)
3) Pierce(1)
4) Focus(1)
5) Thrust(2)
6) Parry(2)
Enter numbers [1--6] separated by comma:"
send -- "1,2,3,4\r"
expect exact "1,2,3,4\r"
expect -exact "Runa gains 40 health
To shuffle ability cards and monsters, enter two seeds
Enter seeds [1--2147483647] separated by comma:"
send -- "42,24\r"
expect exact "42,24\r"
expect -exact "Runa enters Stage 1 of Level 2
----------------------------------------
Runa (49/50 HP, 1/6 FP)
vs.
Mushroomlon (50 HP, 0 FP): attempts Deflect(2) next
----------------------------------------
Select card to play
1) Thrust(2)
2) Parry(2)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(2)
Enter dice roll [1--6]:"
send -- "6\r"
expect exact "6\r"
expect -exact "Mushroomlon takes 26 phy. damage
Mushroomlon uses Deflect(2)
----------------------------------------
Runa (49/50 HP, 1/6 FP)
vs.
Mushroomlon (24 HP, 0 FP): attempts Scratch(2) next
----------------------------------------
Select card to play
1) Thrust(2)
2) Parry(2)
Enter number [1--2]:"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa uses Parry(2)
Mushroomlon uses Scratch(2)
----------------------------------------
Runa (49/50 HP, 1/6 FP)
vs.
Mushroomlon (24 HP, 0 FP): attempts Block(2) next
----------------------------------------
Select card to play
1) Thrust(2)
2) Parry(2)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(2)
Enter dice roll [1--6]:"
send -- "5\r"
expect exact "5\r"
expect -exact "Mushroomlon takes 17 phy. damage
Mushroomlon uses Block(2)
----------------------------------------
Runa (49/50 HP, 1/6 FP)
vs.
Mushroomlon (7 HP, 0 FP): attempts Deflect(2) next
----------------------------------------
Select card to play
1) Thrust(2)
2) Parry(2)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(2)
Enter dice roll [1--6]:"
send -- "5\r"
expect exact "5\r"
expect -exact "Mushroomlon takes 3 phy. damage
Mushroomlon uses Deflect(2)
----------------------------------------
Runa (49/50 HP, 1/6 FP)
vs.
Mushroomlon (4 HP, 0 FP): attempts Scratch(2) next
----------------------------------------
Select card to play
1) Thrust(2)
2) Parry(2)
Enter number [1--2]:"
send -- "1\r"
expect exact "1\r"
expect -exact "Runa uses Thrust(2)
Enter dice roll [1--6]:"
send -- "6\r"
expect exact "6\r"
expect -exact "Mushroomlon takes 26 phy. damage
Mushroomlon dies
Choose Runa's reward
1) new ability cards
2) next player dice
Enter number [1--2]:"
send -- "2\r"
expect exact "2\r"
expect -exact "Runa upgrades her die to a d8
Runa (49/50 HP) can discard ability cards for healing (or none)
1) Thrust(2)
2) Parry(2)
Enter number [1--2]:"
send -- "quit\r"
expect exact "quit\r"
expect eof
