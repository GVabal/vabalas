import {Component} from '@angular/core';
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
export class AppComponent {
  title = 'web';

  constructor(httpClient: HttpClient) {
    httpClient.get<IYeet>('http://localhost:8080/test')
      .subscribe(response => this.title = response.yeet);
  }
}
