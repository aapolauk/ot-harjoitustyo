# Arkkitehtuurikuvaus
## Rakenne
Ohjelmassa on kaksi pakkausta. Pakkaus *domain* sisältää sovelluslogiikan ja pakkaus *gui* sisältää JavaFX:llä toteutetun graafisen käyttöliittymän.

## Sovelluslogiikka
Luokat *AppLogic* ja *Tile* muodostavat sovelluksen loogiikan:
![Luokkakaavio](https://user-images.githubusercontent.com/48727015/56224551-74987000-6078-11e9-9390-5d702256bec9.PNG)

## Toiminnallisuudet
Kaikki sovelluksen toiminnallisuudet perustuvat ruutujen klikkailuihin. Alla on sekvenssikaavio siitä kun käyttäjä klikkaa ruutua, jossa on pommi.

![Sekvenssikaavio](https://user-images.githubusercontent.com/48727015/56227458-343bf080-607e-11e9-8792-6ea40fa6d6d0.png)

Muut toiminnallisuudet ovat samankaltaisia.

## Heikkouksia ohjelman rakenteessa

Luokassa *TileUi* on  metodit _showPopUpLose_ ja _showPopUpWin_, jotka olisivat parempia luokassa *MinesweeperUi*.

Luokassa *AppLogic* on joitakin muuttujia, esim. _neighbouringBombs_, jotka olisivat kätevämpiä *Tile* luokassa.
