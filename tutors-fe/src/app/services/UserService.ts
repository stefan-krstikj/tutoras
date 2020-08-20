import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {UserDetailed} from '../model/user-detailed';
import {AuthService} from './AuthService';
import {Params} from '@angular/router';
import {Observable} from 'rxjs';
import {Subject} from '../model/subject';
import {Timeslot} from '../model/timeslot';
import {UserTimeslot} from '../model/user-timeslot';

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

  getUserDetailsForUserId(id: number): Observable<UserDetailed> {
    return this.http.get<UserDetailed>(`http://localhost:8082/api/users/id/${id}`);
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
      phoneNumber: userDetailed.phoneNumber,
      role: userDetailed.role,
      price: userDetailed.price
    }).subscribe(response => console.log('response', response));
  }

  updateSubjects(subjects: Subject[]): void{
    this.http.post('http://localhost:8082/api/users/update-subjects', {
      username: localStorage.getItem('username'),
      subjects: subjects
    }).subscribe(response => console.log('response', response))
  }

  addTimeslot(timeslot: Timeslot): Observable<string>{
    return this.http.post<string>('http://localhost:8082/api/users/add-timeslot', {
      username: localStorage.getItem('username'),
      id: 0,
      timeslot: timeslot
    })
  }

  deleteTimeslot(timeslot: UserTimeslot){
    this.http.post('http://localhost:8082/api/users/delete-timeslot', {
      username: localStorage.getItem('username'),
      id: timeslot.id,
      timeslot: timeslot
    }).subscribe(response => console.log('response', response))
  }

  findTutorsForSubject(subject: Subject): Observable<UserDetailed[]>{
    return this.http.get<UserDetailed[]>(`http://localhost:8082/api/users/tutors/subject/${subject.id}`);
  }
}
