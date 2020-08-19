import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService{
  constructor(private http: HttpClient) {
  }

  sendPayment(token: object, amount: number): Observable<string>{
    console.log('sending', localStorage.getItem('username'),
      token,
      amount)
    return this.http.post<string>('http://localhost:8082/api/payments/charge', {
      username: localStorage.getItem('username'),
      token: token,
      amount: amount
    })
  }
}
