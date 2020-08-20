import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {AuthService} from './services/AuthService';

@Injectable()
export class AuthGuard implements CanActivate{
  constructor(private router: Router, private authService: AuthService){}


  // tslint:disable-next-line:max-line-length
  canActivate(route: import('@angular/router').ActivatedRouteSnapshot, state: import('@angular/router').RouterStateSnapshot): boolean | import('@angular/router').UrlTree | import('rxjs').Observable<boolean | import('@angular/router').UrlTree> | Promise<boolean | import('@angular/router').UrlTree> {
    if (this.authService.isAuthenticated()) {
      return true;
    }
    this.router.navigate(['login']);
    return false;
  }
}
