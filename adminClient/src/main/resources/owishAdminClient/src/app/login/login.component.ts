import { Component, OnInit } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  errorMsg: string;
  constructor(public http: Http, private router: Router) { }

  ngOnInit() {
  }
  login(username: HTMLInputElement, password: HTMLInputElement): void {
    this.http.post(
      '/owish/login',
      JSON.stringify({
        username: username.value,
        password: password.value,
      }))
      .subscribe((res: Response) => {
        let token = res.headers.get('authorization');
        localStorage.setItem('currentUser', JSON.stringify({username: username.value, token: token}));
        this.router.navigate(['/home']);
      },(error: Error) => {
        this.errorMsg = 'wrong credentials';
      })
  }
}
