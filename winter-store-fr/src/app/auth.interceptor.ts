import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = localStorage.token;
    if (!token) {
      console.log('sending request', req);
      return next.handle(req);
    }
    const req1 = req.clone({
      headers: req.headers.set('Authorization', token),
    });
    console.log('sending request', req1);

    return next.handle(req1);
  }
}
