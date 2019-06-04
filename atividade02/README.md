## Atividade Avaliativa 02 - Sistema para locação de bicicletas
### Requisitos
O sistema deve possuir um cadastro de clientes, com os seguintes dados: e-mail, senha, CPF,  nome,  telefone,  sexo e data de nascimento. 
O sistema deve possuir um cadastro de locadoras, com os seguintes dados: e-mail, senha, CNPJ,  nome e cidade. 
O sistema deve possuir um cadastro de locações, com os seguintes dados:cliente, locadora e dia/horário da locação. 
Assume-se que a duração da locação éde 1 hora e sempre inicia-se em “hora cheia” (13h 00min etc).

O sistema deve atender aos seguintes requisitos:
- **R1:** CRUD de clientes (requer login de administrador).
- **R2:** CRUD de locadoras (requer login de administrador).
- **R3:** Listagem de todos as locadoras em uma única página (não requer login).
- **R4:** Listagem de todos as locadoras por cidade (não requer login). Para tal,deve-se digitar o nome da cidade ou escolher a cidade a partir de umalista.
- **R5:** Locação de uma bicicleta em uma locadora (requer login do cliente viae-mail + senha). Depois de fazer login, o cliente pode cadastrar uma locação. Para isso, deve escolher uma locadora (a partir de uma lista), um dia/horário, e deve ser gravado a locação na base de dados.
- **R6:** Listagem de todas as locações de um cliente (requer login do clientevia e-mail + senha). Depois de fazer login, o cliente pode visualizar todasas suas locações gravadas.
- **R7:** O sistema não deve permitir o cadastro de locações de um mesmo cliente ou de um mesma locadora em um mesmo dia/horário.
- **R8:** Listagem de todas as locações de uma locadora (requer login dalocadora via e-mail + senha). Depois de fazer login, a locadora pode visualizar todas as suas locações gravadas.
- **R9:** O sistema deve ser internacionalizado em pelo menos dois idiomas:português + outro de sua escolha.

O sistema deve tratar todos os erros possíveis (cadastros duplicados, problemastécnicos, etc) mostrando uma página de erros amigável ao usuário e registrando o erro no console. Além disso, o sistema deve proporcionar máscaras (telefone,CNPJ, CPF, e-mail, etc) para entrada dos dados.
Arquitetura: Modelo-Visão-Controlador

Tecnologias: 
- JSF/PrimeFaces & JPA (Lado Servidor)                    
- Javascript & CSS (Lado Cliente)
---------------------------------------------
### Grupo
- Cassiano Maia -726507
- Rodrigo Pesse de Abreu - 726588
