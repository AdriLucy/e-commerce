# Backend E-Commerce

![license](https://img.shields.io/badge/license-MIT-blue.svg)

## Descrição do Projeto

Este projeto foi desenvolvido para a disciplina de **Programação Orientada a Objetos Avançada** do 4º semestre do curso de **Tecnologia em Análise e Desenvolvimento de Sistemas**. O objetivo principal é construir o backend de um sistema de E-Commerce utilizando **Java** e **Spring Boot**.

O sistema foi desenvolvido com uma arquitetura bem definida, utilizando as camadas de **Controller**, **Service**, **Repository**, **Model** e **Exception Handling**, para garantir a separação de responsabilidades e facilitar a manutenção e escalabilidade do código.

## Objetivo

- Desenvolver o backend para um sistema de E-Commerce.
- Implementar operações básicas de CRUD (Criar, Ler, Atualizar e Deletar) para produtos, categorias, pedidos e usuários.
- Manipulação de dados utilizando o **Spring Data JPA** com integração ao banco de dados.
- Configuração e tratamento de exceções para garantir a robustez do sistema.
- Disponibilizar as operações através de uma API, que pode ser testada com o Postman.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto.
- **Spring Boot**: Framework para criação de aplicações Java.
- **Spring Data JPA**: Para a camada de persistência e manipulação de dados.
- **MySQL**: Banco de dados em memória para testes locais.
- **Postman**: Ferramenta para testar as APIs do sistema.

## Estrutura do Projeto

- **Controller**: Camada responsável por receber as requisições HTTP e responder ao cliente.
- **Service**: Contém a lógica de negócios do sistema.
- **Repository**: Camada de acesso ao banco de dados, utilizando Spring Data JPA.
- **Model**: Classes que representam as entidades do sistema.
- **Exception**: Tratamento de exceções personalizadas para uma melhor resposta ao cliente.

## Instalação e Configuração

### 1. Pré-requisitos

- **Java 17** ou superior instalado.
- **Maven** instalado para gerenciamento de dependências.
- **Postman** para testar as APIs.

### 2. Clonar o Repositório

Clone o repositório para o seu ambiente local:

```bash
git clone https://github.com/AdriLucy/e-commerce.git
