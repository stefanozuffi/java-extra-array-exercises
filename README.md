# Java Array Super Spec - Esercizi Progressivi A

## Esercizio 1: Kill Feed Filter

**Difficoltà:** Base

### Cosa fare

Scrivi un metodo che prenda un array di eventi di gioco (`killFeed`) e un array di tipi da escludere (`invalidTypes`), e restituisca un nuovo array contenente solo gli eventi validi nell'ordine originale.

### Firma del metodo

```java
public static int[] filterKillFeed(int[] killFeed, int[] invalidTypes)
```

### Esempi

```java
// Esempio 1
Input: killFeed = {1, 5, 2, 6, 1, 3, 5}, invalidTypes = {5, 6}
Output: {1, 2, 1, 3}

// Esempio 2
Input: killFeed = {3, 3, 3, 4}, invalidTypes = {1, 2}
Output: {3, 3, 3, 4}

// Esempio 3
Input: killFeed = {}, invalidTypes = {5, 6}
Output: {}
```

### Note importanti

- Gli array possono essere vuoti
- `invalidTypes` può contenere valori non presenti nel feed
- Se un tipo è invalido, TUTTE le sue occorrenze vanno rimosse

---

## Esercizio 2: Story Stalker Detector

**Difficoltà:** Base

### Cosa fare

Hai i dati di 7 giorni di visualizzazioni Instagram (7 array di user ID). Trova tutti gli user ID che compaiono in TUTTI E 7 i giorni e restituiscili ordinati in modo crescente.

### Firma del metodo

```java
public static int[] findStalkers(int[] day1, int[] day2, int[] day3, 
                                  int[] day4, int[] day5, int[] day6, int[] day7)
```

### Esempi

```java
// Esempio 1
Input: 7 array dove gli ID 101, 102, 103 compaiono in tutti
Output: {101, 102, 103}

// Esempio 2
Input: 7 array dove nessun ID compare in tutti
Output: {}
```

### Note importanti

- Ogni giorno può avere un numero diverso di viewer
- Lo stesso user NON compare mai due volte nello stesso giorno
- **Gli array di input NON vanno ordinati - devi solo ordinare l'OUTPUT finale**
- L'ordinamento è crescente (dal più piccolo al più grande)

---

## Esercizio 3: Win Streak Tracker

**Difficoltà:** Intermedio

### Cosa fare

Dato un array di risultati partite (`'W'` = win, `'L'` = loss), trova la win streak più lunga e restituisci un array `[lunghezza, indicePartenza]`.

### Firma del metodo

```java
public static int[] longestWinStreak(char[] matches)
```

### Esempi

```java
// Esempio 1
Input: {'W', 'W', 'L', 'W', 'W', 'W', 'L', 'W'}
Output: {3, 3}  // 3 W consecutive partono dall'indice 3

// Esempio 2
Input: {'L', 'L', 'L', 'L'}
Output: {0, -1}  // nessuna win

// Esempio 3
Input: {'W', 'W', 'L', 'W', 'W'}
Output: {2, 0}  // due streak di 2, prendi la prima

// Esempio 4
Input: {}
Output: {0, -1}
```

### Note importanti

- Se ci sono più streak della stessa lunghezza massima, restituisci quella con l'indice di partenza più basso
- Se non ci sono win, restituisci `{0, -1}`

---

## Esercizio 4: Spotify Queue Cleaner

**Difficoltà:** Intermedio

### Cosa fare

Dato un array di ID canzoni (interi), restituisci un nuovo array senza duplicati, mantenendo l'ordine della prima apparizione.

### Firma del metodo

```java
public static int[] cleanQueue(int[] queue)
```

### Esempi

```java
// Esempio 1
Input: {7, 3, 7, 3, 3, 7, 5, 3, 5}
Output: {7, 3, 5}

// Esempio 2
Input: {1, 2, 3, 4, 5}
Output: {1, 2, 3, 4, 5}  // nessun duplicato

// Esempio 3
Input: {42, 42, 42, 42}
Output: {42}
```

### Vincolo critico

- Usa SOLO array nativi (NO `Set`, NO `ArrayList`)
- Il valore massimo di un ID è 10000

---

## Esercizio 5: Twitch Raid Balancer

**Difficoltà:** Medio-Alto

### Cosa fare

Due team hanno hype scores (due array). Trova lo scambio di UN elemento che minimizza la differenza assoluta tra le somme dei due team. Restituisci `[indiceTeam1, indiceTeam2, differenzaFinale]`.

### Firma del metodo

```java
public static int[] findBestSwap(int[] team1, int[] team2)
```

### Esempi

