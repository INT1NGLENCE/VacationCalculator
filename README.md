# VacationCalculator

Калькулятор отпускных. Приложение принимает среднюю зарплату за 12 месяцев и количество дней отпуска, а отвечает суммой отпускных, которые придут сотруднику.При запросе также можно указать точные дни ухода в отпуск, тогда проводиться рассчет отпускных с учётом праздников и выходных.

# Использованные технологии
* [Java](https://www.java.com/) – язык программирования
* [Spring Boot](https://spring.io/projects/spring-boot) – как основной фрэймворк
* [Mockito](https://site.mockito.org/) – для тестирования
* [Gradle](https://gradle.org/) – как система сборки приложения

# Как начать разработку?

1. Сначала нужно скачать и установить DockerDekstop
```shell
https://docker.qubitpi.org/desktop/install/windows-install/
```
2. Далее необходимо скачать Jdk amazoncorretto:19.0.2 для IntelligIdea
3. Далее необходимо перейти по ссылке
```shell
https://github.com/INT1NGLENCE/Management_service
```
2. На открвышемся сайте нужно склоинровать репозиторий
```shell
#команда для терминала
git clone https://github.com/INT1NGLENCE/Management_service.git
```

```shell
#URL для Get from Vcs
https://github.com/INT1NGLENCE/Management_service.git
```
3. Ждём полного клонирования репозитория и установки всех необходимых зависимостей для проекта

4. Далее нам необходимо перейти в gradle, который находится в правой части IntelligIdea.
* Открываем папку Tasks
* После чего открываем папку build
* И запускаем комманду build.

5. Ждём окончания комманды build.

6. Проект готов.
# Код

RESTfullApi приложения - это система управление задачами

* Обычная трёхслойная
  архитектура – [Controller](src/main/java/management.system/controller), [Service](src/main/java/management.system/service), [Repository](src/main/java/management.system/repository)
* Слой Repository реализован и на jdbcTemplate, и на JPA (Hibernate)
* Написан [GlobalExceptionHandler](src/main/java/management.system/exception/GlobalExceptionHandler.java)
  который умеет обрабатьвывать все необходимые для приложения исключения и прокидывать их в [ExceptionHandler](src/main/java/management.system/exception)
* Настроена конфигурация [Spring Security](src/main/java/management.system/security)
  которая отвечает за регистрация и аунтификацию пользователей для системы управления задачами
* Настроена конфигурация [Swagger](src/main/management.system/swagger) для документации системы управления задачами

# Тесты
Тесты покрывают все возможные сценарии работы приложения и написаны на все классы проекта
* MockMvc
* JUnit5
