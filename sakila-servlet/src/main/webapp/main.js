function alertMessage(mesaj) {
    alert(mesaj);
}

function findAllCountryList() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/CountryServlet", false ); // false for synchronous request
    xmlHttp.send( null );
    console.log(xmlHttp.responseText);

    var data = JSON.parse(xmlHttp.responseText);
    var table = document.getElementById("countryTable");
    for (var i = 0; i < data.length; i++) {
        var countryNesne = data[i];

        var row = table.insertRow(i);

        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);

        cell1.innerHTML = countryNesne.id;
        cell2.innerHTML = countryNesne.country;
    }
}

function findAllCityList() {

    var country=document.getElementById('country').value;
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "/CityJsonServlet?country="+country, false ); // false for synchronous request
    xmlHttp.send( null );
    console.log(xmlHttp.responseText);

    var data = JSON.parse(xmlHttp.responseText);
    var table = document.getElementById("cityTable");
    for (var i = 0; i < data.length; i++) {
        var countryNesne = data[i];

        var row = table.insertRow(i);

        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);

        cell1.innerHTML = countryNesne.id;
        cell2.innerHTML = countryNesne.country.country;
        cell3.innerHTML = countryNesne.city;





    }
}
