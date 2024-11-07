import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {response} from 'express';
import {HttpClient} from '@angular/common/http';

interface IYeet {
  yeet: string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {

  title = 'web';

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit(): void {
    console.log("website")
    this.httpClient.get<IYeet>('https://api.vabalas.my.id/test')
      .subscribe(response => console.log("website", response.yeet));

    console.log("local")
    this.httpClient.get<IYeet>('http://127.0.0.1:90/test')
      .subscribe(response => console.log("local", response.yeet));
  }
}
