import { Component } from '@angular/core';
import { Stomp } from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { NgModule } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent { stompClient: any;
  channel1Messages: string[] = [];
  channel2Messages: string[] = [];
  messageInput: string = '';

  constructor() {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    const socket = new SockJS('http://localhost:8080/chat');
    this.stompClient = Stomp.over(socket);
    this.stompClient.connect({}, () => {
      this.stompClient.subscribe('/topic/channel1', (message: any) => {
        this.channel1Messages.push(message.body);
      });
      this.stompClient.subscribe('/topic/channel2', (message: any) => {
        this.channel2Messages.push(message.body);
      });
    });
  }

  sendMessage(channel: string) {
    if (this.messageInput && this.stompClient) {
      this.stompClient.send(`/app/chat/${channel}`, {}, this.messageInput);
      this.messageInput = '';
    }
  }
}