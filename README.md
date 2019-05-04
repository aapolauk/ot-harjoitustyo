# Miinaharava

Sovelluksella on tarkoitus pelata miinaharavaa. Pelin tarkoitus on selvittää ruudut joissa on miina. Nämä ruudut pelaaja voi merkitä klikkaamalla hiiren oikealla näppäimellä. Ruutuja voi avata hiiren vasemmalla näppäimellä. Ruudussa oleva luku kertoo naapuriruuduissa olevien miinojen määrän ja tämän avulla pelaajan on tarkoitus päätellä missä miinat sijaitsevat.

## Dokumentaatio

[Arkkitehtuuri](https://github.com/aapolauk/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Käyttöohje](https://github.com/aapolauk/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

[Testaus](https://github.com/aapolauk/ot-harjoitustyo/blob/master/dokumentointi/testaus.md)

[Työaikakirjanpito](https://github.com/aapolauk/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/aapolauk/ot-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

## Releaset

[Viikko 5](https://github.com/aapolauk/ot-harjoitustyo/releases/tag/Viikko5)

[Viikko 6](https://github.com/aapolauk/ot-harjoitustyo/releases/tag/Viikko6)

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

### JavaDoc

JavaDoc generoituu komennolla

```
mvn javadoc:javadoc
```
JavaDoc löytyy hakemistosta _target/site/apidocs/index.html_


