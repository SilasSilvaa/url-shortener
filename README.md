# 🔗 Encurtador de URL

Este projeto é um encurtador de URLs desenvolvido utilizando **Spring Boot 3**, **Docker** e **MongoDB**. Ele permite transformar URLs longas em links curtos, facilitando o compartilhamento e gerenciamento de links.

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3**
- **MongoDB**
- **Docker**
- **Maven Wrapper**

## 📁 Estrutura do Projeto

```
url-shortener/
├── .mvn/           # Arquivos do Maven Wrapper
├── docker/         # Configurações para Docker
├── src/            # Código-fonte da aplicação
├── pom.xml         # Configurações do Maven
├── mvnw            # Script do Maven Wrapper (Linux/Mac)
├── mvnw.cmd        # Script do Maven Wrapper (Windows)
└── .gitignore      # Arquivos e pastas ignorados pelo Git
```

## ⚙️ Como Executar o Projeto

### Pré-requisitos

- Java 17 ou superior
- Docker e Docker Compose instalados

### Passos para Execução

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/SilasSilvaa/url-shortener.git
   cd url-shortener
   ```

2. **Suba o mongo com Docker Compose:**

   ```bash
   docker-compose up
   ```

3. **Execute a aplicação com o comando abaixo:**

    Windows:
    ```bash
    mvnw.cmd spring-boot:run
    ```
    Unix/Linux/Mac:
   ```bash
   ./mvnw spring-boot:run
   ```

5. Acesse a aplicação em: [http://localhost:8080](http://localhost:8080)

## 📄 Endpoints da API

- **POST /api/shorten**: Recebe uma URL longa e retorna uma URL encurtada.
- **GET /{slug}**: Redireciona para a URL original baseada no slug fornecido.

## 🧪 Testes

Atualmente, o projeto não possui testes automatizados. Contribuições são bem-vindas!

## 📌 Melhorias Futuras

- Implementação de testes unitários e de integração
- Criação de uma interface frontend para interação com a API
- Adição de autenticação e autorização
- Monitoramento e análise de métricas de uso

## 📃 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
