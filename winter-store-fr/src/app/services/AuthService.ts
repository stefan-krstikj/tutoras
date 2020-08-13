import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SignUpRequest} from './SignUpRequest';

@Injectable({
  providedIn: 'root'
})


export class AuthService {
  constructor(private http: HttpClient) {
  }

  login(username: string, password: string): void {

  }

  signup(name: string, username: string, password: string): void {
    console.log('sending username', username);
    console.log('sending password', password);

    this.http.post('http://localhost:8082/api/login/signup', {
      username: 'username_here', password: 'password_here'
    })
      .subscribe((response) => console.log('Response', response));

    console.log('finished sending post request');
  }
  /*login(user: UserLoginRequest) {
        user.username = user.username.toLowerCase()
        return this.apiService.post(this.config.loginUrl, user).pipe(
            catchError(err => throwError(err.error.error)),
            map(userJwtToken => {
                console.log('Login success');
                localStorage.setItem(`username`, user.username);
                let tokenStr = 'Bearer ' + userJwtToken.jwtToken;
                localStorage.setItem(`token`, tokenStr);

                this.getInfo();

                return "Successfull login!";
            }));
    }
*/

}
