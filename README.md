# Praxisprojekt
---
## Inhalt Datenträger
Der Datenträger enthält folgende relevaten Dateien:
 * Beispielcode
   * Alle Java Klassen des Beispiel Programms
   * pom.xml
 * Tex-Dokument
   * Abbildungen - alle verwendeten Abbildungen
   * Abstract - Enthält Abstract(Englisch) und Zusammenfassung(Deutsch)
   * Deckblatt - Deckblatt enthält Deckblatt.tex
   * Erklärung - Enthält Erklärung.tex
   * Literatur.bib - enthält alle verwendeten Quellen
   * praxisbericht.tex - eignetliches .tex des gesamten Dokuments
   * praxisbericht.pdf - finale Version wie sie auch auf Papier vorliegt
   * SelfArx.cls - Enthält Formatierungsinformation zur Haupt-Texdatei

## Weiteres
### Vorlagen und Software
Alle Templates und vorhandener Code wurde von mir selbst erstellt, bis auf das Artikeltemplate in Latex. Diese Template stammt ursprünglich von Mathias Legrand, ist unter der CC-Lizenz (http://creativecommons.org/licenses/by-nc-sa/3.0/) veröffentlich und wurde auf der Seite http://www.LaTeXTemplates.com geladen.

Zur Erstellung des Programmbeispiels wurde Java in Version 1.8.0_121 verwendet. Die Version von Apache Maven war 3.3.9 . Es wurde die frei IDE IntelliJ von JetBrains verwendet um den Beispielcode zu programmieren. Als Tex-Editor fand der freie Editor TeXstudio Einsatz.

### Zusatzinformation
Um das Beispielprogramm selbst auszuführen muss der Code einem Projekt zugeordnet werden. Durch die externen Abhängigkeiten muss es sich um ein Maven-Projekt handeln und es muss sicher gestellt werden, dass die beiliegenden pom.xml angezogen wird und alle Dependencies auch geladen werden können. Dieser Schritt ist Voraussetung zum lokalen Ausführen.

Der Abschnitt Kurzfassung/Zusammenfassung erscheint zweimal in dem gesamten Dokument. Dies ist nötig, da es sich bei der Arbeit um einen eigenstänigen Artikel handelt, und zu jedem wissenschaftlichen Artikel gehört eine entsprechende Zusammenfassung. Da dieser Artikel aber als Praxisprojekt eingereicht wird, sind Formalitäten einzuhalten. Diese sind zum Beispiel eine Kurzfassung in Deutsch und Englisch direkt zu Beginn den Berichts. Auch gehört die Erkährung dazu. Um diese Formalitäten zu waren, wurde eine zusätzliche Seite vor dem eigentlichen Artikel eingefügt und der Text der Zusammenfassung erscheint dadurch zweimal innerhalb des gesamten Dokuments.
