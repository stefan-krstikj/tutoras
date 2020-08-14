import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginDialogComponent} from './login-dialog/login-dialog.component';
import {RouterModule, Routes} from '@angular/router';
import {SignupDialogComponent} from './signup-dialog/signup-dialog.component';
import {HomeComponent} from './home/home.component';
import {AuthGuard} from './auth.guard';
import {UserProfileComponent} from './user-profile/user-profile.component';

const routes: Routes = [
  {path: 'login', component: LoginDialogComponent},
  {path: 'signup', component: SignupDialogComponent},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'profile', component: UserProfileComponent, canActivate: [AuthGuard]},
  {path: '**', redirectTo: 'login'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
