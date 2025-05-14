# Users API – Java 21

Uma API RESTful desenvolvida em Java 21, utilizando arquitetura em camadas para gerenciamento de usuários.

## 🧱 Arquitetura

O projeto segue uma arquitetura em camadas, promovendo separação de responsabilidades e facilitando manutenção e testes:

- **Controller (Handlers)**: Define os endpoints da API utilizando rotas do Javalin e delega o processamento à camada de serviço.
- **Service**: Contém a lógica de negócio da aplicação, orquestrando as interações entre as camadas.
- **Repository (DAO)**: Responsável pela persistência e acesso aos dados no banco de dados.
- **DTO (Data Transfer Object)**: Define objetos usados para transportar dados entre camadas, garantindo encapsulamento e evitando exposições indesejadas do modelo de domínio.

## 💉 Injeção de Dependência

O projeto implementa um **container de injeção de dependência customizado**, responsável por instanciar e gerenciar os componentes da aplicação de forma manual. Essa abordagem segue os princípios de:

- **Inversão de Controle (IoC)**: As dependências são fornecidas por um container central, não sendo criadas diretamente pelas classes consumidoras.
- **Injeção de Dependência (DI)**: Permite menor acoplamento entre os componentes da aplicação.
- **Responsabilidade Única**: As classes mantêm foco exclusivo na sua lógica de negócio, delegando a criação de dependências ao container.

Essa implementação substitui o uso de soluções externas como o Spring Framework, mantendo o controle completo do fluxo e da estrutura da aplicação.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Gradle**: Sistema de automação de build.
- **Javalin**: Framework leve para criação de APIs web em Java.
- **PostgreSQL**: Banco de dados relacional utilizado na persistência dos dados.
- **Docker**: Facilita o empacotamento e a execução da aplicação em qualquer ambiente.

## 📁 Estrutura do Projeto

```
usersApi-java/app/src/main/java/com/users/api/
├── App.java
├── Config
|   ├── AppConfig.java
|   ├── Database.java
|   └── DependencyContainer.java
├── Controller
│   └── UserController.java
├── Dao
│   └── UserDao.java
├── Dto
│   ├── UserRequestDto.java
│   └── UserResponseDto.java
├── Entity
│   └── User.java
├── Interfaces
│   ├── DaoInterface.java
│   └── RepositoryInterface.java
├── Repository
│   └── UserRepository.java
├── Service
│   └── UserService.java
└── Utils

```

## ⚙️ Configuração com Docker

Para rodar a aplicação, tudo o que você precisa é do Docker instalado. A imagem da aplicação está disponível no Docker Hub.

### Passos:

1. Certifique-se de que o Docker está instalado em sua máquina.
2. Execute o seguinte comando para subir a aplicação:

```bash
docker run -p 8080:8080 devguilhermeribeiiro/users-api-java
```

> Isso irá puxar a imagem da API do Docker Hub e expô-la na porta `8080`.

## 📌 Endpoints

A API expõe os seguintes endpoints:

- `GET /users`: Retorna todos os usuários.
- `GET /users/{uuid}`: Retorna um usuário específico.
- `POST /users`: Cria um novo usuário.
- `PUT /users/{uuid}`: Atualiza um usuário existente.
- `DELETE /users/{uuid}`: Remove um usuário.

## 🧪 Testes

Os testes podem ser executados com:

```bash
./gradlew test
```

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).