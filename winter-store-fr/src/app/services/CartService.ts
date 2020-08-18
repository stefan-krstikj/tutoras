import {Injectable} from '@angular/core';
import {Subject} from '../model/subject';
import {UserTimeslot} from '../model/user-timeslot';
import {UserDetailed} from '../model/user-detailed';
import {HttpClient} from '@angular/common/http';
import {AuthService} from './AuthService';
import {Observable} from 'rxjs';
import {CartItem} from '../model/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient,
              private auth: AuthService) {
  }

  addToCart(subject: string, userTimeslot: UserTimeslot, userDetailed: UserDetailed): Observable<string> {
    return this.http.post<string>('http://localhost:8082/api/cart/add', {
      timeslotId: userTimeslot.id,
      subjectName: subject,
      userDetailedFromUsername: localStorage.getItem('username'),
      userDetailedToId: userDetailed.id
    });
  }

  getCartItemsForSignedInUser(): Observable<CartItem[]> {
    let username = this.auth.getAuthenticatedUsername();
    return this.http.get<CartItem[]>(`http://localhost:8082/api/cart/${username}`);
  }

  deleteCartItem(cartItem: CartItem): Observable<string>{
    return this.http.post<string>('http://localhost:8082/api/cart/delete', {
      username: localStorage.getItem('username'),
      cartItem: cartItem
    })
  }
}
