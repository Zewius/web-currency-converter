<h1> Конвертер мировых валют / Global currency converter </h1>

<p>
Веб-сервис, предоставляющий курс мировых валют.
Получение данных происходит с сервиса CurrencyApi (www.currencyconverterapi.com).
Написан на языке Java, используются такие технологии как Spring Framework 
(Spring Web MVC, Spring REST), Spring Boot, Google GSON, JSP.

Данный проект был написан в качестве моей курсовой работы.
</p>

<h2> Настройка </h2>

<p>
Для работоспособности данного веб-сервиса необходимо пройти регистрацию на 
<a href="www.currencyconverterapi.com">этом сайте</a>. После авторизации на почту придёт 
Ключ API - он необходим для отправки запроса и получения данных в формате JSON. Далее, в файле
application.properties (в директории src/main/resources) необходимо указать этот ключ 
в параметре <b>service.currency_api.key</b>.
</p>