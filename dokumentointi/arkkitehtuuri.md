# Arkkitehtuurikuvaus

## Sovelluslogiikka

Alustava ohjelman eri osen suhdettava kuvaava luokka/pakkauskaavio:
![Alustava luokka/pakkauskaavio](/dokumentointi/Kuvat/AlustavaLuokkaKaavio.jpg)

## Päätoiminnallisuudet

Alla on kuvataan sovelluksen muutaman päätoiminnallisuuden toimintalogiikkaa sekvenssikaavioiden avulla.

### Käyttäjän kirjautuminen

Kun käyttäjä syöttää sovellukseen käyttäjätunnuksen ja salasanan ja klikkaa painiketta *Kirjaudu sisään*, sovelluksen kontrolli etenee seuraavasti:

![Sekvenssikaavio kirjautumisesta](/dokumentointi/Kuvat/Sekvenssikaavio1.png)

Painikkeen painamiseen reagoi tapahtumankäsittelijä, joka kutsuu *domain* pakkauksen luokan *UserLogic* metodia *logUserIn*, jolle annetaan parametreiksi käyttäjän syöttämä käyttäjätunnus ja salasana. Sovelluslogiikka selvittää tämän jälkeen *UserDao*:n avulla, onko käyttäjätunnusta olemassa ja jos on, niin käyttäjälle näytetään sovelluksen päävalikko.

### Lisää sekvenssikaavioita tulossa myöhemmin
