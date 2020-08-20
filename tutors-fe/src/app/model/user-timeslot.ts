import {Timeslot} from './timeslot';

export interface UserTimeslot {
  id: number;
  startTime: Timeslot;
  endTime: Timeslot;
}
