# Ohjelmistotekniikka

## Telegram tapahtumakalenteri-botti

### Dokumentaatio

* [vaatimusmäärittely](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)
* [arkkitehtuuri](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)
* [työaikakirjanpito](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)
* [käyttöohjeet](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohjetet.md)

### Releaset

* [release viikko 5](https://github.com/jonitaajamo/ot-harjoitustyo/releases/tag/viikko5)
* [release viikko 6](https://github.com/jonitaajamo/ot-harjoitustyo/releases/tag/viikko6)

## Komentorivitoiminnot

#### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

#### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _TelegramEventBot-1.0-SNAPSHOT-shaded.jar_

#### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/jonitaajamo/ot-harjoitustyo/blob/master/TelegramEventBot/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

#### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_
