import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserDetailed} from '../model/user-detailed';
import {AuthService} from './AuthService';

@Injectable({
  providedIn: 'root'
})

export class UserService {
  constructor(private http: HttpClient,
              private authService: AuthService){
  }

  getUserDetailsForSignedInUser(): UserDetailed{
    const signedInUser: UserDetailed = JSON.parse(localStorage.getItem('user_details'));
    return signedInUser;
  }
}
