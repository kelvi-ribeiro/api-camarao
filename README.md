# prj-macuxi-camarao-backend
API (Application Programming Interface) que é usada para gerar as medições das propriedades que um tanque camarão possui(Amonia Total, Nitrato, Nitrito, Oxigênio Dissolvido, Salinidade, Temperatura e Transparência ) automaticamente através de rotinas e CRUD de Usuários, Mensagens e Tanques. 

Como é um protótipo, foi feita a integração com o Arduino apenas com propriedade de Temperatura, e o [Projeto Arduino](https://github.com/kelvi-ribeiro/prj-arduino-camarao), porém, você não precisa de um Arduino para executar esta API, caso deseje um integração com Arduino, apenas retire a chamada do método que gera a Propriedade de Temperatura no arquivo de com.macuxi.camarao.services.BackGroundService, no projeto Arduino, basta configura-lo que ele enviará os dados de temperatura para esta API. Também existe um [Projeto Frontend](https://github.com/kelvi-ribeiro/app-camarao) que é integrado com essa API.

Primeiros Passos
Após clonar o Projeto, basta que você baixe as dependências com o Maven e crie um Banco de Dados chamado bd_camarao e dentro do arquivo de configurações do projeto, insira as credenciais do seu SGBD.

## Autores

* **Kelvi Ribeiro** - *Initial work* - [PurpleBooth](https://github.com/kelvi-ribeiro)



## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
