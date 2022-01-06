<%@ page import="java.time.Duration" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand ms-4" href="/">WEATHER</a>
    <button class="navbar-toggler d-lg-none me-3" type="button" data-bs-toggle="collapse"
            data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId"
            aria-expanded="false" aria-label="Toggle navigation"></button>
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <ul class="navbar-nav me-auto mt-2 mt-lg-0">
            <li class="nav-item active ms-3">
                <a class="nav-link" href="/">Погода сегодня<span class="visually-hidden">(current)</span></a>
            </li>
            <li class="nav-item  ms-3">
                <a class="nav-link" href="/weather">Погода на неделю</a>
            </li>
        </ul>
        <form class="form-inline d-flex">
            <input class="form-control mr-sm-2" type="text" name="name" placeholder="Название города" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
        </form>
    </div>
</nav>

<div class="">
    <div class="d-flex align-items-center justify-content-between border my-2 px-4 bg-light">
        <div class="d-block mt-2">
            <div class="d-flex mx-0"><img src="${weather.icon}">
                <p>${weather.temp}<sup>°C</sup></p></div>
            <p class="col-12">${weather.condition}</p></div>
        <div class="d-block"><p class="fs-6 fw-lighter mb-0 mt-0">Скорость ветра: ${weather.wind}м/с</p>
            <p class="fs-6 fw-lighter mb-0 mt-0">Рассвет: ${weather.sunrise}</p>
            <p class="fs-6 fw-lighter mb-0 mt-0">Закат: ${weather.sunset}</p></div>
        ${weather.city}
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>