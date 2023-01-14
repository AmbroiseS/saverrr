import { Component } from '@angular/core';
import { ApiServices } from '../services/api.services';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent {
  constructor(private api: ApiServices) { }

  message = '';

  generate() {
    this.api.generateMessage().subscribe(
      {
        next: (data) => this.message = data.message,
        error: (error) => this.message = 'failed to fetch'
      })
  }
}
