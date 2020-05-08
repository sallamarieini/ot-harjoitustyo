# Testausdokumentti

Ohjelmaa on testattu niin automatisoiduin yksikkö- ja integraatiotestein JUnitilla kuin manuaalisestikin järjestelmätason testeillä.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Sovelluslogiikkaa testaavat käytännössä testiluokat *CategoryLogicTest*, *EventLogicTest* ja *UserLogicTest*. Kyseiset testiluokat hyödyntävät integraatiotesteissä DAO-rajapintoja mukailevia keskusmuistitoteutuksia. Testit pyrkivät simuloimaan käyttöliittymällä suoritettavia toiminnallisuuksia.

### DAO-luokat

Kaikkia kolmea DAO-luokkaa on testattu luomalla testien yhteydessä väliaikainen tietokanta niin, että on käytetty hyväksi JUnitin TemporaryFolder-ruleja.

### Testauskattavuus

Käyttöliittymä on jätetty testauskattavuuden ulkopuolelle, joten sitä lukuunottamatta sovelluksen testien rivikattavuus on 94 % ja haarautumiskattavuus 97 %. Testaamatta jäivät pääasiasiassa ne tilanteet, joissa tietokanta heittää SQL-poikkeuksen.

![Testikattavuus](/dokumentointi/Kuvat/Testikattavuus.png)

## Järjestelmätestaus

Järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on otettu käyttöön ja sitä on testattu [käyttöohjeen](/dokumentointi/kayttoohje.md) mukaisesti Linux-ympäristössä niin, että sovelluksen käynnistämishakemistossa ovat olleet tiedostot *config.properties* ja *categories.txt*.

Sovellusta on testattus luomalla käyttäjiä ja tapahtumia käyttöliittymässä. Testejä on suoritettu niin, että tietokantaa ei ole olemassa valmiiksi ja myös niin, että se on jo olemassa.

### Toiminnallisuudet

[Määrittelydokumentin](/dokumentointi/vaatimusmaarittely.md) toiminnallisuudet on testattu läpi. Syötekenttiin on yritetty testeissä syöttää monenlaista tietoa, myös vääränlaista.

## Sovellukseen jääneet laatuongelmat

Testit eivät kata tilanteita, joissa tietokanta heittää poikkeuksen, jolloin tietokannan vioittuessa sovelluksen käytössä voi esiintyä ongelmia, joita ei ole otettu huomioon. Sovellukseen kirjautumisen jälkeen käyttäjä ei pysty näkemään, kuka on kirjautunut sisään, mikä voi osoittautua sovelluksen käyttäjälle ongelmalliseksi.
