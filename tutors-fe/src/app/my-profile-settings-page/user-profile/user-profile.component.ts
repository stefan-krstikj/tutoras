import {Component, OnInit} from '@angular/core';
import {UserDetailed} from '../../model/user-detailed';
import {UserService} from '../../services/UserService';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  userDetailed: UserDetailed = {
    price: 0,
    rating: 0,
    role: '', id: 0, freeTimeSlots: [], subjects: [], biography: '', firstName: '', lastName: '', phoneNumber: ''
  };

  displayUpdatedMessage = false;
  email = localStorage.getItem('username');
  password = '';
  repeatPassword = '';
  radioSelected = 'student';

  showPasswordNotMatch = false;

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    this.userService.getUserDetailsForSignedInUser().subscribe(
      response => {
        console.log('response', response);
        this.userDetailed = response;
        this.radioSelected = response.role;
      }
    );
  }

  changePassword(): void {
    if (this.password === '' || this.repeatPassword === '' || this.password !== this.repeatPassword) {
      this.showPasswordNotMatch = true;
      return;
    }
    this.showPasswordNotMatch = false;
    this.userService.changePassword(this.password);
  }

  update(): void {
    this.userDetailed.role = this.radioSelected;
    this.userService.updateDetails(this.userDetailed)
      .subscribe(response => {
        this.displayUpdatedMessage = true;
      });
  }

  capitalizeFirstLetter(word: string): string {
    return word.charAt(0).toUpperCase() + word.slice(1);
  }


}
