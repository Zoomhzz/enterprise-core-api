# 🏢 Enterprise Core API

Este é um ecossistema de backend robusto, desenvolvido para centralizar as operações essenciais de uma empresa: gestão de colaboradores, parceiros comerciais e base de clientes.

O projeto demonstra o domínio de uma arquitetura em camadas e o uso avançado do ecossistema **Spring**, focado em escalabilidade e manutenibilidade.

## 🛠️ Stack Tecnológica
* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Persistência:** Spring Data JPA
* **Banco de Dados:** MySQL / H2
* **Web:** REST Controller com suporte a JSON

## 🏗️ Arquitetura e Diferenciais
- **Padrão Service-Repository**: Separação total de responsabilidades, garantindo que os Controllers foquem apenas na comunicação HTTP.
- **Tratamento de Exceções Centralizado**: Uso de `@RestControllerAdvice` para capturar falhas de negócio e retornar mensagens amigáveis em JSON.
- **Domínios Corporativos**:
  - **Funcionários**: Gestão detalhada com enums de `Cargo` e `Setor`, além de validação de CPF e e-mail único.
  - **Fornecedores**: Controle por CNPJ único e dados de contato.
  - **Clientes**: Cadastro estruturado com tipagem rígida de gênero e endereçamento.
- **Mapeamento de Tabelas**: Uso de `@Table` para personalizar a estrutura do banco de dados (ex: `tab_funcionario`).

## 🛣️ Estrutura de Endpoints

### 👥 Funcionários (`/funcionario`)
| Método | Endpoint | Ação |
|---|---|---|
| POST | `/funcionario` | Cadastro com validação de e-mail |
| PUT | `/funcionario/{id}` | Atualização de cargo/salário |

### 📦 Fornecedores (`/fornecedores`)
| Método | Endpoint | Ação |
|---|---|---|
| GET | `/fornecedores/cnpj/{cnpj}` | Busca específica por documento |
| POST | `/fornecedores` | Cadastro com trava de duplicidade de CNPJ |

### 🤝 Clientes (`/cliente`)
| Método | Endpoint | Ação |
|---|---|---|
| GET | `/cliente/{id}` | Busca detalhada de cliente |
| DELETE | `/cliente/{id}` | Remoção lógica/física com validação de ID |

## ⚙️ Como rodar o projeto
1. Clone o repositório.
2. Configure seu banco de dados no `src/main/resources/application.properties`.
3. Execute através do Maven: `mvn spring-boot:run`.

---
Desenvolvido por **Seu Nome** - [LinkedIn](seu-link-aqui) | [E-mail](seu-email-aqui)
