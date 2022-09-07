## Files
Zadanie rekrutacyjne w Pretius Software Sp.z o.o.

## Uruchamianie aplikacji
### Uruchamianie z użyciem skonfigurowanego IDE
Jeżeli posiadamy odpowiednie zintegrowane środowisko obsługujące projekty Maven (np. Intellij) możemy otworzyć projekt za jego pomocą. Wówczas do uruchomienia aplikacji wystarczy kliknięcie przycisku "Run".

### Uruchamianie poza środowiskiem
Do uruchomienia aplikacji wystarczy zainstalowane JDK. Po rozpakowaniu projektu uruchamiamy terminal i wchodzimy w główny folder o nazwie Files. W folderze znajduje się uprzednio utworzony plik .jar, więc aplikację możemy uruchomić z wiersza poleceń następującą komendą:
```shell
java -cp .\target\Files-1.0-SNAPSHOT.jar .\src\main\java\pl\marcin\Main.java
```

Jeżeli dysponujemy także narzędziem Maven, projekt możemy uprzednio zbudować, rozszerzając zestaw komend w następujący sposób:
```shell
mvn clean package
java -cp .\target\Files-1.0-SNAPSHOT.jar .\src\main\java\pl\marcin\Main.java
```

## Używanie aplikacji
W folderze Files znajduje się folder ExampleFiles z przykładowymi pustymi plikami .jar oraz .xml. Po uruchomieniu aplikacji możemy te pliki przenosić do folderu HOME (np. przeciągając je myszką) i obserwować komunikaty na konsoli. Każde przeniesienie pliku powoduje wyświetlenie się odpowiedniego komunikatu oraz aktualizację pliku count.txt znajdującego się w folderze HOME.

Działanie programu przerywamy, klikając "stop" (IDE) lub ctrl+C (konsola).