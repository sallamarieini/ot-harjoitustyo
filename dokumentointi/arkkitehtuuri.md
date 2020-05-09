# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne noudattaa kolmikerroksista kerrosahkitehtuuria. Pakkauksia ovat ui, domain ja dao. Pakkaus *ui* sisältää JavaFX:llä toteutetun käyttöliittymän koodin, *domain* sovelluslogiikan koodin ja *dao* tietojen pysyväistallennukseen liittyvän koodin. Ohjelman pakkausrakenne on seuraava:

![Pakkauskaavio](/dokumentointi/Kuvat/Pakkauskaavio.png)

## Käyttöliittymä

Käyttöliittymä sisältää useita erilaisia näkymiä:
* Kirjautuminen
* Rekisteröityminen
* Päävalikko
* Uuden tapahtuman lisäämiseen liittyvä näkymä
* Tapahtumat listaava näkymä
* Tulojen ja menojen vertailuun liittyvä näkymä
* Tulojen ja menojen vertailuun kategorioittain liittyvä näkymä

Näkymät on toteutettu omina Scene-olioina ja lisäksi omina luokkina kirjautumista ja rekisteröitymistä lukuun ottamatta: ne on toteutettu samassa luokassa. Kirjautuminen, rekisteröityminen ja päävalikko asetetaan Stage-olioon niin, että nämä ovat näkyvissä yksitellen. Päävalikosta näkymiin siirryttäessä (pl. "Kirjaudu ulos") avautuu uusi ikkuna. Nämä on asetettu toiseen Stage-olioon. Ohjelmallisesti käyttöliittymä on rakennettu luokassa *Budjetointisovellus.ui.BudjetointisovellusUi*.

## Sovelluslogiikka

Alla on kuvattu ohjelman eri osen suhdettava kuvaava luokka/pakkauskaavio:

![Luokka/pakkauskaavio](/dokumentointi/Kuvat/Luokkakaavio.png)

Sovelluksen loogisen datamallin muodostavat luokat *Event*, *Category* ja *User*. Event kuvaa tapahtumaa, Category tapahtuman kategoriaa ja User sovelluksen käyttäjää. Luokat *EventLogic*, *CategoryLogic* ja *UserLogic* vastaavat sovelluksen toiminnallisuuksista.

Luokat *EventLogic*, *CategoryLogic* ja *UserLogic* pääsevät käsiksi tapahtumien, kategorioiden ja käyttäjien tietoihin rajapintojen *EventDao*, *CategoryDao* ja *UserDao* toteuttavien luokkien kautta. Luokkien toteutus injektoidaan sovelluslogiikalle konstruktorissa.

## Tietojen pysyväistallennus

Sovelluksen tietojen pysyväistallennus on toteutettu sqlite-tietokantana. Tietokanta luodaan luokassa *DbDao*, joka sijaitsee *Dao*-pakkauksessa. Tietokantaa käyttävät luokat on rajapintojen takana, joten sovelluslogiikka ei käytä näitä luokkia suoraan. DAO-suunnittelumalli mahdollistaa sovelluksen tallennustavan joustavat muutokset.

Sovelluslogiikkaa testattaessa tätä on hyödynnetty siten, että tietoja ei talleteta tietokantaan. Testeissä siis hyödynnetään toteutuksia, jotka tallettavat tietoa keskusmuistiin.

## Päätoiminnallisuudet

Alla on kuvataan sovelluksen muutaman päätoiminnallisuuden toimintalogiikkaa sekvenssikaavioiden avulla.

### Käyttäjän kirjautuminen

Kun käyttäjä syöttää sovellukseen käyttäjätunnuksen ja salasanan ja klikkaa painiketta *Kirjaudu sisään*, sovelluksen kontrolli etenee seuraavasti:

![Sekvenssikaavio kirjautumisesta](/dokumentointi/Kuvat/Sekvenssikaavio1.png)

