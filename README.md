# CrudEmployee
Стек: Java 8, Maven, Spring, PostgreSQL.  
Перед запуском нужно создать базу TestGnivcDb и указать user/password в application.properties (по-умолчанию root/root).  
В папке src/main/resources/requests/testRequests.http есть примеры запросов.
## API
1. GET localhost:8080/employees - получить список всех сотрудников;
1. POST localhost:8080/employees - создать сотрудника;
1. GET localhost:8080/employees/id/{id} - получить сотрудника по ID;
1. GET localhost:8080/employees/serviceNumber/{serviceNumber} - получить сотрудника по табельному номеру;
1. GET localhost:8080/employees/salary/{salary1}&{salary2} - получить список сотрудников с заданным интервалом зарплаты;
1. PUT localhost:8080/employees/id/{id} - обновить данные сотрудника с заданным ID;
1. DELETE localhost:8080/employees/{id} - удалить сотрудника с заданным ID.
