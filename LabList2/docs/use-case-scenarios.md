# Scenariusze przypadków użycia

## UC1 – Wypożycz egzemplarz książki

**Aktor główny:** Bibliotekarz

**Cel:** Wypożyczenie dostępnego egzemplarza książki wybranemu czytelnikowi.

**Warunki początkowe:**
- Czytelnik jest zarejestrowany w systemie.
- Egzemplarz znajduje się w bibliotece.
- Egzemplarz nie jest aktualnie wypożyczony.

**Scenariusz podstawowy:**
1. Bibliotekarz wybiera opcję wypożyczenia książki.
2. System prosi o podanie identyfikatora czytelnika.
3. Bibliotekarz podaje identyfikator czytelnika.
4. System prosi o podanie identyfikatora egzemplarza.
5. Bibliotekarz podaje identyfikator egzemplarza.
6. System sprawdza, czy czytelnik istnieje.
7. System sprawdza, czy egzemplarz istnieje i jest dostępny.
8. System tworzy wypożyczenie.
9. System oznacza egzemplarz jako wypożyczony.
10. System wyświetla potwierdzenie wypożyczenia.

**Scenariusze alternatywne:**
- 6a. Czytelnik o podanym identyfikatorze nie istnieje. System wyświetla komunikat o błędzie.
- 7a. Egzemplarz o podanym identyfikatorze nie istnieje. System wyświetla komunikat o błędzie.
- 7b. Egzemplarz jest już wypożyczony. System informuje o braku dostępności.

**Warunki końcowe:**
- Wypożyczenie zostaje zapisane w systemie.
- Egzemplarz ma status wypożyczonego.

---

## UC2 – Zwróć egzemplarz książki

**Aktor główny:** Bibliotekarz

**Cel:** Zarejestrowanie zwrotu wcześniej wypożyczonego egzemplarza książki.

**Warunki początkowe:**
- Egzemplarz znajduje się w bibliotece.
- Egzemplarz jest aktualnie wypożyczony.

**Scenariusz podstawowy:**
1. Bibliotekarz wybiera opcję zwrotu książki.
2. System prosi o podanie identyfikatora egzemplarza.
3. Bibliotekarz podaje identyfikator egzemplarza.
4. System sprawdza, czy egzemplarz istnieje.
5. System sprawdza, czy egzemplarz jest wypożyczony.
6. System rejestruje zwrot egzemplarza.
7. System zmienia status egzemplarza na dostępny.
8. System usuwa aktywne wypożyczenie.
9. System wyświetla potwierdzenie zwrotu.

**Scenariusze alternatywne:**
- 4a. Egzemplarz o podanym identyfikatorze nie istnieje. System wyświetla komunikat o błędzie.
- 5a. Egzemplarz nie jest wypożyczony. System informuje, że nie można zwrócić dostępnego egzemplarza.

**Warunki końcowe:**
- Egzemplarz ma status dostępnego.
- Aktywne wypożyczenie zostaje usunięte z systemu.

---

## UC3 – Dodaj tytuł książki

**Aktor główny:** Bibliotekarz

**Cel:** Dodanie nowego tytułu książki do biblioteki.

**Warunki początkowe:**
- System biblioteczny jest uruchomiony.
- Tytuł o podanym numerze ISBN nie znajduje się jeszcze w bibliotece.

**Scenariusz podstawowy:**
1. Bibliotekarz wybiera opcję dodania tytułu książki.
2. System prosi o podanie numeru ISBN.
3. Bibliotekarz podaje numer ISBN.
4. System prosi o podanie tytułu książki.
5. Bibliotekarz podaje tytuł książki.
6. System prosi o podanie autora.
7. Bibliotekarz podaje autora.
8. System tworzy nowy obiekt książki.
9. System dodaje książkę do biblioteki.
10. System wyświetla potwierdzenie dodania książki.

**Scenariusze alternatywne:**
- 8a. Książka o podanym numerze ISBN już istnieje. System wyświetla komunikat o błędzie.
- 8b. Jedno z wymaganych pól jest puste. System wyświetla komunikat o błędzie.

**Warunki końcowe:**
- Nowy tytuł książki znajduje się w bibliotece.

---

## UC4 – Dodaj egzemplarz książki

**Aktor główny:** Bibliotekarz

**Cel:** Dodanie kolejnego egzemplarza istniejącego tytułu książki do biblioteki.

**Warunki początkowe:**
- System biblioteczny jest uruchomiony.
- Tytuł książki znajduje się już w bibliotece.

**Scenariusz podstawowy:**
1. Bibliotekarz wybiera opcję dodania egzemplarza książki.
2. System prosi o podanie identyfikatora nowego egzemplarza.
3. Bibliotekarz podaje identyfikator egzemplarza.
4. System prosi o podanie numeru ISBN istniejącego tytułu.
5. Bibliotekarz podaje numer ISBN.
6. System sprawdza, czy książka o podanym numerze ISBN istnieje.
7. System tworzy nowy egzemplarz książki.
8. System dodaje egzemplarz do biblioteki.
9. System wyświetla potwierdzenie dodania egzemplarza.

**Scenariusze alternatywne:**
- 6a. Książka o podanym numerze ISBN nie istnieje. System wyświetla komunikat o błędzie.
- 7a. Podany identyfikator egzemplarza jest nieprawidłowy lub został już wykorzystany. System wyświetla komunikat o błędzie.

**Warunki końcowe:**
- Nowy egzemplarz znajduje się w bibliotece.
- Egzemplarz ma status dostępnego.

---

## UC5 – Zarejestruj czytelnika

**Aktor główny:** Bibliotekarz

**Cel:** Dodanie nowego czytelnika do systemu bibliotecznego.

**Warunki początkowe:**
- System biblioteczny jest uruchomiony.

**Scenariusz podstawowy:**
1. Bibliotekarz wybiera opcję rejestracji czytelnika.
2. System prosi o podanie identyfikatora czytelnika.
3. Bibliotekarz podaje identyfikator.
4. System prosi o podanie imienia i nazwiska czytelnika.
5. Bibliotekarz podaje imię i nazwisko.
6. System prosi o podanie adresu e-mail.
7. Bibliotekarz podaje adres e-mail.
8. System tworzy nowy obiekt czytelnika.
9. System dodaje czytelnika do biblioteki.
10. System wyświetla potwierdzenie rejestracji.

**Scenariusze alternatywne:**
- 8a. Podany identyfikator czytelnika jest nieprawidłowy lub został już wykorzystany. System wyświetla komunikat o błędzie.
- 8b. Imię i nazwisko lub adres e-mail są puste. System wyświetla komunikat o błędzie.

**Warunki końcowe:**
- Nowy czytelnik zostaje zapisany w systemie bibliotecznym.