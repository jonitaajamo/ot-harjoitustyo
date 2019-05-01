# Arkkitehtuuri

## Rakenne ja sovelluslogiikka
Koodin pakkausrakenne:
![pakkauskaavio](https://github.com/jonitaajamo/ot-harjoitustyo/raw/master/dokumentaatio/kuvat/pakkauskaavio.png)

Pakkaus telegrameventbot.ui sisältää JavaFX:llä toteutetun kevyen käyttöliittymän. telegrameventbot.domain sovelluslogiikan ja telegrameventbot.dao tietojen tallennuksesta tietokantaan vastaavan logiikan.

## Käyttöliittymä
Sovellus avaa käynnistyessään paikallisen käyttöliittymän, josta selviää, onko Telegramin jakama token luettu onnistuneesti tiedostosta. Varsinainen käyttö tapahtuu Telegram palvelussa lähettämällä botille viestejä eli "komentoja". 

Mahdolliset komennot ovat:

/addevent

/attend

/events

/attending

Sovellus käynnistyy luokassa ui.TelegramEventBotUi, jossa luetaan token ja username, jotka ovat tallennettu tiedostoon config.properties. 
Komennot luetaan luokassa domain.TelegramEventBot, josta oikein muotoillut komennot käsitellään ja mahdollinen data tallennetaan tietokantaan dao.TelegramEventBotDao luokkaa kutsumalla. 

## Sekvenssikaavio tapahtuman lisäämisestä
![sekvenssikaavio](https://github.com/jonitaajamo/ot-harjoitustyo/raw/master/dokumentaatio/kuvat/sekvenssikaavio.png)

## Tietokantakaavio
Tallennettavat tiedot tallennetaan sqlite tietokantaan kahteen eri tauluun.

![tietokantakaavio](https://github.com/jonitaajamo/ot-harjoitustyo/raw/master/dokumentaatio/kuvat/tietokantakaavio.jpg)
