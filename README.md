# SpringBoot Tasks API (Checkpoint 1)

Projeto inicial para checkpoint 1 — API REST de gerenciamento de tarefas (in-memory).

## O que existe neste estágio
- Estrutura Maven completa (`pom.xml`)
- Endpoints REST básicos para `Task` (CRUD)
- Persistência em memória via `InMemoryTaskRepository` (HashMap)
- Documentação OpenAPI (Swagger UI) disponível em `/swagger-ui.html` após rodar
- Arquivos básicos (`.gitignore`, `README.md`, `application.properties`)

## Como rodar
Requisitos: JDK 17 e Maven instalados.

1. Navegue até a pasta do projeto:
```bash
cd springboot-tasks-api
```
2. Rode com Maven:
```bash
mvn spring-boot:run
```
3. A API ficará disponível em `http://localhost:8080`.
- Swagger UI: `http://localhost:8080/swagger-ui.html`

## Endpoints principais
- `GET /api/tasks` — listar tarefas
- `GET /api/tasks/{id}` — obter tarefa por id
- `POST /api/tasks` — criar tarefa
- `PUT /api/tasks/{id}` — atualizar tarefa
- `DELETE /api/tasks/{id}` — deletar tarefa

Este é um projeto em estágio inicial, adequado para apresentação do Checkpoint 1 (mostrar repositório, estrutura de pacotes e endpoints mínimos funcionando).

