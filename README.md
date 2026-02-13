# Ohjelmistotuotanto Harjoitus (CI/CD Demo)

Tämä projekti on SeAMK Ohjelmistotuotannon jatkokurssin harjoitustyö. Kyseessä on Spring Boot -pohjainen REST API, joka on kontitettu Dockerilla ja jolle on rakennettu täysimittainen CI/CD-putki GitHub Actionsin avulla.

Sovellus pyörii CSC:n cPouta-pilvipalvelimella.

## 🚀 Ominaisuudet

* **REST API:** CRUD-toiminnallisuus muistiinpanojen tallennukseen.
* **Tietokanta:** PostgreSQL (tuotannossa ja kehityksessä), H2 (testeissä).
* **Kontitus:** Docker & Docker Compose.
* **CI/CD:** GitHub Actions.
    * **CI:** Kääntää koodin ja ajaa testit automaattisesti.
    * **CD:** Rakentaa Docker-imagen, puskee sen Docker Hubiin ja päivittää CSC-palvelimen automaattisesti.

## 🛠️ Teknologiat

* **Backend:** Java 17, Spring Boot 3
* **Tietokanta:** PostgreSQL 15
* **DevOps:** Docker, GitHub Actions, SSH
* **Pilvi:** CSC cPouta (Ubuntu)

## ⚙️ Arkkitehtuuri

1.  **Local Dev:** Kehittäjä tekee muutoksen -> `git push`.
2.  **GitHub Actions (CI):**
    * Checkout koodi.
    * Asenna Java.
    * Aja yksikkötestit (`mvn test`).
3.  **GitHub Actions (CD):**
    * Rakenna JAR (`mvn package`).
    * Rakenna Docker Image (`docker build`).
    * Push Docker Hubiin.
    * Yhdistä SSH:lla CSC-palvelimelle.
    * Vedä uusin image (`docker compose pull`).
    * Käynnistä uudelleen (`docker compose up -d`).

## 📦 Asennus ja käyttö (Paikallisesti)

Vaatimukset: Docker & Java 17.

1.  Kloonaa repo:
    ```bash
    git clone [https://github.com/kaikatajisto/ohjelmistotuotanto-harjoitus.git](https://github.com/kaikatajisto/ohjelmistotuotanto-harjoitus.git)
    ```
2.  Käynnistä tietokanta:
    ```bash
    docker compose up -d
    ```
3.  Käynnistä sovellus:
    ```bash
    ./mvnw spring-boot:run
    ```

## 🌐 API Endpointit

* `GET /` - Hae kaikki muistiinpanot.
* `POST /` - Luo uusi muistiinpano (Body: plain text).

---
*Tekijä: Kai Katajisto TITE23*