# Getting Started

## Reference Documentation

For further reference, please consider the following sections:

- [Official Apache Maven documentation][maven-guides]
- [Spring Boot Maven Plugin Reference Guide][spring-boot-maven]
- [Create an OCI image][spring-boot-build-image]
- [Spring Web][spring-web]
- [Spring Data JPA][spring-data-jpa]

## Guides

The following guides illustrate how to use some features concretely:

- [Building a RESTful Web Service][guide-rest-service]
- [Serving Web Content with Spring MVC][guide-serving-web]
- [Building REST services with Spring][guide-rest-tutorial]
- [Accessing Data with JPA][guide-accessing-jpa]
- [Accessing data with MySQL][guide-accessing-mysql]

## Maven Parent overrides

Due to Maven's design, elements are inherited from the parent POM to the
project POM. While most of the inheritance is fine, it also inherits
unwanted elements like `<license>` and `<developers>` from the parent. To
prevent this, the project POM contains empty overrides for these elements.
If you manually switch to a different parent and actually want the
inheritance, you need to remove those overrides.

[maven-guides]: https://maven.apache.org/guides/index.html
[spring-boot-maven]: https://docs.spring.io/spring-boot/3.5.10/maven-plugin
[spring-boot-build-image]: https://docs.spring.io/spring-boot/3.5.10/maven-plugin/build-image.html
[spring-web]: https://docs.spring.io/spring-boot/3.5.10/reference/web/servlet.html
[spring-data-jpa]: https://docs.spring.io/spring-boot/3.5.10/reference/data/sql.html#data.sql.jpa-and-spring-data
[guide-rest-service]: https://spring.io/guides/gs/rest-service/
[guide-serving-web]: https://spring.io/guides/gs/serving-web-content/
[guide-rest-tutorial]: https://spring.io/guides/tutorials/rest/
[guide-accessing-jpa]: https://spring.io/guides/gs/accessing-data-jpa/
[guide-accessing-mysql]: https://spring.io/guides/gs/accessing-data-mysql/