Painikkeen painamiseen reagoi tapahtumankäsittelijä, joka kutsuu *domain* pakkauksen luokan *UserLogic* metodia *logUserIn*, jolle annetaan parametreiksi käyttäjän syöttämä käyttäjätunnus ja salasana. Sovelluslogiikka selvittää tämän jälkeen *UserDao*:n avulla, onko käyttäjätunnusta olemassa ja jos on, niin käyttäjälle näytetään sovelluksen päävalikko.

### Uuden käyttäjätunnuksen luominen

Kun käyttäjä on täyttänyt vaadittavat kentät Luo uusi käyttäjä-näkymässä niin, että tiedot ovat muodoltaan oikeita ja käyttäjätunnus ei ole jo käytössä, ja painaa "Luo käyttäjätunnus"-nappia, sovelluksen kontrolli etenee seuraavasti:

![Sekvenssikaavio uuden käyttäjätunnuksen luomisesta](/dokumentointi/Kuvat/Sekvenssikaavio2.png)

Klikattua painiketta kuunteleva tapahtumakäsittelijä kutsuu luokan *UserLogic* luokan metodeita, jotka tarkistavat käyttäjän syöttämien tietojen muodon oikeellisuuden. Jos kaikki nämä metodit palauttavat true, kutsuu luokan *UserLogic* metodia *addUser*, joka saa parametreina käyttäjän syöttämät tiedot. *UserDao* rajapinnan avulla tarkistetaan, onko käyttäjänimi jo käytössä. Jos ei, palauttaa tarkistamisen suorittanut *read*-metodi null. Tämän jälkeen sovelluslogiikka luo uuden *User*-olion. Sitten luokka *UserLogic* kutsuu *UserDao*:n metodia create, jolla on parametrina juuri luotu *User*-olio. Käyttöliittymä ilmoittaa onnistuneesta toiminnosta näyttämällä tekstin "Rekisteröityminen onnistui".

### Uuden tapahtuman lisääminen

Kun käyttäjä on syöttänyt tapahtuman tiedot ja klikkaa nappia "Lisää tapahtuma", sovelluksen kontrolli etenee seuraavasti:

![Sekvenssikaavio tapahtuman lisäämisestä](/dokumentointi/Kuvat/Sekvenssikaavio3.png)

Tapahtumakäsittelijä kutsuu sovelluslogiikan luokan *EventLogic* metodia *isSumDouble*, jotta voidaan tarkistaa, onko käyttäjän syöttämä summa oikean muotoinen. Jos metodi palauttaa true, käyttöliittymä kutsuu luokan *EventLogic* metodia *addEvent*, jossa parametreina ovat käyttäjän syöttämät tapahtuman tiedot. Sovelluslogiikka luo uuden *Event*-olion ja tallenttaa sen kutsumalla *EventDao*:n metodia *create*. Onnistuneen tallettamisen jälkeen *EventLogic* palauttaa true, ja käyttäjä saa tiedon tapahtuman tallentamisen onnistumisesta.

### Muut toiminnallisuudet

Samat periaatteet toistuvat muissakin toiminnallisuuksissa, eli tapahtumakäsittelijä käyttöliittymässä kutsuu sovelluslogiikan metodia ja sovelluslogiikka myös DAO-luokien metodeista sopivaa, jos toimintoon liittyy tietokantaan kirjoittamista tai tietokannasta lukemista.

## Ohjelman rakenteeseen jääneet heikkoudet

Dao-luokissa esiintyy useasti yhteyden luominen tietokantaan, minkä voisi suorittaa kyseisissä luokissa vain kerran. Näin myös toisteinen koodi vähenisi.

JavaFX ei ole kovin tuttua, joten sen käyttöä käyttöliittymää luodessa voisi parantaa. Käyttöliittymässä voisi myös hyödyntää JavaFX:n tilalla FXML:ää. Käyttöliittymän joidenkin muuttujien nimentää voisi myös parantaa.
