import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginDialogComponent } from './login-dialog/login-dialog.component';
import { AppRoutingModule } from './app-routing.module';
import { SignupDialogComponent } from './signup-dialog/signup-dialog.component';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {JWT_OPTIONS, JwtHelperService} from '@auth0/angular-jwt';
import {AuthInterceptor} from './auth.interceptor';
import { HomeComponent } from './home/home.component';
import {AuthGuard} from './auth.guard';
import { UserProfileComponent } from './user-profile/user-profile.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginDialogComponent,
    SignupDialogComponent,
    HomeComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatIconModule,
    FormsModule,
    HttpClientModule
  ],
  // tslint:disable-next-line:max-line-length
  providers: [[{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }, AuthGuard, { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService]
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
