# TramTimeApp

Проект предназначен для поэтапного обучения работы с технологиями програмирования.
Список технологий:
	* git
	* Apache Maven
	* jsoup

Приложение предполагает вывод данных о времени прибытия трамваев на выбраную остановку согласно расписанию указаному на сайте [http://rozklad.monp.org.ua](http://rozklad.monp.org.ua)
Проект будет состоять из нескольких частей:
* Парсер сайта - использование библиотеки[jsoup](http://jsoup.org) для парсинга расписания и формирования файла с данными, который будет исспользован в дальнейшем мобильным приложением.
* Мобильное приложение - Android приложение для графического отображения маршрутов трамваев и вывода времени прибытия

## Этап 1 (обучение работе с git) - дополнитьльные материалы:
	* [Pro Git](http://git-scm.com/book/ru/v1)
	* [Работа с git для начинающих](http://blog.nsws.ru/rabota-s-git-dlya-nachinayushhix.html)
 
## Этап 2 (обучение работе с Apache Maven) - дополнительные материалы:
	*  [Описание](http://www.apache-maven.ru)

## Этап 3 (обучени работе с jsoup) - дополнительные материалы
	* [Cookbook](http://jsoup.org/cookbook/)

## Задачи
	* создать персональную ветку в репозитории (branch)
	* в ветке создать простой maven проект из командной строки (artifactId и groupId указать произвольные)
	* в созданом проекте создать класс, который с помощью jsoup парсил бы страницу результатов поиска google и выводил в консоль только заголовки найденых страниц (в мавен проект добавить зависимость на jsoup)
	
	