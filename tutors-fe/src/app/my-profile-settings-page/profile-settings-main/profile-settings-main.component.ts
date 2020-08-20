import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/AuthService';
import {UserDetailed} from '../../model/user-detailed';
import {UserService} from '../../services/UserService';

@Component({
  selector: 'app-profile-settings-main',
  templateUrl: './profile-settings-main.component.html',
  styleUrls: ['./profile-settings-main.component.css']
})
export class ProfileSettingsMainComponent implements OnInit {
  userDetailed: UserDetailed;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserDetailsForSignedInUser()
      .subscribe(response => this.userDetailed = response)
  }

}
