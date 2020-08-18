import {Injectable} from '@angular/core';
import {Subject} from '../model/subject';
import {UserTimeslot} from '../model/user-timeslot';
import {UserDetailed} from '../model/user-detailed';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient) {
  }
  addToCart(subject: Subject, userTimeslot: UserTimeslot, userDetailed: UserDetailed){
      this.http.post('http://localhost:8082/api/cart/add', {
        timslotId: userTimeslot.id,
        subjectId: subject.id,
        userDetailedFromUsername: localStorage.getItem('username'),
        userDetailedToId: userDetailed.id
      }).subscribe(response => console.log('add to cart response', response))
  }
}
