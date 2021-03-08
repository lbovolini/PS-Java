# Avaliação Java


## Descrição

  Pseudo ecommerce de games mobile utilizando Java

## Como executar os testes
  
  O projeto usa o maven warper (mvnw).
  Para executar os testes de exemplo basta o comando abaixo:
  ```sh
  ./mvnw clean test
  ```

## Detalhes de implementação

 O carrinho de compras é salvo na base de dados e não em uma sessão para atender às restrições da arquitetura REST, que deve ser *stateless*.