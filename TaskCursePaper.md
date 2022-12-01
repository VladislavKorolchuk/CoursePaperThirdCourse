https://github.com/VladislavKorolchuk/CoursePaperThirdCourse/pull/1

### Путь пользователя

1. Пользователь обращается к некому эндпоинту по адресу (”/exam/get/{amount}”)
2. Пользователь получает ответ в виде списка случайных вопросов-ответов, количество которых равно amount из прошлого шага
3. Пользователь должен иметь возможность добавить, получить и удалить вопросы из хранилища вопросов (”/exam/java/(add/remove/find)”)

### Реализация приложения

Для упрощения архитектурного понимания, вам будут даны подсказки по организации проекта.

1. Реализовать сущность Question с двумя полями: question и answer. Данная сущность будет использоваться в качестве хранителя данных по вопросу.
    - Архитектура

      ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/80201e85-0c39-427b-955a-2a2dffa930b0/Untitled.png)

2. Сделать интерфейс QuestionService, который будет содержать в себе все методы по работе с вопросами определенного предмета.
    - Архитектура

      ![diagram-17353247503607978677.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a4c0fece-02d6-41f3-bf07-24da115beee9/diagram-17353247503607978677.png)

3. Реализовать сервис JavaQuestionService, который будет реализовывать QuestionService и хранить в себе список вопросов по Java, а также осуществлять всю работу с этим списком.

   Реализация метода getRandomQuestion осуществляется с помощью класса Random и его метода nextInt, который в качестве параметра принимает максимальное число, а затем возвращает вам результат в виде случайного числа от 0 до максимального числа из параметров (не включительно).

    - Архитектура

      ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b0d0166a-6f2d-41f2-9b00-ad0cb675ea11/Untitled.png)

4. Реализовать контроллер JavaQuestionController, который будет предоставлять возможность пользователю добавлять, просматривать и удалять вопросы по Java в соответствующем QuestionService.

   Контроллер должен иметь три метода: добавить, удалить и получить все вопросы.

   Эти методы должны висеть на следующих эндпоинтах:

   Добавить: “/exam/java/add?question=QuestionText&answer=QuestionAnswer”

   Удалить: “/exam/java/remove?question=QuestionText&answer=QuestionAnswer”

   Получить все вопросы: “/exam/java”

    - Архитектура

      ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/20e1b4ad-1631-4a4c-8b99-35bcf5c0d247/Untitled.png)

5. Сделать интерфейс ExaminerService с одним методом getQuestions.

   Этот интерфейс должен содержать один метод, который вернет список вопросов.

    - Архитектура

      ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/09fcb326-fcd6-4f22-887b-88266928110d/Untitled.png)

6. Реализовать ExaminerServiceImpl, который является реализацией интерфейса из прошлого шага. Данный сервис должен внутри себя хранить поля типа QuestionService.

   Его задача: создать коллекцию и заполнить её с помощью вызова getRandomQuestion у QuestionService случайными вопросами.

   Учтите:

    1.  Вопросы должны быть уникальные, следовательно, для получения 5 вопросов может потребоваться более 5 вызовов метода getRandomQuestion сервиса вопросов.
    2. Если запрошено большее количество вопросов, чем хранится в сервисе, нужно выкинуть исключение. Для этого, соответственно, нужно написать свое исключение со статусом BAD_REQUEST.
    - Архитектура

      ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4cb9d332-c716-4734-9642-22eb2969ea17/Untitled.png)

7. Реализовать контроллер ExamController с одним методом getQuestions(int amount).

   Контроллер должен обратиться к ExaminerService, получить от сервиса коллекцию вопросов и вернуть пользователю.

8. Покрыть юнит-тестами JavaQuestionService и ExaminerServiceImpl (потребуется мок).