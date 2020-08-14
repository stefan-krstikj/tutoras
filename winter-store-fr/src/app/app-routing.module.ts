import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginDialogComponent} from './unauthorized-page/login-dialog/login-dialog.component';
import {RouterModule, Routes} from '@angular/router';
import {SignupDialogComponent} from './unauthorized-page/signup-dialog/signup-dialog.component';
import {HomeComponent} from './home/home.component';
import {AuthGuard} from './auth.guard';
import {UserProfileComponent} from './profile-settings-page/user-profile/user-profile.component';
import {ProfileSettingsMainComponent} from './profile-settings-page/profile-settings-main/profile-settings-main.component';

const routes: Routes = [
  {path: 'login', component: LoginDialogComponent},
  {path: 'signup', component: SignupDialogComponent},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'profile', component: ProfileSettingsMainComponent, canActivate: [AuthGuard]},
  {path: '**', redirectTo: 'login'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
