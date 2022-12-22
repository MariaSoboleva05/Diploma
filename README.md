# Порядок действий для запуска автотестов
	
1. Запустить Docker Desktop (скачать и установить, если не установлен)  
2. Скачать и установить Node.js (или запустить его с помощью Docker Desktop)  
3. Открыть проект в IntelliJ IDEA (скачать и установить, если не установлен)  
4. В терминале в корне проекта запустить контейнеры с БД: `docker-compose up`  
5. В терминале в папке gate-simulator запустить симулятор банковских сервисов: `npm start`  
6. В новом окне терминала в корне проекта запустить приложение под БД MySQL: `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`  
7. В новом окне терминала в корне проекта запустить тесты: `./gralew clean test "-Dselenide.headless=true"`
8. Когда все тесты завершатся, сгенерировать и вывести отчет Allure при помощи команды в терминале: `./gradlew allureserve`
9. В окне терминала, в котором было запущено приложение, нажать ctrl+C, чтобы остановить приложение  
10. Запустить приложение под БД PostgresSQL при помощи команды в терминале: `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`  
11. В новом окне терминала в корне проекта запустить тесты: `./gralew clean test "-Dselenide.headless=true"`  
12. Когда все тесты завершатся, сгенерировать и вывести отчет Allure при помощи команды в терминале: `./gradlew allureserve`