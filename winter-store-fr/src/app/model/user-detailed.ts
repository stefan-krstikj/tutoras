import {Subject} from './subject';

export interface UserDetailed {
  firstName: string;
  lastName: string;
  phoneNumber: string;
  biography: string;
  id: number;
  freeTimeSlots: [];
  subjects: Subject[];
  roles: [];
}
