import { Component, OnInit } from '@angular/core';
import {AuthService} from '../services/AuthService';
import {FormControl} from '@angular/forms';

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
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  register(): void{
    console.log('name', this.name);
    console.log('email', this.email);
    console.log('password', this.password);
    this.authService.signup(this.name, this.email, this.password);
  }
}
