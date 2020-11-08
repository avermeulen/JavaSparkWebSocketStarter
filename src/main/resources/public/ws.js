const btn = document.querySelector(".btn");
const theMessage = document.querySelector(".theMessage");
const messages = document.querySelector(".messages");
console.log(messages);

// Create WebSocket connection.
const socket = new WebSocket('ws://localhost:4567/my-route');

// Connection opened
socket.addEventListener('open', function (event) {

    btn.addEventListener("click", function(){

        if (theMessage.value !== "") {
            socket.send(theMessage.value);
        }

    });
});


// Listen for messages
socket.addEventListener('message', function (event) {

    messages.innerHTML = messages.innerHTML + `<li>${event.data}</li>`

});