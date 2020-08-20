import { Component, OnInit } from '@angular/core';
import {AuthService} from '../services/AuthService';
import {Router} from '@angular/router';
import {UserDetailed} from '../model/user-detailed';
import {UserService} from '../services/UserService';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  userDetailed: UserDetailed

  constructor(private authService: AuthService,
              private userService: UserService,
              private router: Router) { }

  ngOnInit(): void {
    if(this.isAuthenticated())
      this.userService.getUserDetailsForSignedInUser()
        .subscribe(response => this.userDetailed = response);
  }

  isAuthenticated(): boolean{
    return this.authService.isAuthenticated();
  }

  logout(): void{
    this.authService.logout();
    this.router.navigate(['login']);
  }

}
