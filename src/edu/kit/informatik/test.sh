#!/usr/bin/env bash
echo "" > testOutput
expect new.exp
exec diff example_Interaction_A.txt testOutput
