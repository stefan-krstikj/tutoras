import {Subject} from './subject';
import {Timeslot} from './timeslot';
import {UserTimeslot} from './user-timeslot';

export interface UserDetailed {
  firstName: string;
  lastName: string;
  phoneNumber: string;
  biography: string;
  id: number;
  freeTimeSlots: UserTimeslot[];
  subjects: Subject[];
  role: string;
  price: number;
  rating: number;
}
