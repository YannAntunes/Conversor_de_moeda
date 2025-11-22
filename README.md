🪙 Conversor de Moedas em Java

Este projeto é um conversor de moedas desenvolvido em Java, utilizando uma API de taxas de câmbio em tempo real.
O programa oferece um menu interativo via console, permitindo realizar diversas conversões com valores sempre atualizados.

🚀 Funcionalidades

Conversões entre diferentes moedas

Consulta de taxas em tempo real

Menu intuitivo no console

Requisições HTTP com HttpClient

Leitura de JSON com Gson

🛠 Tecnologias Utilizadas

Java 11+

HttpClient (Java)

Gson

ExchangeRate-API

🔗 API Utilizada
https://v6.exchangerate-api.com/v6/bfb25d9305d942483f6ff4a4/latest/USD

▶ Como Executar

Clone o repositório:

git clone <url-do-repositorio>


Certifique-se de ter o arquivo gson.jar ou uma dependência configurada.

Compile:

javac -cp gson-2.11.0.jar Main.java


Execute:

java -cp .;gson-2.11.0.jar Main


(No Linux/Mac use : no lugar de ; no classpath.)

📂 Estrutura do Projeto

src/

 └── ConversorDeMoedas.java

🤝 Contribuições

Contribuições são bem-vindas!

Sinta-se à vontade para abrir issues e enviar pull requests.

📄 Licença

Este projeto está sob a licença MIT.
