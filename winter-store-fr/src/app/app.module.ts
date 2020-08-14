import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginDialogComponent } from './unauthorized-page/login-dialog/login-dialog.component';
import { AppRoutingModule } from './app-routing.module';
import { SignupDialogComponent } from './unauthorized-page/signup-dialog/signup-dialog.component';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {JWT_OPTIONS, JwtHelperService} from '@auth0/angular-jwt';
import {AuthInterceptor} from './auth.interceptor';
import { HomeComponent } from './home/home.component';
import {AuthGuard} from './auth.guard';
import { UserProfileComponent } from './profile-settings-page/user-profile/user-profile.component';
import { ProfileSettingsMainComponent } from './profile-settings-page/profile-settings-main/profile-settings-main.component';
import { ProfileSubjectsComponent } from './profile-settings-page/profile-subjects/profile-subjects.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginDialogComponent,
    SignupDialogComponent,
    HomeComponent,
    UserProfileComponent,
    ProfileSettingsMainComponent,
    ProfileSubjectsComponent
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
