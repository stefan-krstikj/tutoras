import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/AuthService';
import {FormControl} from '@angular/forms';
import {UserService} from '../../services/UserService';
import {UserDetailed} from '../../model/user-detailed';
import {Router} from '@angular/router';

@Component({
  selector: 'app-signup-dialog',
  templateUrl: './signup-dialog.component.html',
  styleUrls: ['./signup-dialog.component.css']
})
export class SignupDialogComponent implements OnInit {

  name = '';
  email = '';
  password = '';
  repeatPassword = '';
  constructor(private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }

  register(): void{
    console.log('name', this.name);
    console.log('email', this.email);
    console.log('password', this.password);
    this.authService.signup(this.name, this.email, this.password).subscribe(
      respnose => {
        this.router.navigate(['/login'])
      }
    );
  }
}
