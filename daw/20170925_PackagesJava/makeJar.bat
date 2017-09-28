


@set PATH="C:\Program Files\Java\jdk1.8.0_20\bin\";%PATH%
rem ============================================


rem == esborrem l'antic jar 
del HolaMon.jar

rem ==== ens movem a la carpeta arrel de les classes =======
cd classes

rem       <nom jar>   <nom class amb main()>   <llista de classes! ....................................>
jar -cvfe HolaMon.jar edu.iesmila.p1.HolaMon .\edu\iesmila\p1\*.class

rem movemn el jar a la carpeta anterior
mv HolaMon.jar ..\HolaMon.jar

pause
