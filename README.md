# API Chatbot Atendimentos #
- Este é um projeto em Java para um chatbot de atendimento automatizado, voltado para agendamento de horários em uma barbearia. A API permite visualizar horários disponíveis, realizar agendamentos, cancelar agendamentos e consultar os preços dos serviços.

**Fluxo do sistema:**  `Controller → DTO → Service → Repository → Entity`

---
## Status
🟡 Em desenvolvimento

---
## Tecnologias 
- Java 17
- Maven
- PostgreSQL
- IntelliJ IDEA
- Spring Boot 
- Lombok
- Padrão MVC (Entity - View - Controller)
- Injeção de dependência com Spring


---
## Funcionalidades
- Ver dias e horários disponíveis para agendamento
- Realizar agendamentos e cancelamentos com validação de horários e nomes
- Exibir mensagens de forma interativa via terminal
- Separação clara por camadas (entidade, serviço, repositório e visualização)
- Armazenamento dos agendamentos usando o banco de dados PostgreSQL
- Estrutura modular: `Entity`, `Service`, `Repository`, `DTO`, `Mapper` e `View`


---
##  Futuras Melhorias
- Criar uma API REST (`@RestController`) para expor os serviços via HTTP
- Utilizar requisições HTTP com `GET`, `POST`, `DELETE`, etc.
- Utilizar `@RequestBody` e `@ResponseBody` para enviar/receber JSON
- Implementar tratadores globais de exceção (@ControllerAdvice)
- Criar endpoints para agendamento, cancelamento, listagem e visualização


---
## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/chatbot-api.git

Desenvolvido por [Brenda Nunes] (https://github.com/Iochem)
