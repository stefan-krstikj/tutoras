import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/AuthService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.css']
})
export class LoginDialogComponent implements OnInit {
  email = '';
  password = '';
  constructor(private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
    if (this.authService.getAuthenticatedUsername) {
      console.log('authenticated username: ', this.authService.getAuthenticatedUsername);
      this.router.navigate(['home']);
    }
  }

  login(): void {
    this.authService.login(this.email, this.password).subscribe(response => {
      this.router.navigate(['home']);
    });
  }
}
