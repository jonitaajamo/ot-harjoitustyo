# Ohjelmistotekniikka

## Telegram tapahtumakalenteri-botti

### Dokumentaatio

* [vaatimusmäärittely](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)
* [arkkitehtuuri](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)
* [työaikakirjanpito](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)
* [käyttöohjeet](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohjeet.md)
* [testausdokumentti](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)

### Releaset

* [release viikko 5](https://github.com/jonitaajamo/ot-harjoitustyo/releases/tag/viikko5)
* [release viikko 6](https://github.com/jonitaajamo/ot-harjoitustyo/releases/tag/viikko6)

## Komentorivitoiminnot

#### Testaus

Testit voidaan suorittaa komennolla:

```
mvn test
```

Testikattavuusraportti voidaan luoda komennolla:

```
mvn jacoco:report
```

Genereoitua raporttia voidaan tarkastella avaamalla tiedoston _target/site/jacoco/index.html_ selaimessa.

#### Suoritettavan jarin generointi

Komento

```
mvn package
```

luo hakemistoon _target_ suoritettavan jar-tiedoston _TelegramEventBot-1.0-SNAPSHOT-shaded.jar_

#### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/TelegramEventBot/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Tyyleissä olevat virheet selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

#### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voidaan tarkastella avaamalla tiedosto _target/site/apidocs/index.html_ selaimessa
