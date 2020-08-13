import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SignUpRequest} from './SignUpRequest';
import {catchError, map} from 'rxjs/operators';
import {Observable, throwError} from 'rxjs';
import {JwtHelperService} from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})


export class AuthService {
  constructor(private http: HttpClient,
              private jwtHelperService: JwtHelperService) {
  }

  getAuthenticatedUsername(): string | null {
    if (this.isAuthenticated()) {
      return localStorage.getItem('username');
    }
    return null;
  }

  isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    return !this.jwtHelperService.isTokenExpired(token);
  }



  signup(name: string, username: string, password: string): void {
    console.log('sending username', username);
    console.log('sending password', password);

    this.http.post('http://localhost:8082/api/login/signup', {
      username, password
    })
      .subscribe((response) => console.log('Response', response));

    console.log('finished sending post request');
  }

  // @ts-ignore
  login(username: string, password: string): Observable<string>{
    username = username.toLowerCase();
    return this.http.post('http://localhost:8082/api/login/login', {
      username, password
    })
      .pipe(
      map(userJwtToken => {
        console.log('Login success');
        localStorage.setItem(`username`, username);
        // @ts-ignore
        const tokenStr = 'Bearer ' + userJwtToken.jwtToken;
        localStorage.setItem(`token`, tokenStr);
        return 'Successfull login!';
      }));
      // .subscribe(response => console.log('login response', response));
  }

  logout(): void{
    localStorage.clear();
  }
}
