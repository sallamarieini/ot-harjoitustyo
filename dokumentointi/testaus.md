# Testausdokumentti

Ohjelmaa on testattu niin automatisoiduin yksikkö- ja integraatiotestein JUnitilla kuin manuaalisestikin järjestelmätason testeillä.

## Yksikkö- ja integraatiotestaus

# Sovelluslogiikka

Sovelluslogiikkaa testaavat käytännössä testiluokat *CategoryLogicTest*, *EventLogicTest* ja *UserLogicTest*. Kyseiset testiluokat hyödyntävät integraatiotesteissä DAO-rajapintoja mukailevia keskusmuistitoteutuksia. Testit pyrkivät simuloimaan käyttöliittymällä suoritettavia toiminnallisuuksia.

# DAO-luokat

Kaikkia kolmea DAO-luokkaa on testattu luomalla testien yhteydessä väliaikainen tietokanta niin, että on käytetty hyväksi JUnitin TemporaryFolder-ruleja.

# Testauskattavuus

Käyttöliittymä on jätetty testauskattavuuden ulkopuolelle, joten sitä lukuunottamatta sovelluksen testien rivikattavuus on 94 % ja haarautumiskattavuus 97 %. Testaamatta jäivät lähinnä tilanteet, joissa tietokanta heittää SQL-poikkeuksen.
