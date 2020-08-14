import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {UserDetailed} from '../model/user-detailed';
import {AuthService} from './AuthService';
import {Params} from '@angular/router';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  constructor(private http: HttpClient,
              private authService: AuthService) {
  }

  getUserDetailsForSignedInUser(): Observable<UserDetailed> {
    console.log('getting user details for', localStorage.getItem('username'));
    const username = localStorage.getItem('username');
    return this.http.get<UserDetailed>(`http://localhost:8082/api/users/${username}`);
  }


  changePassword(password: string): void {
    this.http.post('http://localhost:8082/api/users/change-password', {
      username: localStorage.getItem('username'),
      password
    }).subscribe(
      response => console.log('response', response)
    );
  }

  updateDetails(userDetailed: UserDetailed): void {
    console.log('sending updated details', userDetailed);
    this.http.post('http://localhost:8082/api/users/update-details', {
      firstName: userDetailed.firstName,
      lastName: userDetailed.lastName,
      id: userDetailed.id,
      biography: userDetailed.biography,
      phoneNumber: userDetailed.phoneNumber
    }).subscribe(response => console.log('response', response));
  }
}
