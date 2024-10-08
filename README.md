# VacationCalculator

Калькулятор отпускных. Приложение принимает среднюю зарплату за 12 месяцев и количество дней отпуска, а отвечает суммой отпускных, которые придут сотруднику. При запросе также можно указать точные дни ухода в отпуск, тогда проводиться рассчет отпускных с учётом праздников и выходных.

# Использованные технологии
* [Java](https://www.java.com/) – язык программирования
* [Spring Boot](https://spring.io/projects/spring-boot) – как основной фрэймворк
* [Mockito](https://site.mockito.org/) – для тестирования
* [Gradle](https://gradle.org/) – как система сборки приложения

# Как начать разработку?

1. Сначала необходимо перейти по ссылке
```shell
https://github.com/INT1NGLENCE/VacationCalculator
```
2. На открвышемся сайте нужно склоинровать репозиторий в IntelligIdea
```shell
#URL для Get from Vcs
https://github.com/INT1NGLENCE/VacationCalculator.git
```
  Для этого необходимо:
* При открытии приложения выбрать вкладку 
```shell
Get from VCS
```
* Во вкладку URL вставить URL репозитория:
```shell
#URL для Get from Vcs
https://github.com/INT1NGLENCE/VacationCalculator.git
```
* Нажмите "Clone"
3. Ждём полного клонирования репозитория и установки всех необходимых зависимостей для проекта

4. Далее нам необходимо перейти в gradle, который находится в правой части IntelligIdea.
* Открываем папку Tasks
* После чего открываем папку build
* И запускаем комманду build.

5. Ждём окончания комманды build.

6. Проект готов. 
* Проверить работоспособность проект вы можете с помощью программы [Postman](https://www.postman.com/downloads/)(установите программу при её отсутсвии)
* Для этого необходимо:
1. Запустить приложение с помощью основного класса Main:
* Перейдите в дерево проекта слева и найдите класс Main.
* Нажмите на него правой кнопкой мыши и выберите "Run".(или же нажмите комбинацию клавиш --> Ctrl + Shift + F10)
2. Дождитесь окончания компиляции проекта и перейдите в Postman, если ошибок не возникло:
* В ссылочном поле выберите GET
* Укажите ссылку
```shell
http://localhost:8080/calculate
```
* Далее выберите параметр "Body"
* В параметре "Body" выберите "raw"
* убедитесь, что стоит "JSON" и в появившемся окне напишите:
```shell
# 200 OK (результат вычисления)
{
  "averageSalary": 545000.0,
  "vacationDays": 10,
  "periodVacation": ["2024-09-09", "2024-09-22"]
}
```
# Тесты
Тесты покрывают все возможные сценарии работы приложения и написаны на все классы проекта
* Mockito
* MockMvc
* JUnit5
