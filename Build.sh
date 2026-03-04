#!/bin/bash
# Build DragonSpear plugin jar for Minecraft 1.21.4

# ----------------------------
# Paths (adjust if needed)
SRC="src/main/java"                     # Source code
OUT="classes"                           # Temp classes folder
JAR="DragonSpear.jar"                   # Output jar name
SPIGOT_JAR="$HOME/spigot-1.21.4.jar"   # Path to your Spigot/Paper API jar
# ----------------------------

# 1️⃣ Clean old classes
rm -rf $OUT
mkdir $OUT

# 2️⃣ Compile all Java files
find $SRC -name "*.java" > sources.txt
javac -classpath $SPIGOT_JAR -d $OUT @sources.txt

# 3️⃣ Build jar
cd $OUT
jar cvf ../$JAR *
cd ..

# 4️⃣ Add plugin.yml to jar
jar uvf $JAR -C . plugin.yml

# Done
echo "✅ DragonSpear.jar built successfully!"
