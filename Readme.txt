Criar Projeto Quarkus linha de comando
- mvn io.quarkus.platform:quarkus-maven-plugin:2.3.0.Final:create

Compilar o projeto
- mvnw compile quarkus:dev

Incluir dependecias no projeto
- mvn quarkus:add-extensions -Dextensions="hibernate-validator"
mvn quarkus:add-extensions -Dextensions="jdbc-h2,hibernate-orm,hibernate-orm-panache,resteasy-jsonb"