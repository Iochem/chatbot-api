# API Chatbot Atendimentos #
Este é um projeto em Java para um chatbot de atendimento automatizado, voltado para agendamento de horários em uma barbearia. A API permite visualizar horários disponíveis, realizar agendamentos, cancelar agendamentos e consultar os preços dos serviços.

Fluxo: `Controller → ClienteDTO → ClienteService → ClienteRepository → Map`

## Tecnologias 
- Java 17
- Spring Boot (em preparação)
-  Padrão MVC (Entity - View - Controller)
- Injeção de dependência com Spring
- Maven
- IntelliJ IDEA


##  Funcionalidades
- Ver dias e horários disponíveis para agendamento
- Visualizar preços dos serviços (cortes de cabelo e barba)
- Realizar agendamentos e cancelamentos com validação de horários e nomes
- Exibir mensagens de forma interativa via terminal
- Separação clara por camadas (entidade, serviço, repositório e visualização)
- Armazenamento dos agendamentos usando estrutura `Map<String, String>`
- Estrutura modular com `Entity`, `Service`, `Repository` e `View`


##  Futuras Melhorias
- Criar uma API REST (`@RestController`) para expor os serviços via HTTP
- Utilizar requisições HTTP com `GET`, `POST`, `DELETE`, etc.
- Utilizar `@RequestBody` e `@ResponseBody` para enviar/receber JSON
- Implementar testes unitários
- Implementar tratadores globais de exceção (@ControllerAdvice)
- Conectar o chatbot ao Telegram
- Criar endpoints para agendamento, cancelamento, listagem e visualização



## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/chatbot-api.git

Desenvolvido por [Brenda Nunes] (https://github.com/Iochem)
