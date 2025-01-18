# ms-moneda

Proyecto generado con spring boot 3.3.7

## Caracteristicas
- Utilización de Java 17.
- Crud básico para tabla creada en H2.
- Manejo de HttpStatus.
- POST, creación de un nuevo registro.
- GET con paginación, mediante @ModelAttribute que contiene todos los campos de la tabla.
- UPDATE, actualización de un registro ya existente sin alterar la clave compuesta.
- DELETE, eliminación de registro mediante ID principal.
- Utilización de JpaRepository.
- Lombok, creacion de metodos con anotaciones @Data, etc.
- MapStruct, para mapeo entre entidades y dtos.
- Swagger para documentación.

## Ejecución de proyecto con repositorio clonado.

- git clone https://github.com/Hugo-Medellin/ms-moneda.git
- cd ms-moneda
- importar proyecto en Spring Tool Suite.
- ejecutar microservicio.

## Ejecución de proyecto con docker-compose
Revisar documentación de [Repositorio CrudApp](https://github.com/Hugo-Medellin/crudApp)
