import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})


export class AuthService {
  constructor(private http: HttpClient) {
  }

  login(username: string, password: string): void {

  }

  signup(name: string, username: string, password: string): void {
    console.log('sending name', name);
    console.log('sending username', username);
    console.log('sending password', password);
    this.http.post('http://localhost:8082/api/login/signup', {
      name, username, password
    }).subscribe((response) => console.log('Response', response));
    console.log('finished sending post request');
  }

}
