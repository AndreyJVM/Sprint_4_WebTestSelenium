# Финальный проект 4 спринта

# 1. Подготовить проект
Собери в IDE Maven-проект. Пригодятся инструкции из темы «Локальная среда разработки». Обрати внимание: нужно использовать Java 11.
Подключи JUnit 4.
Подключи Selenium. Если не помнишь, как это сделать, вернись к инструкции из темы «Selenium».
Установи Google Chrome и Mozilla Firefox: они понадобятся, чтобы выполнить задание.
# 2. Изучить тестовые сценарии
# Тестовые сценарии
1. Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
2. Заказ самоката. Весь флоу позитивного сценария. Обрати внимание, что есть две точки входа в сценарий: кнопка «Заказать» вверху страницы и внизу.
   Из чего состоит позитивный сценарий:
- Нажать кнопку «Заказать». На странице две кнопки заказа.
- Заполнить форму заказа.
- Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.

Нужно написать тесты с разными данными: минимум два набора. Какие именно данные использовать — на твоё усмотрение.
Обрати внимание: в приложении есть баг, который не даёт оформить заказ. Он воспроизводится только в Chrome.
Ты можешь заметить этот баг, когда будешь писать тесты или запускать их. Ещё может случиться так: тест наткнётся на баг и упадёт. Пусть тебя это не смущает: если тест помог найти неисправность, это хорошо.

# 3. Написать тесты
1. Определи, какие локаторы нужны, чтобы автоматизировать тестовые сценарии. Размести в пакете класс, чтобы описать элементы главной страницы. Выпиши все элементы в список с помощью комментариев. Названия должны быть понятными, чтобы с ними было удобно работать. Так ты ничего не упустишь, когда будешь искать локаторы.
2. Под каждым элементом в списке запиши локатор этого элемента.
3. Опиши необходимые локаторы с помощью Page Object.Создай отдельный пакет для Page Object.
   Для каждой страницы нужно создать отдельный класс с Page Objec
4. Напиши тесты на Selenium.
    - Организуй файлы проекта. Все тесты должны лежать в директории test. Тесты нужно разделить по тематике или функциональности. Обрати внимание: не нужно создавать отдельный класс для каждого теста. Добавь тесты на одну функциональность в один класс.
    - Убедись, что закрываешь браузер. Метод driver.quit(); нужно использовать в конце каждого теста.
    - Проверь, что тесты запускаются. Они должны проходить хотя бы в одном браузере. Нужно отправить тесты на ревью с подключённым Google Chrome.
    - Отчёт о тестировании не нужен.

# 4*. Написать тесты по дополнительным тестовым сценариям
Выполнять это задание необязательно: оно не повлияет на зачёт.
Сдавать задания можно только одновременно с обязательной частью работы. Если отправишь обязательную часть на проверку, дополнительные задания сдать не получится.

Дополнительные тестовые сценарии
- Проверить: если нажать на логотип «Самоката», попадёшь на главную страницу «Самоката».
- Проверить: если нажать на логотип Яндекса, в новом окне откроется главная страница Яндекса.
- Проверить ошибки для всех полей формы заказа.
- Проверить: если ввести неправильный номер заказа, попадёшь на страницу статуса заказа. На ней должно быть написано, что такого заказа нет.

# 5. Отправить результат на проверку