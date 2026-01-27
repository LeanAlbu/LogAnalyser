# 📂 Log Analyzer CLI

Uma ferramenta de linha de comando (CLI) desenvolvida em Java para processamento eficiente de arquivos de log e extração de URLs.

Este projeto foi criado como parte de um estudo aprofundado sobre **Java Core**, com foco em manipulação de arquivos, Collections e API de Streams.

## 🚀 Funcionalidades

* **Leitura Eficiente:** Utiliza `Files.lines()` para processar arquivos grandes via Stream, evitando carregar todo o conteúdo na memória de uma vez (Lazy Evaluation).
* **Filtragem de Dados:** Identifica e extrai apenas linhas que iniciam com protocolos válidos (`http`, `https`, `ftp`, `www`), ignorando logs de erro ou linhas corrompidas.
* **Deduplicação:** Remove URLs duplicadas automaticamente utilizando `Set` e `Collectors`.
* **Tratamento de Exceções:** Gerenciamento robusto de erros de I/O (`try-with-resources`).

## 🛠️ Tecnologias Utilizadas

* **Java 17+** (Compatível com versões modernas).
* **Java IO (NIO.2):** Para manipulação de arquivos (`Path`, `Files`).
* **Java Streams API:** Para processamento funcional dos dados.
* **Java Collections Framework:** Para armazenamento e manipulação de dados únicos.

## 📋 POR FAZER:
* Adicionar função que discerne quantas vezes cada domínio realizou chamadas, quantas chamadas resultaram em erros e etc...
