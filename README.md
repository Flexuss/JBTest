# JBTest
\>java DirectoryScanner

\>scan -input "C:\testin" -output "C:\testout" -mask "\*t\*t\*.txt" -waitInterval 100 -includeSubfolders true -autoDelete true

\>scan -input "C:\testin" -output "C:\testout" -mask "\*t\*.\*x\*" -waitInterval 100 -includeSubfolders true -autoDelete false

\>stop 1 

\>exit  

Выполнены дополнительные задания 1 и 2. 

Возможен запуск нескольких сканеров подряд каждый работает в своем потоке. 

При вводе "stop int" программа останавливает поток с номером int.

При вводе "exit" программа выключается. 
