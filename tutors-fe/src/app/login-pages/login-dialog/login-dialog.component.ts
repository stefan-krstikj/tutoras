import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/AuthService';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {
  email = '';
  password = '';
  constructor(private authService: AuthService,
              private snackBar: MatSnackBar,
              private router: Router) { }

  ngOnInit(): void {
    if (this.authService.isAuthenticated()) {
      this.router.navigate(['home']);
    }
  }

  login(): void {
    this.authService.login(this.email, this.password).subscribe(response => {
      this.snackBar.open('Login successful', 'Close', {
        duration:2000
      });
      this.router.navigate(['home']);
    });
  }
}
