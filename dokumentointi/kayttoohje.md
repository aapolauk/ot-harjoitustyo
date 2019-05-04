# Käyttöohje
Lataa tiedosto [Minesweeper-1.0-SNAPSHOT.jar](https://github.com/aapolauk/ot-harjoitustyo/releases/tag/Viikko6)

## Ohjelman käynnistäminen
Ohjelman käynnistys onnistuu komennolla
```
java -jar Minesweeper-1.0-SNAPSHOT.jar
```

## Pelin aloittaminen
Sovelluksen käynnistyttyä esiin tulee näkymä:
![Aloitus Näkymä](https://user-images.githubusercontent.com/48727015/57180437-1f8a9580-6e91-11e9-9ccf-1619222eb126.PNG)

## Pelin toiminnot
Kun klikkaat hiiren vasemmalla näppäimellä ruutua jossa ei ole pommia, mutta jossain naapuri ruudussa on pommi:
![ruudun klikkaus](https://user-images.githubusercontent.com/48727015/57180596-e94e1580-6e92-11e9-986c-6b092a862fa0.PNG)

Numero kertoo kuinka monta pommia naapuriruuduissa on.

Kun naapuri ruuduissakaan ei ole pommia:
![Ei pommia](https://user-images.githubusercontent.com/48727015/57180598-efdc8d00-6e92-11e9-9f12-784c11258845.PNG)

Jos klikatussa ruudussa on pommi, niin peli loppuu:
![Peli loppu](https://user-images.githubusercontent.com/48727015/57181272-426d7780-6e9a-11e9-9bb8-392e89b4eee7.PNG)

Kun klikkaat hiiren oikealla näppäimellä, ruutu merkataan ja sitä ei voi enää painaa:

![merkkaus](https://user-images.githubusercontent.com/48727015/57181297-78aaf700-6e9a-11e9-9a3c-c4214cae6561.PNG)

Merkkaus voidaan poistaa painamalla hiiren oikeata näppäintä ruudun kohdalla uudestaan.

Kun pommeja sisältäviä ruutuja ei enää ole, niin peli loppuu:
![Voitto](https://user-images.githubusercontent.com/48727015/57181395-b8bea980-6e9b-11e9-9759-d646672b4baf.PNG)

Vasemmassa yläkulmassa oleavasta napista voi aloittaa uuden pelin.
