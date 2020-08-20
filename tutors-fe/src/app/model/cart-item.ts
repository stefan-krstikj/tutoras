import {Subject} from './subject';

export interface CartItem {
  id: number;
  userTo: string;
  price: number;
  subject: Subject;
}
