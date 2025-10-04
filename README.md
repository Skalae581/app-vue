````markdown
# Spring Boot + Vue 3 – Starter

Schlanke Full-Stack-Vorlage mit **Spring Boot 3 (REST-API)** und **Vue 3 + Vite (Frontend)**.  
Ideal für CRUD-Apps, Prototypen und Schulungszwecke.

---

## 🚀 Features
- Backend: Spring Boot 3, Web, Data JPA, Validation, **H2 In-Memory DB**
- Beispiel-Entity **Task** mit CRUD-Endpoints (`/api/tasks`)
- Frontend: Vue 3, Vite, Axios, **Proxy** auf `/api`
- CORS-Konfiguration für lokale Entwicklung

---

## 🧰 Tech-Stack & Voraussetzungen
- **Java 17 (LTS)**
- **Maven 3.9+**
- **Node.js 18+ / npm**
- Optional: **Docker** (für PostgreSQL)

Prüfen:

``
java -version
mvn -v
node -v
npm -v
````

---

## 📁 Projektstruktur

```
spring-vue-app/
├─ backend/
│  ├─ pom.xml
│  └─ src/main/
│     ├─ java/com/example/app/
│     │  ├─ AppApplication.java
│     │  ├─ config/CorsConfig.java
│     │  ├─ model/Task.java
│     │  ├─ repo/TaskRepository.java
│     │  ├─ service/TaskService.java
│     │  └─ controller/TaskController.java
│     └─ resources/application.properties
└─ frontend/
   ├─ package.json
   ├─ index.html
   ├─ vite.config.js
   └─ src/
      ├─ main.js
      ├─ App.vue
      ├─ api.js
      └─ components/TaskList.vue
```

---

## ⚙️ Installation

**JDK & Maven (Windows, PowerShell):**

```powershell
winget install -e --id EclipseAdoptium.Temurin.17.JDK
winget install -e --id Apache.Maven
```

**Frontend-Dependencies:**

```bash
cd frontend
npm install
```

---

## ▶️ Entwicklung starten

**Backend**

```bash
cd backend
mvn spring-boot:run
# http://localhost:8080
```

**Frontend**

```bash
cd frontend
npm run dev
# http://localhost:5173
```

> Der Vite-Proxy leitet `/api` automatisch an `http://localhost:8080`.

---

## 🔌 API (Beispiel)

**Basis-URL:** `http://localhost:8080/api/tasks`

**Endpoints**

* `GET /api/tasks` – alle Tasks
* `POST /api/tasks` – Task anlegen
* `PUT /api/tasks/{id}` – Task aktualisieren
* `DELETE /api/tasks/{id}` – Task löschen

**cURL**

```bash
curl http://localhost:8080/api/tasks
curl -X POST http://localhost:8080/api/tasks -H "Content-Type: application/json" -d "{\"title\":\"Neu\",\"completed\":false}"
```

---

## 🐘 Optional: PostgreSQL statt H2

**pom.xml** (Dependency):

```xml
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
  <scope>runtime</scope>
</dependency>
```

**application.properties:**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/app
spring.datasource.username=app
spring.datasource.password=secret
spring.jpa.hibernate.ddl-auto=update
```

**Docker (Beispiel):**

```bash
docker run --name app-postgres -e POSTGRES_DB=app -e POSTGRES_USER=app -e POSTGRES_PASSWORD=secret -p 5432:5432 -d postgres:16-alpine
```

---

## 🏗️ Build (Production)

**Backend Jar**

```bash
cd backend
mvn clean package
# target/app-0.0.1-SNAPSHOT.jar
```

**Frontend Bundle**

```bash
cd frontend
npm run build
# erzeugt dist/
```

Deployment-Optionen:

* `dist/` statisch (z. B. Nginx) + Spring Boot separat
* oder `dist/` nach `backend/src/main/resources/static/` kopieren (Spring liefert Frontend aus)

---

## 🧪 Troubleshooting

* **`mvn`/`java` nicht gefunden:** JDK 17 & Maven installieren, neues Terminal; `java -version` / `mvn -v`.
* **Frontend erreicht API nicht:** Läuft Backend auf `:8080`? Proxy in `vite.config.js` korrekt?
* **CORS-Fehler:** `CorsConfig` erlaubt `http://localhost:5173`.
* **Port belegt:** Prozess beenden oder Ports ändern (`server.port` bzw. Vite `--port`).
* **`pom.xml` Fehler/leer:** Inhalte korrekt einfügen und speichern.

---

## 📜 Lizenz

Füge bei Bedarf eine `LICENSE` hinzu (z. B. MIT).

## 👤 Autor

Tanja Koschevnikov – TUHH-Projekte (Java, Frontend/Backend), Python (Pandas, Keras).

```
::contentReference[oaicite:0]{index=0}
```
