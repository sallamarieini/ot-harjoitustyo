# Budjetointisovellus

Sovelluksen avulla käyttäjä voi pitää kirjaa oman henkilökohtaisen taloutensa menoista ja tuloista sekä tarkastella niitä. Useamman käyttäjän on mahdollista rekisteröityä sovellukseen.

## Huomio javan versioista

JavaFX aiheuttaa ongelmia ohjelmiston konfiguroinnin suhteen. Koodin pitäisi toimia Helsingin yliopiston tietojenkäsittelytieteen laitoksen cubbli-Linuxeissa olevalla Java:n versiolla 11.

## Dokumentaatio

[Alustava vaatimusmäärittely](/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](/dokumentointi/tyoaikakirjanpito.md)

## Komentorivitoiminnot

### Koodin suorittaminen

Koodin voi suorittaa komentoriviltä komennolla `mvn compile exec:java -Dexec.mainClass=budget.main.Main`.

### Testaus

Testit suoritetaan komennolla
`mvn test`.

Testikattavuusraportti luodaan komennolla `mvn jacoco:report`.

Testikattavuusraporttia voi tarkastella avaamalla selaimella tiedoston *target/site/jacoco/index.html*.

### Checkstyle

Tiedostossa [checkstyle.xml](/Budjetointisovellus/checkstyle.xml) kirjatut tarkistukset ovat suoritettavissa komennolla `mvn jxr:jxr checkstyle:checkstyle`.

Jos virheitä on, ne on nähtävissä avaamalla selaimessa tiedosto *target/site/checkstyle.html*.