```java
// Esempio 1
Input: team1 = {10, 20, 30}, team2 = {5, 15, 25}
// Somme iniziali: 60 vs 45, diff = 15
// Scambiando indice 2 con indice 2 (30↔25): 55 vs 50, diff = 5
Output: {2, 2, 5}

// Esempio 2
Input: team1 = {1, 1, 1}, team2 = {1, 1, 1}
Output: {-1, -1, 0}  // già bilanciati

// Esempio 3
Input: team1 = {100}, team2 = {1}
Output: {-1, -1, 99}  // lo scambio non migliora
```

### Note importanti

- Se NESSUNO scambio **riduce** la differenza attuale, restituisci `{-1, -1, differenzaAttuale}`
- **Se uno scambio produce la STESSA differenza attuale (né migliora né peggiora), consideralo "non migliora"**
- Devi trovare lo scambio che dà la differenza più piccola possibile

---

## Esercizio 6: TikTok Viral Detector

**Difficoltà:** Medio-Alto

### Cosa fare

Dato un array di views orarie, trova tutti gli indici dove c'è uno "spike virale". Uno spike virale è quando le views di un'ora sono almeno il doppio della media delle 3 ore precedenti.

### Firma del metodo

```java
public static int[] detectViralSpikes(int[] hourlyViews)
```

### Esempi

```java
// Esempio 1
Input: {100, 120, 110, 400, 150, 140, 600}
// Indice 3: media(100,120,110) = 110, views = 400. 400 ≥ 220? SÌ → spike
// Indice 6: media(400,150,140) = 230, views = 600. 600 ≥ 460? SÌ → spike
Output: {3, 6}

// Esempio 2
Input: {10, 20, 30, 40, 50}
// Indice 3: media(10,20,30) = 20, views = 40. 40 ≥ 40? SÌ → spike
Output: {3}

// Esempio 3
Input: {5, 5, 5}
Output: {}  // servono almeno 4 elementi
```

### Note importanti

- Lo spike può essere verificato solo dall'indice 3 in poi (servono 3 ore precedenti)
- La media va calcolata con divisione intera
- **"Almeno il doppio" significa `views >= 2 * media` (maggiore O UGUALE, non solo maggiore)**
- Nell'esempio dell'indice 3: 40 è ESATTAMENTE il doppio di 20, quindi conta come spike

---

## Esercizio 7: Discord Server Merger

**Difficoltà:** Avanzato

### Cosa fare

Due array già ordinati in modo crescente rappresentano membri di due server Discord. Fai il merge in un singolo array ordinato. A parità di valore, l'elemento del primo array viene prima.

### Firma del metodo

```java
public static int[] mergeServers(int[] server1, int[] server2)
```

### Esempi

```java
// Esempio 1
Input: server1 = {1, 3, 5, 7}, server2 = {2, 3, 6, 8}
Output: {1, 2, 3, 3, 5, 6, 7, 8}
// Nota: il 3 di server1 viene prima del 3 di server2

// Esempio 2
Input: server1 = {1, 1, 1}, server2 = {1, 1, 1}
Output: {1, 1, 1, 1, 1, 1}  // tutti i server1 prima

// Esempio 3
Input: server1 = {}, server2 = {5, 10, 15}
Output: {5, 10, 15}
```

### Vincolo critico

- NON puoi usare `Arrays.sort()` sull'array finale
- Devi sfruttare il fatto che gli input sono già ordinati (merge efficiente)

---

## Esercizio 8: Netflix Binge Optimizer

**Difficoltà:** Avanzato

### Cosa fare

Dato un array di durate episodi (in minuti) e un tempo massimo disponibile, trova la sequenza consecutiva più lunga di episodi che puoi guardare. Restituisci `[numeroEpisodi, indicePartenza]`.

### Firma del metodo

```java
public static int[] bingeOptimizer(int[] episodes, int maxTime)
```

### Esempi

```java
// Esempio 1
Input: episodes = {45, 42, 50, 48, 45, 52, 44}, maxTime = 180
// Finestra [0-2]: 45+42+50 = 137 ✓ (3 episodi)
// Finestra [1-3]: 42+50+48 = 140 ✓ (3 episodi)
// Massimo: 3 episodi, prima occorrenza a indice 0
Output: {3, 0}

// Esempio 2
Input: episodes = {60, 60, 60}, maxTime = 120
Output: {2, 0}

// Esempio 3
Input: episodes = {200, 200, 200}, maxTime = 100
Output: {0, -1}  // nessun episodio entra

// Esempio 4
Input: episodes = {}, maxTime = 1000
Output: {0, -1}
```

### Note importanti

- Gli episodi devono essere **consecutivi** nell'array originale (non puoi saltarne)
- Se più sequenze hanno lo stesso numero massimo di episodi, scegli quella che **inizia prima** (indice di partenza più basso)
- **Esempio di scelta tra sequenze uguali:** Se trovi 3 episodi a partire dall'indice 0 E 3 episodi a partire dall'indice 1, restituisci `{3, 0}` perché 0 < 1
- Se nessun episodio può essere guardato (tutti superano `maxTime`), restituisci `{0, -1}`
```