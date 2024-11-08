import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
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
      if (Date.now() % 2 == 0) {
          console.log("website")
          this.httpClient.get<IYeet>('/api/test')
              .subscribe(response => console.log("website", response.yeet));
      } else {
          console.log('no http call this time')
      }
  }
}
