# Miinaharava

Soveluksella on tarkoitus pelata miinaharavaa.

## Dokumentaatio

[Arkkitehtuuri](https://github.com/aapolauk/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/aapolauk/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/aapolauk/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

## Releaset

[Viikko 5](https://github.com/aapolauk/ot-harjoitustyo/releases/tag/Viikko5)

## Komentorivitoiminnot

### Testaus

Testit voidaan suoritaa komennolla

```
mvn test
```

Testikattavuusraportti voidaan luoda komennolla

```
mvn jacoco:report
```

### Checkstyle

Checkstylen määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

### Suoritettavan jar-tiedoston generointi

Jar-tiedosto generoituu komennolla

```
mvn package
```
generoi hakemoistoon _target_ jar-tiedoston _Minesweeper-1.0-SNAPSHOT.jar_
