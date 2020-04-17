# Alustava vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla käyttäjä voi pitää kirjaa oman henkilökohtaisen taloutensa menoista ja tuloista sekä tarkastella niitä. Useamman käyttäjän on mahdollista rekisteröityä sovellukseen.

## Käyttäjät

Sovelluksessa on alkuvaiheessa vain yhdenlaisia käyttäjiä eli tyypiltään nämä ovat tavallisia käyttäjiä. Myöhemmin sovellukseen voisi lisätä erilaisilla oikeuksilla uuden käyttäjätyypin.

## Perusversion toiminnallisuus

### Ennen kirjautumista

* uuden käyttäjätunnuksen luominen (tehty, alakohtaa ei tehty)
  * tunnuksen täytyy olla uniikki ja vähintään viiden merkin pituinen, mahdollisen salasanan tulee olla vähintään kahdeksan merkkiä pitkä

* sovellukseen kirjautuminen (tehty)
  * käyttäjä kirjautuu sovellukseen syöttämällä käyttäjätunnuksen ja mahdollisesti salasanan (tehty)
  * jos käyttäjätunnus tai salasana on virheellinen, siitä annetaan käyttäjälle ilmoitus (tehty)
  
### Kirjautumisen jälkeen

* käyttäjälle avautuu kirjautumisen jälkeen aloitusvalikko, josta hän voi
  * lisätä uuden tapahtuman (tehty)
  * lisätä uuden kategorian tapahtumille
  * listata tapahtumat (tehty, hyvin perus versio)
  * tarkastella tapahtumia kategorian mukaan, diagrammi
  * tarkastella tuloja ja menoja, diagrammi (tehty)
  * kirjautua ulos (tehty, tässä tosin bugeja)
  
* kaikista näkymistä on mahdollista palata aloitusvalikkoon

## Jatkokehitysideoita

* uusi käyttäjätyyppi, joka voi esimerkiksi poistaa käyttäjätunnuksia
* käyttäjä voi muuttaa tietojaan, kuten salasanaa
* erilaisia visualisaatioita tuloista ja menoista
* kategorian poistaminen
