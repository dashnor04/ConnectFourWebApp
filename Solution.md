SPW4 - Project 
=================

Name: Dashnor Spahiu

Effort in hours: 15

# Connect Four

## Lösungsidee

### Task A

Angefangen bei der Angabe habe ich die Board-Klasse implementiert. Diese 
Klasse ist für das Spielfeld zuständig. Sie enthält ein 2D Array, welches
die Positionen der Steine speichert. Anfangs habe ich für den Datentyp Integer 
verwendet, jedoch erschien mir ein Enum besser geeignet, da sich so die 
Leserlichkeit des Codes erhöht hat und mir die Implementierung von Klassen die Board-Klasse verwenden beziehungsweise eine Instanz davon 
(ConnectFour-Klasse) nutzen, deutlich vereinfacht hat. Mir war Leserlichkeit des Codes bei der 
Implementierung wichtiger als Performance, da es sich um eine kleine Applikation 
handelt. Die Board-Klasse besitzt Methoden, um die Steine zu setzen, Getter und 
Setter für die jeweilige Position im Array sowie die Überladene toString Methode 
um im weiteren (ConnectFourServlet-Klasse) die Ausgabe zu vereinfachen. Das 
Color Enum besitzt die Werte RED, YELLOW und BLANK. Das Feld wird mit dem 
BLANK enum initialisiert, welche in der toString Methode als leeren String 
ausgegeben wird, welches in der Ausgabe ein white-Token, also als weißer Stein 
dargestellt wird.

Die ConnectFour-Klasse ist für die Spiellogik zuständig. Die privaten Datenkomponenten sind die Board-Klassen Instanz, 
welche das Spielfeld repräsentiert. Außerdem werden die Spieler als Player-Objekte gespeichert und die Maße des Spielfeldes.
Die privaten Datenkomponenten werden mit Setter und Getter gesetzt und ausgelesen. Außerdem besitzt die Klasse Methoden
zum Überprüfen, ob ein Spieler gewonnen hat, ob das Spielfeld voll ist und ob ein Spieler einen Stein setzen kann. Die 
Methode checkWinner() überprüft, ob ein Spieler gewonnen hat. Dazu wird das Spielfeld nach vier gleichen Steinen in einer
Reihe, Spalte oder Diagonale überprüft. Die Methode checkFull() überprüft, ob das Spielfeld voll ist. Dazu wird das Spielfeld
nach leeren Feldern überprüft. 

### Task B
Um so viel Funktionalität wie möglich zu testen habe ich die Methode so atomar wie möglich gemacht. In der BoardTest
Klasse wird vor allem die drop Methode getestet, außerdem die toString Methode sowie getter, getter und constructor.
PlayerTest testet den setter und getter sowie den constructor. In der ConnectFourTest Klasse wird die ganze Spiellogik
getestet. Jede Richtung, in der ein Spieler gewinnen kann, wird getestet sowie der Constructor, Initialize, toString 
und isOver.

### Task C
Die Klasse ConnectFourServlet ist für die Kommunikation zwischen Client und Server zuständig. Die Klasse erbt von der 
HttpServlet-Klasse von der die init, doGet und doPost Methoden überschrieben werden. Die doGet Methode behandelt 
get-requests und die doPost Methode post-requests. Die init Methode ruft den Constructor sowie die Methode initialize
der ConnectFour-Klasse auf, um das Spielboard mit "leeren" Steinen zu befüllen. Die doGet Methode erzeugt eine neue 
Instanz des Spiels, wenn der RestartButton gedrückt wird und dem Spieler wird wieder die Farbauswahl angezeigt. Die 
doPost Methode ist für das Setzen der Steine auf dem Spielboard zuständig. Dabei nimmt die Methode als Input die 
Reihe die durch den "+" button ausgewählt und versucht dann in der Spielinstanz in der ConnectFourServlet den Stein 
zu setzen. In jedem Fall wird die Board-Instanz der ConnectFour Klasse zurückgegeben zur Darstellung.


### Task D
