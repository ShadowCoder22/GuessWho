#!/bin/bash

mkdir -p bin/main/java
javac -d bin/main/java src/main/java/com/shadowcoder/ai/*.java src/main/java/com/shadowcoder/ui/*.java src/main/java/com/shadowcoder/theme/*.java
cd src/main/java/
jar -cvfe GuessWho.jar com/shadowcoder/ui/MainFrame com/shadowcoder/ai/*.class com/shadowcoder/ui/*.class com/shadowcoder/theme/*.class
