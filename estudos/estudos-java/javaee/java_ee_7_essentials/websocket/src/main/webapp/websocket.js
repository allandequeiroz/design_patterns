var wsUri = "ws://" + document.location.host + "/websocket/private/usuario/notifications";
var websocket = new WebSocket(wsUri);

var username;
websocket.onopen = function(evt) { onOpen(evt) };
websocket.onmessage = function(evt) { onMessage(evt) };
websocket.onerror = function(evt) { onError(evt) };
var output = document.getElementById("output");

function join() {
    username = textField.value;
    websocket.send(username + " entrou nessa bosta.");
}

function send_message() {
    websocket.send(username + ": " + textField.value);
}

function onOpen() {
    writeToScreen("Mais um in&uacute;til (voc&ecirc;) pendurado aqui -> " + wsUri);
}

function onMessage(evt) {
    console.log("onMessage: " + evt.data);
    if (evt.data.indexOf("entrou nessa bosta.") != -1) {
        userField.innerHTML += evt.data.substring(0, evt.data.indexOf(" entrou nessa bosta.")) + "\n";
    } else {
        chatlogField.innerHTML += evt.data + "\n";
    }
}

function onError(evt) {
    writeToScreen('<span style="color: red;">FODEU:</span> ' + evt.data);
}

function writeToScreen(message) {
    output.innerHTML += message + "<br>";
}