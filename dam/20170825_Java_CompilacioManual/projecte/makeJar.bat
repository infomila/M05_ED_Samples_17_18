

@set PATH="C:\Program Files\Java\jdk1.8.0_20\bin\";%PATH%
rem ============================================

del *.jar

cd classes

jar -cvfe HolaMon.jar edu.iesmila.p1.HolaMon edu\iesmila\p1\*.class

mv *.jar ..
pause
