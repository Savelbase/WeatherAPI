
document.getElementById('location').addEventListener("click", () => {
     // Try HTML5 geolocation.
     navigator.geolocation.getCurrentPosition(function(position) {
         url = `http://api.openweathermap.org/data/2.5/weather?lat=${position.coords.latitude}&lon=${position.coords.longitude}&appid=c0108030705c034ad6c7d31599640a96&lat=48.28&lon=35.1&units=metric`
        xmlRequest(url)
      });
    });

document.getElementById('button').addEventListener('click', (e) => {
    let city = document.getElementById("city").value + "";
    let apiKey = "c0108030705c034ad6c7d31599640a96"
    let url = `http://api.openweathermap.org/data/2.5/weather?q=${city}&appid=` + apiKey + "&lat=48.28&lon=35.1&units=metric";
    xmlRequest(url);
    
})

function filling(weather) {
    const main = document.querySelector(".main");
    const div = document.createElement("div");
    const imgBlock = document.createElement("div");
    const additional = document.createElement("div");
    const left = document.createElement("div");
    const img = document.createElement("img");
    const description = document.createElement("p");
    const add1 = document.createElement('p')
    const add2 = document.createElement('p')
    const add3 = document.createElement('p')
    const temp = document.createElement("p");
    const celc = document.createElement("sup");
    
    celc.append("°C")
    temp.append(Math.round(weather.main.temp), celc)
    description.classList.add('col-12')
    description.append(weather.weather[0].description)

    img.src = "https://openweathermap.org/img/w/" + weather.weather[0].icon + ".png";
    imgBlock.append(img , temp);
    imgBlock.classList.add('d-flex' , 'mx-0');
    add1.classList.add('fs-6','fw-lighter' , 'mb-0' , 'mt-0' )
    add2.classList.add('fs-6','fw-lighter' , 'mb-0' , 'mt-0' )
    add3.classList.add('fs-6','fw-lighter' , 'mb-0' , 'mt-0' )
    add1.append('Wind: ' , weather.wind.speed , 'm/s')
    add2.append('Sunrise: ' , getTime(weather.sys.sunrise))
    add3.append('Sunset: ' , getTime(weather.sys.sunset))
    additional.classList.add('d-block')
    additional.append(add1 , add2 , add3)
    additional.append(add1 , add2 , add3)
    left.classList.add('d-block' , 'mt-2')
    left.append(imgBlock , description)
    div.classList.add('d-flex','align-items-center','justify-content-between', 'border' , 'my-2', 'px-4' , 'bg-light')
    div.append(left , additional , weather.name)
    main.insertBefore(div, main.firstChild);
}

function getTime (time){
    var date = new Date(time*1000);
    var hours = date.getHours();
    var minutes = "0" + date.getMinutes();
    var seconds = "0" + date.getSeconds();
    return (hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2));
} 

function xmlRequest (url){
    const xhr = new XMLHttpRequest();
    let weather;
    xhr.open('GET', url);
    xhr.addEventListener("readystatechange", (e) => {
        if (xhr.readyState === xhr.DONE) {
            if (xhr.status === 200) {
                weather = JSON.parse(xhr.responseText);
                console.log(weather)
                filling(weather)
            }
            if(xhr.status === 404){
                alert(`Your city - "${city}" is not found`)
            }
        }
    })    
    xhr.send();
}