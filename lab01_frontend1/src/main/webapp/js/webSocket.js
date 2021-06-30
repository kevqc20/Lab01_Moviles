var wsUri = "ws://" + document.location.host + "/lab01_frontend1/" + "reload";
var websocket = new WebSocket(wsUri);

websocket.onopen = function (evt) {
    console.log("Connected to " + wsUri);
};

websocket.onmessage = function (evt) {
    console.log("Message -> " + evt.data);
    window.location.reload();
};