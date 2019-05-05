# Käyttöohjeet

## Vaatimukset
* Ubuntu 18/Windows 10/Mac OS Mojave, Java 8
* Telegram käyttäjä

## Käyttöönotto

* Lataa sovellus [TelegramEventBot.jar](https://github.com/jonitaajamo/ot-harjoitustyo/releases/download/viikko5/TelegramEventBot.jar)

## Konfigurointi

* Testaamista varten tulee rekisteröidä uusi botti Telegramin bot APIin lähettämällä BotFatherille viestin `/newbot` osoitteessa https://telegram.me/botfather ja vastaamalla kysymyksiin
* Kun botti on luotu, saat BotFatherilta tokenin ja valitsemasi käyttäjänimen
* Luo ohjelman suoritushakemistoon (samaan hakemistoon kuin .jar tiedosto) tiedosto config.properties, joka on muotoa: 


apiKey=[apiKey telegramin bot fatherilta]

username=[botin käyttäjänimi bot fatherilta]

## Ohjelman käynnistäminen

* Käynnistä ohjelma komennolla ´java -jar TelegramEventBot.jar´

## Ohjelman käyttäminen

* Ohjelma yhdistyy käynnistäessä luomaasi bottiin Telegramin apissa ja näyttää tokenisi ja käyttäjänimesi käyttöliittymässä
* Voit testata komentoja ottamalla yhteyttä luomaasi bottiin Telegramissa

### Tapahtuman luonti

Tapahtuman luonti tapahtuu lähettämällä Telegramissa viestin /addevent [nimi] [dd.mm.yyyy]. Luonnin onnistuessa botti vastaa onnistumisviestillä.

### Tapahtumaan ilmoittautuminen

Tapahtumaan ilmoittaudutaan lähettämällä viesti /attend [tapahtuman nimi] [käyttäjänimi]

### Komentojen listaus
Kaikki mahdolliset komennot saat botilta komennolla /commands
