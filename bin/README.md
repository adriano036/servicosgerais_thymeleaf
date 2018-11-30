-  No mysql no cmd crie um usuário servicosgerais com a senha o projeto e atribua todas as permissões sobre a database servicosgerais

-  Dentro da pasta wildfly-11\modules\system\layers\base\com,  adicione uma pasta mysql com um arquivo xml module.xml e um jar mysql-connector...   e coloque um <driver> no standalone.xml do wildfly (conforme https://synaptiklabs.com/posts/adding-the-mysql-jdbc-driver-into-wildfly/)

-  Crie um datasource non-xa no console do wildfly com:
	Connection URL:     jdbc:mysql://den1.mysql1.gear.host:3306/servicosgerais
	Nome: 	            MySqlDS
	Usuário:            igual ao usuário do projeto
	Senha:              igual a senha do projeto

-swagger: swagger-ui.html#