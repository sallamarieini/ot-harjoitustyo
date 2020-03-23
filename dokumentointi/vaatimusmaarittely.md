# Alustava vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla käyttäjä voi pitää kirjaa oman henkilökohtaisen taloutensa menoista ja tuloista sekä tarkastella niitä. Useamman käyttäjän on mahdollista rekisteröityä sovellukseen.

## Käyttäjät

Sovelluksessa on alkuvaiheessa vain yhdenlaisia käyttäjiä eli tyypiltään nämä ovat tavallisia käyttäjiä. Myöhemmin sovellukseen voisi lisätä erilaisilla oikeuksilla uuden käyttäjätyypin.

## Perusversion toiminnallisuus

### Ennen kirjautumista

* uuden käyttäjätunnuksen luominen
  * tunnuksen täytyy olla uniikki ja vähintään viiden merkin pituinen, mahdollisen salasanan tulee olla vähintään kahdeksan merkkiä pitkä

* sovellukseen kirjautuminen
  * käyttäjä kirjautuu sovellukseen syöttämällä käyttäjätunnuksen ja mahdollisesti salasanan
  * jos käyttäjätunnus tai salasana on virheellinen, siitä annetaan käyttäjälle ilmoitus
  
### Kirjautumisen jälkeen

* käyttäjälle avautuu kirjautumisen jälkeen aloitusvalikko, josta hän voi
  * lisätä uuden tapahtuman
  * lisätä uuden kategorian tapahtumille
  * listata tapahtumat
  * tarkastella tapahtumia kategorian mukaan, diagrammi
  * kirjautua ulos
  
* kaikista näkymistä on mahdollista palata aloitusvalikkoon

### Jatkokehitysideoita

* uusi käyttäjätyyppi, joka voi esimerkiksi poistaa käyttäjätunnuksia
* käyttäjä voi muuttaa tietojaan, kuten salasanaa
* erilaisia visualisaatioita tuloista ja menoista
* kategorian poistaminen
