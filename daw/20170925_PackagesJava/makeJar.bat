
rem == esborrem l'antic jar 
del HolaMon.jar

rem ==== ens movem a la carpeta arrel de les classes =======
cd classes

rem                                                   <nom jar>   <nom class amb main()>   <llista de classes! ....................................>
"C:\Program Files\Java\jdk1.8.0_20\bin\jar.exe" -cvfe HolaMon.jar edu.iesmila.p1.HolaMon .\edu\iesmila\p1\*.class

rem movemn el jar a la carpeta anterior
mv HolaMon.jar ..

pause
