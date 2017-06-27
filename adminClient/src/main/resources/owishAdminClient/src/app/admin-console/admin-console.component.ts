import { Component, OnInit } from '@angular/core';
import {Response, Http, Headers, RequestOptions} from "@angular/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-console',
  templateUrl: './admin-console.component.html',
  styleUrls: ['./admin-console.component.css']
})
export class AdminConsoleComponent implements OnInit {
  constructor(public http: Http, private router: Router) {
  }

  ngOnInit() {
  }
  Addwish(wish: HTMLInputElement): void {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    let headers: Headers = new Headers();
    headers.append('Authorization', currentUser.token);
    headers.append('Content-Type', 'application/json');
    let opts: RequestOptions = new RequestOptions();
    opts.headers = headers;
    this.http.post(
      '/owish/saveWish',
      JSON.stringify({
        content: wish.value,
      }), opts)
      .subscribe((res: Response) => {
        console.log(res);
      },(error: Error) => {
        console.log(error);
      })
  }
}
