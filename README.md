# Desafio Citel

## Ferramentas
* Java 11
* Angular CLI: 16.1.4
* Node: 18.10.0
* H2Database
* Arquitetura Rest (com SpringBoot)

## Banco de dados
<p>Para entender melhor como utilizar o desafio, desenvolvi Modelo de Entidades e Relacionamentos para que todas tabelas tenham seu uso, com isso alem de verificar questões de "pai" e "mae" que também são pessoas, separei dados sensiveis de anonimos para consumo</p>
<p>link para MER: <a target="_blank" href="https://drive.google.com/drive/u/0/folders/1lYI5o3tdgmVmwEG-Wt9eo0mr9aQQy6tr"> clicando aqui</a></p>
<p>Utilizado banco de dados na memoria Java pois minha maquina de uso pessoal esta exclusivo Postgresql como user, que conflitou diretamente o uso do servico do MySQL</p>
<p>Para acessar o servidor de banco, basta subir o projeto e acessar: http://localhost:8080/server/h2</p>
<p>Dados de acesso (pode ser visualizado em application.properties também):</p>

* org.h2.Driver
* jdbc:h2:mem:citel
* sa
* sem senha

## Front-end
<p>2 telas, uma aguardando dados serem adicionados no banco para seu uso, outra para subir o arquivo .JSON</p>
<p>2 npm terceiros (sweetAlerts e eCharts): "npm install"</p>
<p>subir projeto: "ng serve"</p>

## Backend
<p>o pom.xml esta somente com repositorio maven, basta executar o "update maven project"</p>

## Detalhes
O grande desafio estava em como migrar as pessoas como mae e pai e futuramente receber atualizações, o que no caso somente a tabela pessoa que ao cadastrar, conforme arquivo enviado (300) sera cadastrado 900 pessoas, sendo 300 do usuario, 300 mae (null) e 300 pai (null).
Com isso, realizei rotina de buscar CPF, depois de nomes para atualização e para vinculos parentesco e nao deixar ele gerar 'lixos' de dados que assim atrapalharia a integridade da analise de dados.

Pensando em larga escala de ancestralidade, foi adicionado o lazy e o hibernateLazyInitializer, onde somente continua a busca de gerações se houver o get/set mas que nao progredi por nao ser o foco do desafio.

O sistema de buscar e transformar em dados úteis para o usuario consumir foi todo pensando em gráficos, podendo ver sua classe e seus geradores organizados e separados.
