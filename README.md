# services

# Deploy da aplicação

Para o teste da aplicação foi utilizado o wildfly-10.1.0.Final que pode ser baixado na url http://download.jboss.org/wildfly/10.1.0.Final/wildfly-10.1.0.Final.zip

Dentro da pasta resources da aplicação existe alguns arquivos que devem ser copiados para o diretório do Wildfly.
São eles:

module.xml - copiar para $WILDFLY_HOME/modules/system/layers/base/com/mysql/main

standalone.xml - copiar para $WILDFLY_HOME/standalone/configuration

Depois disso baixar o mysql-connector mysql-connector-java-5.1.9.jar e copiar para a pasta $WILDFLY_HOME/modules/system/layers/base/com/mysql/main


# Iniciando a aplicação

Bastar entrar no diretório da aplicação e digitar o comando

mvn wildfly:run -Dmaven.test.skip=true
