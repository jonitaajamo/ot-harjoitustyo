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
* Käyttöliittymästä voidaan käynnistää ja sammuttaa botti
* Voidaan tarkastella tietokannasta löytyviä tapahtumia ja poistaa/(muokata) niitä
* (Mahdollisuus muuttaa botin asetuksia)
* (Mahdollisuus käyttää sovellusta komentoriviltä)

## Toteutus
* Botti toteututetaan hyödyntämällä Telegramin APIa, Telegramin Java-kirjastoa, Mavenia ja Java FX:ää
* Tapahtumat ja osallistujat tallenetaan tietokantaan
* Erilliset tietokannat jokaiselle keskustelulle

Sulussa olevat toiminnallisuudet ovat mahdollisia jatkokehitystä varten.
