# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla käyttäjä voi pitää kirjaa oman henkilökohtaisen taloutensa menoista ja tuloista sekä tarkastella niitä. Useamman käyttäjän on mahdollista rekisteröityä sovellukseen.

## Käyttäjät

Sovelluksessa on alkuvaiheessa vain yhdenlaisia käyttäjiä eli tyypiltään nämä ovat tavallisia käyttäjiä. Myöhemmin sovellukseen voisi lisätä erilaisilla oikeuksilla uuden käyttäjätyypin.

## Käyttöliittymäluonnos

Sovellus koostuu useista eri näkymistä.

![Käyttöliittymäluonnos](/dokumentointi/Kuvat/Kayttoliittyma.png)

Sovellus aukeaa kirjautumisnäkymään. Kirjautumisnäkymästä on mahdollisuus siirtyä luomaan uusi käyttäjätunnus tai kirjautua sisään ja siirtyä päävalikkoon.

## Perusversion toiminnallisuus

### Ennen kirjautumista

* uuden käyttäjätunnuksen luominen
  * tunnuksen täytyy olla uniikki ja vähintään kolmen merkin pituinen, mahdollisen salasanan tulee olla vähintään kolme merkkiä pitkä

* sovellukseen kirjautuminen
  * käyttäjä kirjautuu sovellukseen syöttämällä käyttäjätunnuksen ja salasanan
  * jos käyttäjätunnus tai salasana on virheellinen, siitä annetaan käyttäjälle ilmoitus
  
### Kirjautumisen jälkeen

* käyttäjälle avautuu kirjautumisen jälkeen päävalikko, josta hän voi
  * lisätä uuden tapahtuman
  * listata kaikki tapahtumat
  * tarkastella tapahtumia kategorian mukaan
  * tarkastella tuloja ja menoja
  * kirjautua ulos
  
* kaikista näkymistä on mahdollista palata päävalikkoon

## Jatkokehitysideoita

* uusi käyttäjätyyppi, joka voi esimerkiksi poistaa käyttäjätunnuksia
* käyttäjä voi muuttaa tietojaan, kuten salasanaa
* päävalikossa nähtävissä, kuka sillä hetkellä on kirjautunut sisään sovellukseen
* erilaisia visualisaatioita tuloista ja menoista
* uuden kategorian lisääminen
* kategorian poistaminen
* tapahtuman muokkaaminen
* tapahtuman poistaminen
