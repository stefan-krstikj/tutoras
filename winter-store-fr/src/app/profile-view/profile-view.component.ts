import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {UserService} from '../services/UserService';
import {UserDetailed} from '../model/user-detailed';

@Component({
  selector: 'app-profile-view',
  templateUrl: './profile-view.component.html',
  styleUrls: ['./profile-view.component.css']
})
export class ProfileViewComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private userService: UserService) { }
  userId: number;
  userDetailed: UserDetailed;

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.userId = +params.get('id');
      this.fetchUserDetails();
    });
  }

  fetchUserDetails(){
    this.userService.getUserDetailsForUserId(this.userId)
      .subscribe(response => this.userDetailed = response)
  }
}
