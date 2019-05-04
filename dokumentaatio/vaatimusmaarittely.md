# Vaatimusmäärittely

Telegram tapahtumakalenteri-botti

## Sovelluksen tarkoitus

Botilla voidaan ryhmäkeskusteluissa pitää kirjaa, kuka ryhmän jäsenistä osallistuu mihinkin tapahtumaan

## Toteutettuja toiminnallisuuksia

* Tapahtuman lisäys
* Ryhmäkeskustelun ulkopuolisen henkilön lisäys tapahtumaan
* Tapahtuman osallistujien tarkastaminen
* Yhden keskustelun tai ryhmän käyttäjät voivat tarkastella vain oman ryhmänsä tapahtumia 

### Käyttöliittymä
* Käyttöliittymä näyttää botin tunnukset

## Toteutus
* Botti toteututetaan hyödyntämällä Telegramin APIa, Telegramin Java-kirjastoa, Mavenia ja Java FX:ää
* Tapahtumat ja osallistujat tallennetaan tietokantaan

## Jatkokehitysideoita 
* Tapahtuman muokkaus
* Ilmottautuminen tapahtumaan
* Keskustelumaisempi tapahtumien lisäys
* Tapahtuman poisto tai automaattinen poistuminen tapahtumapäivän jälkeen
* Sovellus voidaan suorittaa komentoriviltä parametreillä vain komentoriviohjelmana serverillä suorittamista varten
