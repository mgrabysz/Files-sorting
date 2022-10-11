## Files
Zadanie rekrutacyjne polegające na napisaniu programu segregującego pliki .jar oraz .xml.

## Uruchamianie aplikacji
### Uruchamianie z użyciem skonfigurowanego IDE
Jeżeli posiadamy odpowiednie zintegrowane środowisko obsługujące projekty Maven (np. Intellij) możemy otworzyć projekt za jego pomocą. Wówczas do uruchomienia aplikacji wystarczy kliknięcie przycisku "Run".

### Uruchamianie poza środowiskiem
Do uruchomienia aplikacji należy mieć zainstalowane narzędzia JDK oraz Maven. Po rozpakowaniu projektu uruchamiamy terminal i wchodzimy w główny folder o nazwie Files. Aplikację kompilujemy i uruchamiamy z wiersza poleceń następującym zestawem komend:
```shell
mvn clean package
java -cp .\target\Files-1.0-SNAPSHOT.jar .\src\main\java\pl\marcin\Main.java
```

## Używanie aplikacji
W folderze Files znajduje się folder ExampleFiles z przykładowymi pustymi plikami .jar oraz .xml. Po uruchomieniu aplikacji możemy te pliki przenosić do folderu HOME (np. przeciągając je myszką) i obserwować komunikaty na konsoli. Każde przeniesienie pliku powoduje wyświetlenie się odpowiedniego komunikatu oraz aktualizację pliku count.txt znajdującego się w folderze HOME.

Działanie programu przerywamy, klikając "stop" (IDE) lub ctrl+C (konsola).
