import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { AdminConsoleComponent } from './admin-console/admin-console.component';
import { LoginComponent } from './login/login.component';
import {Routes, RouterModule} from "@angular/router";
import { CanActivateAuthGuard } from './can-activate.authguard';
import {LocationStrategy, HashLocationStrategy} from "@angular/common";
const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home',       component: AdminConsoleComponent, canActivate: [CanActivateAuthGuard] },
  { path: 'login',  component: LoginComponent },
];
@NgModule({
  declarations: [
    AppComponent,
    AdminConsoleComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [{ provide: LocationStrategy, useClass: HashLocationStrategy }, CanActivateAuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
