# Käyttöohje

Lataa tiedosto [Budjetointisovellus.jar]() ja tiedostot *config.properties* ja *categories.txt*.

## Konfigurointi

Ohjelma olettaa, että sen käynnistyshakemistossa on tiedostot *config.properties* ja *categories.txt*. Tiedosto *config.properties* määrittelee sovelluksen käyttämän tietokannan nimen. Kun sovellus käynnistetään, sovellus luo tiedostossa määritellyn nimisen tietokannan, jos tietokantaa ei ole jo luotu. Oletuksena tietokannan nimeksi on määritelty *budget.db*.
Tiedosto *categories.txt* määrittelee tietokantaan kategoriat.

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla `java -jar xxx`.

## Rekisteröityminen

Kirjautumisnäkymän yläosassa on nappi *Luo uusi käyttäjätunnus*, jota painamalla esiin vaihtuu näkymä, jossa voi luoda uuden käyttäjän. Uusi käyttäjä luodaan syöttämällä pyydetyt tiedot kenttiin ja painamalla sitten nappia *Luo käyttäjätunnus*.

![Rekisteröidy](/dokumentointi/Kuvat/kayttoohje/Rekisteroidy.png)

Jos käyttäjätunnus luotiin onnistuneesti, ilmestyy ikkunaan teksti *Rekisteröityminen onnistui*. Takaisin kirjautumisnäkymään pääsee klikkaamalla nappia *Takaisin*.

## Kirjautuminen

Sovellus käynnistyy näkymään, josta voi kirjautua sisälle.

![Kirjaudu](/dokumentointi/Kuvat/kayttoohje/Kirjaudu.png)

Kirjautuminen tapahtuu kirjoittamalla kenttään *Käyttäjätunnus* oma käyttäjätunnus ja kenttään *Salasana* käyttäjätunnukseen liittyvä salasana. Onnistuneen kirjautumisen jälkeen näkymä vaihtuu.

## Päävalikko

Kirjautumisen jälkeen näkymä vaihtuu *päävalikoksi*.

![Päävalikko](/dokumentointi/Kuvat/kayttoohje/Paavalikko.png)

Tässä näkymässä käyttäjä voi valita valitsemansa toiminnon tai kirjautua ulos sovelluksesta. Kun käyttäjä kirjautuu ulos sovelluksesta, näkymä vaihtuu kirjautumisnäkymäksi.

## Lisää uusi tapahtuma

Kun päänäkymästä painaa nappia *Lisää uusi tapahtuma*, sovellus avaa uuden ikkunan, jossa käyttäjä voi lisätä uuden tapahtuman.

![Lisää tapahtuma](/dokumentointi/Kuvat/kayttoohje/LisaaTapahtuma.png)

Syöttämällä pyydetyt tiedot ja painamalla *Lisää tapahtuma* painiketta käyttäjä voi lisätä tapahtuman. Jos rahasumman syöttää desimaalilukuna, tulee desimaalierottimen olla piste. Näkymästä voi poistua sulkemalla ikkunan oikean ylänurkan x-painikkeella.

## Näytä kaikki tapahtumat

Päänäkymän *Näytä kaikki tapahtumat* painike avaa uuden ikkunan, jossa on lista käyttäjän sovellukseen syöttämistä tapahtumista.

![Kaikki tapahtumat](/dokumentointi/Kuvat/kayttoohje/Tapahtumat.png)

Tapahtumat on esitetty muodossa *päivämäärä, kategoria, tyyppi (tulo/meno), rahasumma*. Näkymästä voi poistua sulkemalla ikkunan.

## Tulojen ja menojen vertailu

Päänäkymän painike *Vertaile tuloja ja menoja* avaa ikkunan, jossa tulot ja menot on esitetty visuaalisesti pylväsdiagrammina. Lisäksi ikkunan yläosassa on laskettu tulojen ja menojen erotus; negatiivinen luku ilmaisee, että menoja on enemmän kuin tuloja. Näkymästä voi poistua sulkemalla ikkunan.

![Tulot ja menot](/dokumentointi/Kuvat/kayttoohje/TulotMenot.png)

## Tulojen ja menojen vertailu kategorioittain

Päänäkymän painikkeen *Tulot ja menot kategorioittain* avaa näkymän, jossa tulot ja menot on esitetty kategorioittain pylväsdiagrammina. Tuloja ja menoja kuvastavat pylväät ovat erivärisiä. Näkymästä voi poistua sulkemalla ikkunan.

![Tulot ja menot kategorioittain](/dokumentointi/Kuvat/kayttoohje/Kategoriat.png)
