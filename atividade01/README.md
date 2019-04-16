##Desenvolvimento de Software para Web
###Atividade Avaliativa 1 - 20680 - TURMA B - Quinta-feira
###Sistema para locação de bicicletas
---------------------------------------------
###Requisitos
O sistema deve possuir um cadastro de clientes, com os seguintes dados: e-mail,senha, CPF,  nome, telefone,  sexo e data de nascimento.
O sistema deve possuir um cadastro de locadoras, com os seguintes dados: e-mail, senha, CNPJ,  nome e cidade.
O sistema deve possuir um cadastro de locações, com os seguintes dados: CPFdo cliente, CNPJ da locadora e dia/horário da locação. Assume-se que a duraçãoda locação é de 1 hora e sempre inicia-se em “hora cheia” (13h 00min etc)
O sistema deve atender aos seguintes requisitos:
- R1: CRUD1 de clientes (requer login de administrador)
- R2: CRUD de locadoras (requer login de administrador)
- R3: Listagem de todos as locadoras em uma única página (não requerlogin)
- R4: Listagem de todos as locadoras por cidade (não requer login)
- R5: Locação de uma bicicleta em uma locadora (requer login do cliente viae-mail + senha). Depois de fazer login, o cliente pode cadastrar umalocação. Para isso, deve escolher uma locadora (digitando seu CNPJ ouescolhendo a partir de uma lista), uma data, e deve ser gravado a locaçãona base de dados.
- R6: Listagem de todas as locações de um cliente (requer login do clientevia e-mail + senha). Depois de fazer login, o cliente pode visualizar todasas suas locações gravadas.
- R7: O sistema não deve permitir o cadastro de locações de um mesmocliente ou de um mesma locadora em um mesmo dia/horário.
- R8: Listagem de todas as locações de uma locadora (requer login dalocadora via e-mail + senha). Depois de fazer login, a locadora podevisualizar todas as suas locações gravadas.
- R9: O sistema deve ser internacionalizado em pelo menos dois idiomas:português + outro de sua escolha.O sistema deve tratar todos os erros possíveis (cadastros duplicados, problemastécnicos, etc) mostrando uma página de erros amigável ao usuário e registrandoo erro no console.

---------------------------------------------
###Tecnologias
Arquitetura: Modelo-Visão-Controlador

Tecnologias: 
- JSP
- Servlet & JDBC (Lado Servidor) 
- Javascript & CSS (Lado Cliente)

¹CRUD: Create, Read, Update & Delete

---------------------------------------------
###Como instalar

---------------------------------------------
###Grupo
- Cassiano Maia -726507
- Rodrigo Pesse de Abreu - 726588



