import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginDialogComponent} from './login-dialog/login-dialog.component';
import {RouterModule, Routes} from '@angular/router';
import {SignupDialogComponent} from './signup-dialog/signup-dialog.component';

const routes: Routes = [
  { path: 'login', component: LoginDialogComponent },
  { path: 'signup', component: SignupDialogComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
