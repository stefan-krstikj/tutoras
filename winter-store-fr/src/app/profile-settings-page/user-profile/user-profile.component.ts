import { Component, OnInit } from '@angular/core';
import {UserDetailed} from '../../model/user-detailed';
import {UserService} from '../../services/UserService';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  userDetailed: UserDetailed = {roles: [], id: 0, freeTimeSlots: [], subjects: [], biography: '', firstName: '', lastName: '', phoneNumber: ''};
  email = localStorage.getItem('username');
  password = '';
  repeatPassword = '';
  showPasswordNotMatch = false;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUserDetailsForSignedInUser().subscribe(
      response => {
        console.log('response', response);
        this.userDetailed = response;
      }
    );
  }

  changePassword(): void{
    if (this.password === '' || this.repeatPassword === '' || this.password !== this.repeatPassword){
      this.showPasswordNotMatch = true;
      return;
    }
    this.userService.changePassword(this.password);
  }
  update(): void{
    this.userService.updateDetails(this.userDetailed);
  }
  getUserRoles(): string[]{
      return this.userDetailed.roles.map(it => this.capitalizeFirstLetter(it));
  }
  capitalizeFirstLetter(word: string): string{
    return word.charAt(0).toUpperCase() + word.slice(1);
  }


}
