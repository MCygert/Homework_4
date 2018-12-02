# Homework 4

Wykorzystaj projekt dostępny w folderze ```Homework_4/``` - zaimportuj plik ```pom.xml```.

1. Uzupełnij ciało metody ```GradeService.calculateAverage``` tak, aby wszystkie testy w ```GradeServiceTest``` pomyślnie się wykonywały.

2. Jakiekolwiek zmiany w ```GradeServiceTest``` dyskwalifikują rozwiązanie - 0%

3. Zakładamy, że dane przekazywane do metody calculateAverage są poprawne, tj. pierwsza kolumna to imię, druga kolumna to ocena (nie musisz tego sprawdzać).

4. W przypadku parametru ```null``` lub pustej tablicy, metoda ```calculateAverage``` powinna zwrócić pustą tablicę ```[[]]```.

5. W tablicy wejściowej jak i wyjściowej wszystkie wartości są typu ```String```.

6. W przypadku duplikatów, program powinien sumować wszystkie oceny danego studenta i podawać średnią.

7. Średnia (niezależnie czy z jednej oceny, czy z kilku) powinna być podawana z dokładnością do dwóch znaków po przecinku (tj. ```3.00```, ```4.67```, itp.).

8. Dane wyjściowy powinny być posortowane wg imion.

9. Do formatowania średniej wykorzystaj klasę ```DecimalFormat```.

10. Rozwiązania (w postaci adresu do rozwiązania w GitHubie - Twoje repo) wyślij do mnie mailem na ```michal@nowakowski.me.uk``` (tytuł: ```JJDD5 - Homework 4```).
   
11. Deadline: ```poniedziałek, 03.12.2018 do 9.00```.

12. Ocenanie: każdy z testów na zielono to część oceny, do zdobycia 100%:

```shouldReturnEmptyArrayWhenInputIsNull``` - 10%

```shouldReturnEmptyArrayWhenInputIsEmpty``` - 10%

```shouldCalculateAverageGradesWhenNoDuplicates``` - 40%

```shouldCalculateAverageGradesWhenDuplicatesExist``` - 40%

13. Przykłady danych wejściowych i wyjściowych (tabele = tablica dwuwymiarowa, nagłówki (IMIĘ, OCENA) pomijamy w kodzie):

Wejście:

|IMIĘ|OCENA|
|---|---|
|Ania|5|
|Tomek|6|
|Kasia|3|
|Albert|2|

Wyjście:

|IMIĘ|OCENA|
|---|---|
|Albert|2.00|
|Ania|5.00|
|Kasia|3.00|
|Tomek|6.00|
  
--

Wejście:

|IMIĘ|OCENA|
|---|---|
|Ania|5|
|Tomek|6|
|Kasia|3|
|Albert|2|
|Ania|3|
|Tomek|1|
|Tomek|4|
|Bartek|2|


Wyjście:

|IMIĘ|OCENA|
|---|---|
|Albert|2.00|
|Ania|4.00|
|Bartek|2.00|
|Kasia|3.00|
|Tomek|3.67|
