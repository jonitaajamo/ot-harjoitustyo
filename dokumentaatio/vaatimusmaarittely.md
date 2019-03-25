# Vaatimusmäärittely

 Telegram tapahtumakalenteri-botti

## Sovelluksen tarkoitus

Botilla voidaan ryhmäkeskusteluissa pitää kirjaa, kuka ryhmän jäsenistä osallistuu mihinkin tapahtumaan

## Toiminnallisuuksia
* Tapahtuman lisäys
* Tapahtuman poisto
* (Tapahtuman muokkaus)
* Ilmottautuminen tapahtumaan
* (Ryhmäkeskustelun ulkopuolisen henkilön lisäys tapahtumaan)
* Tapahtuman osallistujien tarkastaminen

## Käyttöliittymä
* Sovellusta käytetään Telegramin APIn komentoja hyödyntämällä, mahdollisesti asetusten muokkaus komentoriviltä

## Toteutus
* Botti toteututetaan hyödyntämällä Telegramin APIa ja Java-kirjastoa
* Tapahtumat ja osallistujat tallenetaan tietokantaan
* Erilliset tietokannat jokaiselle keskustelulle
