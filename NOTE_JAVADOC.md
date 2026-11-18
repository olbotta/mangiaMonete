# Note: generazione guida Javadoc

## Prerequisiti
- Progetto Maven Java (`pom.xml`)
- JDK installato (`javadoc` disponibile)
- Per la generazione con Maven (sezione 3): Maven installato (`mvn -v`)

## 1) Generazione base (Javadoc standard)
Genera la documentazione API standard nella cartella `docs/apidocs`.

### Linux / macOS
```bash
mkdir -p docs
javadoc -d docs/apidocs \
  -sourcepath src/main/java \
  -subpackages com.example \
  -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
```

### Windows (PowerShell)
```powershell
New-Item -ItemType Directory -Force docs | Out-Null
javadoc -d docs/apidocs `
  -sourcepath src/main/java `
  -subpackages com.example `
  -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
```

### Windows (Prompt dei comandi - cmd)
```bat
if not exist docs mkdir docs
javadoc -d docs/apidocs ^
  -sourcepath src/main/java ^
  -subpackages com.example ^
  -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
```

Aprire: `docs/apidocs/index.html`

## 2) Generazione con tema scuro personalizzato
Usa il foglio di stile aggiuntivo del progetto (`docs/dark-javadoc.css`).

### Linux / macOS
```bash
mkdir -p docs
javadoc -d docs/apidocs \
  -sourcepath src/main/java \
  -subpackages com.example \
  -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 \
  --add-stylesheet docs/dark-javadoc.css
```

### Windows (PowerShell)
```powershell
New-Item -ItemType Directory -Force docs | Out-Null
javadoc -d docs/apidocs `
  -sourcepath src/main/java `
  -subpackages com.example `
  -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 `
  --add-stylesheet docs/dark-javadoc.css
```

### Windows (Prompt dei comandi - cmd)
```bat
if not exist docs mkdir docs
javadoc -d docs/apidocs ^
  -sourcepath src/main/java ^
  -subpackages com.example ^
  -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 ^
  --add-stylesheet docs/dark-javadoc.css
```

## 3) Generazione con UML (configurazione Maven del progetto)
Il progetto è configurato con `maven-javadoc-plugin` + `UMLDoclet` (`nl.talsmasoftware:umldoclet`).

Prerequisiti:
- JDK compatibile con il progetto (proprietà `maven.compiler.release` nel `pom.xml`) e `javadoc` disponibile (`JAVA_HOME`/`PATH`)
- Maven installato; Graphviz non serve, UMLDoclet disegna i diagrammi da solo

### Comando (tutte le piattaforme)
```bash
mvn test javadoc:javadoc
```

Esegue i test e genera la documentazione in `target/reports/apidocs`, con il foglio di stile `docs/dark-javadoc.css` e i diagrammi UML (`*.svg`).

Aprire: `target/reports/apidocs/index.html`

### Pubblicazione su GitHub Pages
A ogni push su `main` il workflow `.github/workflows/javadoc-publish.yml` esegue lo stesso comando su GitHub e pubblica `target/reports/apidocs` su GitHub Pages. Se un test fallisce, la documentazione non viene pubblicata.

Una volta sola, nel repository su GitHub: **Settings → Pages → Build and deployment → Source: GitHub Actions**.

## 4) Generazione con IntelliJ IDEA
In IntelliJ IDEA la Javadoc si genera dalla GUI (non da un singolo comando shell):

1. Apri il progetto.
2. Menu: **Tools > Generate JavaDoc...**
3. Configura le opzioni principali:
   - **Scope**: es. *Whole project* o *Custom scope* (es. solo `src/main/java`)
   - **Output directory**: es. `docs/apidocs`
   - **Visibility level**: `public`, `protected`, `package`, o `private` (in base a cosa vuoi documentare)
4. (Consigliato) In **Other command line arguments** aggiungi:
   ```text
   -encoding UTF-8 -charset UTF-8 -docencoding UTF-8
   ```
5. Per usare il tema scuro personalizzato del progetto, aggiungi anche:
   ```text
   --add-stylesheet <percorso-assoluto-o-relativo>/docs/dark-javadoc.css
   ```
   (puoi combinare gli argomenti in un'unica riga)
6. Clicca **OK** (o **Generate**) per avviare la generazione.

**Nota:** IntelliJ usa il `javadoc` del JDK configurato per il progetto/IDE. Per diagrammi UML in stile UMLDoclet serve una configurazione avanzata del doclet (non inclusa nella procedura standard di IntelliJ) oppure generare la guida via Maven (`mvn javadoc:javadoc`).

## Note
- Dopo la generazione con UMLDoclet, i diagrammi SVG possono richiedere piccoli aggiustamenti di colore per adattarli al tema scuro.
- In VS Code la guida può essere aperta con *Simple Browser* o *Live Preview* puntando a `target/reports/apidocs/index.html` (Maven) o `docs/apidocs/index.html` (sezioni 1–2).
- Per generare la documentazione senza Maven (e senza UML), usare la generazione standard descritta nelle sezioni 1–2.
