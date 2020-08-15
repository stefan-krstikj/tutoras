import { Component, OnInit } from '@angular/core';
import {NgbCalendar, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {Timeslot} from '../../model/timeslot';
interface PeriodicElement {
  startTime: string;
  position: number;
  endTime: string;
}

@Component({
  selector: 'app-profile-timetable',
  templateUrl: './profile-timetable.component.html',
  styleUrls: ['./profile-timetable.component.css']
})
export class ProfileTimetableComponent implements OnInit {

  dataSource: PeriodicElement[] = [
    {position: 1, startTime: '25 June 5:00pm', endTime: '25 June 6pm' },
    {position: 2, startTime: '26 June 5:00pm', endTime: '26 June 6pm' },
    {position: 3, startTime: '27 June 5:00pm', endTime: '27 June 6pm' },
    {position: 4, startTime: '28 June 5:00pm', endTime: '28 June 6pm' },
    {position: 5, startTime: '29 June 5:00pm', endTime: '29 June 6pm' },
    {position: 6, startTime: '23 June 5:00pm', endTime: '23 June 6pm' },
  ];

  displayedColumns: string[];

  model: NgbDateStruct;
  date: {year: number, month: number, day: number};
  time = {hour: 0, minute: 0};

  constructor(private calendar: NgbCalendar) { }

  ngOnInit(): void {
    this.displayedColumns = ['position', 'startTime', 'endTime', 'action'];
  }

  delete(periodicElement: PeriodicElement){
    this.dataSource = this.dataSource.filter(it => it !== periodicElement);
    this.sendUpdatedTimeSlots();
  }

  sendUpdatedTimeSlots(){
      let timeSlot: Timeslot = {
        year: this.date.year,
        month: this.date.month,
        day: this.date.day,
        hour: this.time.hour,
        minute: this.time.minute
      }
  }

  formatTimeslotToString(timeSlot: Timeslot): string{
    return timeSlot.day + '.' + timeSlot.month + '.' + timeSlot.day + ' ' + timeSlot.hour + ':' + timeSlot.minute;
  }
}
