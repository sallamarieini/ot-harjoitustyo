# Budjetointisovellus

Sovelluksen avulla käyttäjä voi pitää kirjaa oman henkilökohtaisen taloutensa menoista ja tuloista sekä tarkastella niitä. Useamman käyttäjän on mahdollista rekisteröityä sovellukseen.

## Dokumentaatio

[Käyttöohje](/dokumentointi/kayttoohje.md)

[Vaatimusmäärittely](/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](/dokumentointi/arkkitehtuuri.md)

[Testausdokumentti](/dokumentointi/testaus.md)

[Työaikakirjanpito](/dokumentointi/tyoaikakirjanpito.md)

## Releaset

[Viikko 5](https://github.com/sallamarieini/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/sallamarieini/ot-harjoitustyo/releases/tag/viikko6)

[Loppupalautus](https://github.com/sallamarieini/ot-harjoitustyo/releases/tag/loppupalautus)

## Komentorivitoiminnot

### Koodin suorittaminen

Koodin voi suorittaa komentoriviltä komennolla `mvn compile exec:java -Dexec.mainClass=budget.main.Main`.

### Testaus

Testit suoritetaan komennolla
`mvn test`.

Testikattavuusraportti luodaan komennolla `mvn jacoco:report`.

Testikattavuusraporttia voi tarkastella avaamalla selaimella tiedoston *target/site/jacoco/index.html*.

### Suoritettavan jarin generointi

Jar on mahdollista generoida komennolla `mvn package`.

Kyseinen komento generoi suoritettavan jar-tiedoston hakemistoon *target* nimellä *Budjetointisovellus-1.0-SNAPSHOT.jar*.
Ohjelma on suoritettavissa komennolla `java -jar Budjetointisovellus-1.0-SNAPSHOT.jar`.

### JavaDoc

JavaDoc on generoitavissa komennolla `mvn javadoc:javadoc`. JavaDocia voi tarkastella selaimella avaamalla tiedoston *target/site/apidocs/index.html*.

### Checkstyle

Tiedostossa [checkstyle.xml](/Budjetointisovellus/checkstyle.xml) kirjatut tarkistukset ovat suoritettavissa komennolla `mvn jxr:jxr checkstyle:checkstyle`.

Jos virheitä on, ne on nähtävissä avaamalla selaimessa tiedosto *target/site/checkstyle.html*.
