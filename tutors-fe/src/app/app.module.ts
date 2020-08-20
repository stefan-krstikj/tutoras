import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginDialogComponent } from './login-pages/login-dialog/login-dialog.component';
import { AppRoutingModule } from './app-routing.module';
import { SignupDialogComponent } from './login-pages/signup-dialog/signup-dialog.component';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {JWT_OPTIONS, JwtHelperService} from '@auth0/angular-jwt';
import {AuthInterceptor} from './auth.interceptor';
import { HomeComponent } from './home/home.component';
import {AuthGuard} from './auth.guard';
import { UserProfileComponent } from './my-profile-settings-page/user-profile/user-profile.component';
import { ProfileSettingsMainComponent } from './my-profile-settings-page/profile-settings-main/profile-settings-main.component';
import { ProfileSubjectsComponent } from './my-profile-settings-page/profile-subjects/profile-subjects.component';
import { ProfileTimetableComponent } from './my-profile-settings-page/profile-timetable/profile-timetable.component';
import {MatTableModule} from '@angular/material/table';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {MatSortModule} from '@angular/material/sort';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import { SearchResultsComponent } from './search-results/search-results.component';
import { SearchDialogComponent } from './search-dialog/search-dialog.component';
import { ProfileViewComponent } from './profile-view/profile-view.component';
import { CartComponent } from './cart/cart.component';
import { StripePaymentComponent } from './stripe-payment/stripe-payment.component';
import {MatDialogModule} from '@angular/material/dialog';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginDialogComponent,
    SignupDialogComponent,
    HomeComponent,
    UserProfileComponent,
    ProfileSettingsMainComponent,
    ProfileSubjectsComponent,
    ProfileTimetableComponent,
    SearchResultsComponent,
    SearchDialogComponent,
    ProfileViewComponent,
    CartComponent,
    StripePaymentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatIconModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    BrowserAnimationsModule,
    NgbModule,
    MatSortModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatDialogModule
  ],
  // tslint:disable-next-line:max-line-length
  providers: [[{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }, AuthGuard, { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService]
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
