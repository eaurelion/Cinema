'use strict';
var chatPage = document.querySelector('#chat-page');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
var stompClient = null;
var username = null;

function loadMessages() {
var x = new XMLHttpRequest();
x.open("GET", "/chat/messages/" + movieId, true);
x.onload = function (){
    const data = JSON.parse(x.responseText);
    console.log(movieId);
    for (var i = 0; i < data.length; i++)
    {
        var messageElement = document.createElement('div');
        messageElement.className = 'bubbleWrapper';

        var container = document.createElement('div');
        if (data[i].sender === cinemausername)
            container.className = 'inlineContainer own';
        else
            container.className = 'inlineContainer';

        var usernameText = document.createElement('label');
        usernameText.textContent = data[i].sender;
        if (data[i].sender === cinemausername)
            usernameText.hidden = true;

        var textElement = document.createElement('div');
        if (data[i].sender === cinemausername)
            textElement.className = 'ownBubble own';
        else
            textElement.className = 'otherBubble other';
        textElement.textContent = data[i].content;

        messageArea.appendChild(messageElement);
        messageElement.appendChild(container);
        container.appendChild(usernameText);
        container.appendChild(textElement);
    }
}
x.send(null);
}

function connect(event) {
    username = cinemausername;
    if(username) {
        chatPage.classList.remove('hidden');
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}
function onConnected() {
    stompClient.subscribe('/topic/public', onMessageReceived);
    stompClient.send("/app/chat.addUser",
        {}, JSON.stringify({sender: username, type: 'JOIN'})
    )
}
function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}
function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) {
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT',
            movie: { id: movieId}
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}
function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    if (message.type === 'CHAT') {
        var messageElement = document.createElement('div');
        messageElement.className = 'bubbleWrapper';

        var container = document.createElement('div');
        if (message.sender === cinemausername)
            container.className = 'inlineContainer own';
        else
            container.className = 'inlineContainer';

        var usernameText = document.createElement('label');
        usernameText.textContent = message.sender;
        if (message.sender === cinemausername)
            usernameText.hidden = true;

        var textElement = document.createElement('div');
        if (message.sender === cinemausername)
            textElement.className = 'ownBubble own';
        else
            textElement.className = 'otherBubble other';
        textElement.textContent = message.content;
        messageArea.appendChild(messageElement);
        messageElement.appendChild(container);
        container.appendChild(usernameText);
        container.appendChild(textElement);
    }
    chatPage.scrollTop = 99999;
}

messageForm.addEventListener('submit', sendMessage, true)
document.addEventListener("DOMContentLoaded", loadMessages);
document.addEventListener("DOMContentLoaded", connect)