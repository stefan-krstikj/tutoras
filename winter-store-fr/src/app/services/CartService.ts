import {Injectable} from '@angular/core';
import {Subject} from '../model/subject';
import {UserTimeslot} from '../model/user-timeslot';
import {UserDetailed} from '../model/user-detailed';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  addToCart(subject: Subject, userTimeslot: UserTimeslot, userDetailed: UserDetailed){
      let userFrom = localStorage.getItem('username');
  }
}
