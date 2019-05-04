# Testausdokumentti

Ohjelmassa yksikkötestataan muutamia skenaarioita mahdollisista virhesyötteistä.
Testausta on suoritettu on toteutettu paljon Telegram palvelussa. 

## Yksikkötestaus
Sovelluksen heikohkon luokkarakenteen vuoksi on haastavaa mockata
tarvittavia olioita telegramin apiin yhteyttä ottavien metodien testaamiseksi.

### Sovelluslogiikka
Testit vajavaiset, testit testaavat lähinnä muutamia annettuja virheellisiä komentoja.

### DAO
Testeissä luodaan testitietokanta, joka poistetaan testien lopuksi. 
Kaikki tietokantaoperaatiot käydään testeissä läpi ja palautetut arvot palautetaan.

### Testikattavuus
Testien rivikattavuus n. 36% ja haaraumakattavuus 12%. 
Tämä ei ole tarpeeksi kattava testikattavuus ja kaipaa jatkokehitystä.

## Järjestelmätestaus
Sovelluksen järjestelmätestaus on tehty manuaalisesti käyttämällä Telegramia ja kokeilemalla asennusta eri ympäristöissä.

### Asennus ja konfigurointi
Sovellusta on testattu seuraavissa käyttöjärjestelmissä: Linux Ubuntu 18.04, Mac OS Mojave 10.14.3 ja Windows 10. 
Testauksessa sovelluksen juurihakemistossa on ollut käyttöohjeiden mukainen config.properties tiedosto.

### Toiminnallisuudet
Määrittelydokumentin toiminaallisuuksia on ajettu Telegramissa manuaalisesti.
Muutamia esimerkkejä:

#### Tapahtuman lisäys
![tapahtuman lisäys](https://github.com/jonitaajamo/ot-harjoitustyo/raw/master/dokumentaatio/kuvat/addevent.png)

#### Tapahtumien listaus
![tapahtumien listaus](https://github.com/jonitaajamo/ot-harjoitustyo/raw/master/dokumentaatio/kuvat/events.png)

#### Tapahtumaan ilmoittautuminen
![tapahtumaan ilmoittautuminen](https://github.com/jonitaajamo/ot-harjoitustyo/raw/master/dokumentaatio/kuvat/attend.png)

# Sovelluksen laatuongelmat
Sovellus voisi antaa spesifpiä virheilmoituksia ja syötteen puuttuessa kysyä sitä jälkikäteen.
Testikattavuus on heikko.
