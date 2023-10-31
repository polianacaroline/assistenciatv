# assistenciatv
24/10/2023

inicialização do site: 

Criação da página Home, colocamos degradê de fundo, menu e roda pé, adicionamos videos, botão e imagens. 
adicionamos o carrosel de marcas, falamos sobre a empresa e seus beneficios.

 ![contato77](https://github.com/polianacaroline/assistenciatv/assets/104094484/f850dc22-5f27-4f42-af53-8904a93710ef)
![home](https://github.com/polianacaroline/assistenciatv/assets/104094484/bd81a232-ef62-41d6-b32f-e44bd3de53a4)


Criação da página Contato:

colocamos degradê de fundo, menu e roda pé, adicionamos videos, botão e imagens.
adicionamos um google maps, o endereço da empresa, icones de contatos e avaliação.

![contato](https://github.com/polianacaroline/assistenciatv/assets/104094484/67ac778e-48c3-4e2b-8e68-4aea1cd5fb4c)
![contato1](https://github.com/polianacaroline/assistenciatv/assets/104094484/c9d2a2e4-902d-40b4-9381-690e9ac95422)


Login de aplicativo para desktop (Windows, Linux ou MAC) de repositório de informações para acesso com o Usuário.

![TelaLogin](https://github.com/polianacaroline/assistenciatv/assets/104094484/b45e448f-f457-45f9-8d00-3270b57ad535)
# Instruções para instalação e uso do aplicativo
## Pré requisitos 

 1. Ter o Java versão 17 ou superior instalado. Testado com a versão openJDK 21 LTS que pode ser obtida no link indicado. Na instalação selecione todos os recursos conforme indicado na imagem.
[Download openJDK](https://adoptium.net/).

![openjdk](https://github.com/polianacaroline/assistenciatv/assets/104094484/e2f2dfda-ade7-4dda-87e6-4ff3591707a5)

 2. Ter um banco de dados local baseado no MySQL 8 ou MariaDB compatível, no exemplo usei o XAMPP que pode ser obtido no link indicado.
[Download XAMPP](https://www.apachefriends.org/)

# Instalação do banco

 1. Iniciar os serviços Apache e MySQL no XAMPP, conforme indicado na imagem.
    
![xampp1](https://github.com/polianacaroline/assistenciatv/assets/104094484/6515bd96-871a-4e74-884d-61dd40a3fe01)

 2. No navegador de internet digite: localhost/dashboard e selecione no menu: phpMyAdmin conforme indicado na imagem.
    
![xampp2](https://github.com/polianacaroline/assistenciatv/assets/104094484/d3dec7f1-b919-47a0-a602-75581af70aff)

 3. Crie um novo banco de dados de nome dbcarometro (sem usar acentuação) conforme indicado na imagem.
  
![xampp3](https://github.com/polianacaroline/assistenciatv/assets/104094484/877b46ff-bb18-4e0c-b8e2-504ef6a763d1)

 4. Na aba SQL, copie e cole o código abaixo e execute. (Passos 1,2 e 3 indicados na imagem)
    
    CREATE TABLE alunos (ra int PRIMARY KEY AUTO_INCREMENT,nome varchar(30) NOT NULL,foto LONGBLOB NOT NULL);
    
![xampp4](https://github.com/polianacaroline/assistenciatv/assets/104094484/ead02bda-f5b3-4487-a6fa-04d9c1e2408b)

# Instalação do aplicativo
 1. Em Releases faça o download do arquivo Login.jar

 2. Execute e verifique no rodapé o ícone que representa o banco de dados conectado. Se estiver com erro (conforme indicado na figura) verifique o XAMPP e revise novamente os passos 1 a 4 da instalação do banco.

    ![desligado](https://github.com/polianacaroline/assistenciatv/assets/104094484/9da121ec-c8c7-43c1-9d1a-9d2101765403)

 3. Se tudo estiver OK você pode iniciar gerando uma busca pelo Usuário padrão.
    
    Login: ("admin")
    
    Senha: ("admin")


# Sistema OS

Tela Login:

Essa Tela acessa a tela principal, ultilizando seu usuário.

![TelaLogin](https://github.com/polianacaroline/assistenciatv/assets/104094484/b45e448f-f457-45f9-8d00-3270b57ad535)


                
Tela Principal:

Essa Tela acessa os Usuário, Clientes, Fornecedores, Serviços, Relatório, Produtos.

![TelaPrincipal](https://github.com/polianacaroline/assistenciatv/assets/104094484/99a8cb0c-52c6-446b-a5c3-b55d5231b598)

Tela Fornecedores:

Essa Tela cadastra fornecedores.
![TelaFornecedores ](https://github.com/polianacaroline/assistenciatv/assets/104094484/c48c8575-47a8-4e6a-83f1-b00f9b0a7f92)

Tela Clientes:


![TelaClientes](https://github.com/polianacaroline/assistenciatv/assets/104094484/bd285d6b-3009-4c92-aa83-ce8269bff729)

Tela Usuário:

![TelaUsuarios](https://github.com/polianacaroline/assistenciatv/assets/104094484/8c22a39d-69cd-42fa-9ea3-e0ff44dcead2)

Tela Sobre:

![TelaSobres](https://github.com/polianacaroline/assistenciatv/assets/104094484/62ecc091-7456-4b00-8c80-b1225d9d1fae)

Tela Serviço:

![TelaServicos](https://github.com/polianacaroline/assistenciatv/assets/104094484/4d8c6a77-2d28-4127-84ba-bd9cb1d82ad7)

Tela Relatório:

![TelaRelatorios](https://github.com/polianacaroline/assistenciatv/assets/104094484/1c288aff-68a9-4019-8b5d-8db6e46cd724)

Tela Produto: 

![TelaProdutos](https://github.com/polianacaroline/assistenciatv/assets/104094484/83eda0d4-3758-4065-8bfc-c089a1ae5360)
