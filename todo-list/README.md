# 📝 Todo List API

API RESTful para gerenciamento de tarefas, desenvolvida com Java, Spring Boot e PostgreSQL.

## 🚀 Tecnologias

- **Java 21**
- **Spring Boot 4.0.6**
- **Spring Data JPA**
- **Spring Validation**
- **PostgreSQL**
- **Lombok**
- **Gradle**

## 📁 Estrutura do Projeto

```
src/
└── main/
    └── java/com/todo/todo_list/
        ├── controller/    # Endpoints da API
        ├── service/       # Regras de negócio
        ├── repository/    # Acesso ao banco de dados
        ├── model/         # Entidade JPA
        ├── dto/           # Objetos de transferência de dados
        └── exception/     # Tratamento de erros
```

## ⚙️ Como rodar localmente

### Pré-requisitos

- Java 21+
- PostgreSQL instalado e rodando
- Gradle

### Passo a passo

**1. Clone o repositório**
```bash
git clone https://github.com/pehenriqueoliv/todo-list-api.git
cd todo-list-api
```

**2. Crie o banco de dados**
```sql
CREATE DATABASE "todo-db";
```

**3. Configure a variável de ambiente com a senha do banco**

No Linux/macOS:
```bash
export DB_PASSWORD=sua_senha
```

No Windows (PowerShell):
```powershell
$env:DB_PASSWORD="sua_senha"
```

**4. Execute o projeto**
```bash
./gradlew bootRun
```

A API estará disponível em `http://localhost:8080`.

## 🔗 Endpoints

### Criar tarefa
`POST /tasks`

**Body:**
```json
{
  "title": "Estudar Spring Boot",
  "description": "Revisar os conceitos de JPA",
  "completed": false
}
```

---

### Listar todas as tarefas
`GET /tasks`

---

### Buscar tarefa por ID
`GET /tasks/{id}`

---

### Atualizar tarefa
`PUT /tasks/{id}`

**Body:**
```json
{
  "title": "Estudar Spring Boot",
  "description": "Revisar os conceitos de JPA",
  "completed": true
}
```

---

### Deletar tarefa
`DELETE /tasks/{id}`

---

## 📌 Modelo de resposta

```json
{
  "id": 1,
  "title": "Estudar Spring Boot",
  "description": "Revisar os conceitos de JPA",
  "completed": false,
  "createdAt": "2026-05-11T14:00:00",
  "updatedAt": "2026-05-11T14:00:00"
}
```

## 🧪 Testando com Postman

1. Abra o Postman e crie uma nova requisição
2. Selecione o método HTTP desejado (GET, POST, PUT, DELETE)
3. Insira a URL, por exemplo: `http://localhost:8080/tasks`
4. Para POST e PUT, vá em **Body → raw → JSON** e insira o payload
5. Clique em **Send**

## 👨‍💻 Autor

Feito por **[Pedro Henrique]** — sinta-se à vontade para entrar em contato!


