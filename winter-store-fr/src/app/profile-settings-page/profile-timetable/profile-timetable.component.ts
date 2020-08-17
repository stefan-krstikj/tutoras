import {Component, OnInit, ViewChild} from '@angular/core';
import {NgbCalendar, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {Timeslot} from '../../model/timeslot';
import {UserService} from '../../services/UserService';
import {TimeslotService} from '../../services/TimeslotService';
import {AuthService} from '../../services/AuthService';
import {MonthsEnum} from '../../model/enum/months-enum';
import {UserTimeslot} from '../../model/user-timeslot';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-profile-timetable',
  templateUrl: './profile-timetable.component.html',
  styleUrls: ['./profile-timetable.component.css']
})
export class ProfileTimetableComponent implements OnInit {

  dataSource;
  displayedColumns: string[];

  model: NgbDateStruct;
  date: { year: number, month: number, day: number };
  time = {hour: 0, minute: 0};

  @ViewChild(MatSort, {static: true}) sort: MatSort;


  constructor(private calendar: NgbCalendar,
              private userService: UserService) {
  }

  ngOnInit(): void {
    this.displayedColumns = ['position', 'startTime', 'endTime', 'action'];
    this.getTimeslots();
  }

  getTimeslots(): void {
    this.userService.getUserDetailsForSignedInUser()
      .subscribe(response => {
        this.dataSource = new MatTableDataSource(response.freeTimeSlots);
        this.dataSource.sort = this.sort
        this.dataSource.sortingDataAccessor = (data, attribute) => data[attribute];
      });
  }

  deleteTimeslot(timeslot: UserTimeslot) {
    console.log('deleting', timeslot)
    this.dataSource = this.dataSource.filter(it => it !== timeslot);
    this.userService.deleteTimeslot(timeslot);
  }

  addNewTimeslot() {
    console.log('this.date', this.date)
    let timeSlot: Timeslot = {
      year: this.model.year,
      month: this.model.month,
      day: this.model.day,
      hour: this.time.hour,
      minute: this.time.minute
    };
    this.userService.addTimeslot(timeSlot)
      .subscribe(response => {
        this.getTimeslots();
      });
  }

  formatTimeslotToString(timeSlot: Timeslot): string {
    let string = timeSlot.day < 10 ? '0' + timeSlot.day : '' + timeSlot.day
    string+= ' ' + MonthsEnum[timeSlot.month] + ' ' + timeSlot.year + ' ';
    timeSlot.hour < 10 ? string+='0'+timeSlot.hour+':' : string+=timeSlot.hour+':';
    timeSlot.minute < 10 ? string+='0'+timeSlot.minute : string+=timeSlot.minute;
    return string;
  }
}
