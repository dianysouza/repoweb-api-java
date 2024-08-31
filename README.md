# repoweb-api-java
# Projeto de Gerenciamento de Usuários e Projetos

Este projeto é uma aplicação backend desenvolvida em Java com o framework Spring Boot. Ele oferece APIs RESTful para gerenciar usuários e projetos, permitindo operações básicas como criação, leitura, atualização e exclusão (CRUD).

## Sumário

- [Visão Geral](#visão-geral)
- [Pré-requisitos](#pré-requisitos)
- [Endpoints](#endpoints)
    - [Usuários](#usuários)
    - [Projetos](#projetos)

## Visão Geral

O projeto é dividido em duas partes principais:

1. **Usuários**: Gerencia operações relacionadas a usuários, incluindo busca por credenciais.
2. **Projetos**: Gerencia operações relacionadas a projetos, incluindo criação, visualização, atualização e exclusão.

## Pré-requisitos

Antes de começar, verifique se você tem os seguintes pré-requisitos instalados:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) ou superior.
- [Maven](https://maven.apache.org/download.cgi) para gerenciamento de dependências.
- [Spring Boot](https://spring.io/projects/spring-boot) para a aplicação.

## Endpoints

### Usuários

#### Buscar Usuário por Nome e Senha

- **URL**: `/usuarios`
- **Método**: `GET`
- **Parâmetros**:
    - `nomeUsuario` (String) - Nome de usuário.
    - `senhaUsuario` (String) - Senha do usuário.
- **Resposta Sucesso (200)**:
    - **Corpo**: JSON com detalhes do usuário.

**Exemplo de Requisição**:
```http
GET /usuarios?nomeUsuario=usuario123&senhaUsuario=senha123
```

**Exemplo de Resposta**:
```json
{
  "id": 1,
  "nm_usuario": "usuario123",
  "ds_senha": "senha123"
}
```

### Projetos

#### Criar Projeto

- **URL**: `/projetos`
- **Método**: `POST`
- **Corpo**: JSON com detalhes do projeto.
- **Resposta Sucesso (201)**:
    - **Corpo**: JSON com detalhes do projeto criado.

**Exemplo de Requisição**:
```http
POST /projetos
Content-Type: application/json

{
  "nome": "Novo Projeto",
  "descricao": "Descrição do projeto",
  "dataInicio": "2024-01-01"
}
```

**Exemplo de Resposta**:
```json
{
  "id": 1,
  "nome": "Novo Projeto",
  "descricao": "Descrição do projeto",
  "dataInicio": "2024-01-01",
  "quantidadeAcessos": 0
}
```

#### Visualizar Projeto

- **URL**: `/projetos/{id}`
- **Método**: `GET`
- **Resposta Sucesso (200)**:
    - **Corpo**: JSON com detalhes do projeto.

**Exemplo de Requisição**:
```http
GET /projetos/1
```

**Exemplo de Resposta**:
```json
{
  "id": 1,
  "nome": "Novo Projeto",
  "descricao": "Descrição do projeto",
  "dataInicio": "2024-01-01",
  "quantidadeAcessos": 0
}
```

#### Atualizar Acessos do Projeto

- **URL**: `/projetos/{id}/acessos`
- **Método**: `PUT`
- **Resposta Sucesso (200)**:
    - **Corpo**: JSON com detalhes do projeto atualizado

**Exemplo de Requisição**:
```http
PUT /projetos/1/acessos
```

**Exemplo de Resposta**:
```json
{
  "id": 1,
  "nome": "Novo Projeto",
  "descricao": "Descrição do projeto",
  "dataInicio": "2024-01-01",
  "quantidadeAcessos": 1
}
```

#### Remover Projeto

- **URL**: `/projetos/{id}`
- **Método**: `DELETE`
- **Resposta Sucesso (200)**:
    - **Corpo**: Sem retorno no body

**Exemplo de Requisição**:
```http
DELETE /projetos/1
```