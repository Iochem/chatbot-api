# API Chatbot Atendimentos #
Este é um projeto em Java para um chatbot de atendimento automatizado, voltado para agendamento de horários em uma barbearia. A API permite visualizar horários disponíveis, realizar e cancelar agendamentos.

Fluxo: `Controller → ClienteDTO → ClienteService → ClienteRepository → Map`

##  Funcionalidades
- Exposição de serviços via API REST com `@RestController`
- Operações `HTTP` `GET`, `POST` e `DELETE` para agendar, cancelar e listar horários
- Envio e recebimento de dados em JSON com validação automática (`@Valid`)
- Controle de disponibilidade de horários com atualização dinâmica (livre/ocupado) 
- Persistência de dados com `Spring Data JPA` e `entidades` para clientes e horários
- Conversão entre `DTOs` e `entidades` usando `Mappers` 
- Inicialização automática do banco com horários pré-cadastrados
- `Mensagens HTTP` adequadas e tratadores globais de exceção (em desenvolvimento)


## Tecnologias 
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Bean Validation 
- Maven
- Lombok

- IntelliJ IDEA


## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/chatbot-api.git

Desenvolvido por [Brenda Nunes] (https://github.com/Iochem)
