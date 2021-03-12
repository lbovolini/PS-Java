# Avaliação Java


## Descrição

  Pseudo ecommerce de games mobile utilizando Java

## Execução com Docker

  - Build e execução

  ```bash
    export DOCKER_BUILDKIT=1  
    export COMPOSE_DOCKER_CLI_BUILD=1
    docker-compose up --build
  ```

  - Criar base de dados

  ```bash
    docker-compose exec game_store_mariadb mysql -udev -pdev -e "$(cat database/create.sql)"
  ```

  - Interromper execução
  ```bash
    docker-compose down
  ```

## Como executar os testes
  
  O projeto usa o maven warper (mvnw).
  Para executar os testes de exemplo basta o comando abaixo:
  ```sh
  ./mvnw clean test
  ```

## Detalhes de implementação

 O carrinho de compras é salvo na base de dados e não em uma sessão para atender às restrições da arquitetura REST, que deve ser *stateless*.