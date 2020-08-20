import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {UserService} from '../services/UserService';
import {UserDetailed} from '../model/user-detailed';
import {Timeslot} from '../model/timeslot';
import {MonthsEnum} from '../model/enum/months-enum';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {NgbRatingConfig} from '@ng-bootstrap/ng-bootstrap';
import {UserTimeslot} from '../model/user-timeslot';
import {Subject} from '../model/subject';
import {CartService} from '../services/CartService';

@Component({
  selector: 'app-profile-view',
  templateUrl: './profile-view.component.html',
  styleUrls: ['./profile-view.component.css']
})
export class ProfileViewComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private userService: UserService,
              private cartService: CartService,
              config: NgbRatingConfig) {
    config.max = 5;
    config.readonly = true;
  }

  userId: number;
  userDetailed: UserDetailed;

  dataSource;
  displayedColumns: string[];
  disableTable = false;

  timeslotSelected: UserTimeslot;
  subjectSelected: string;

  displayMissingSubjectSelection = false;

  @ViewChild(MatSort, {static: true}) sort: MatSort;


  ngOnInit(): void {
    this.displayedColumns = ['position', 'startTime', 'endTime', 'price', 'action'];
    this.route.paramMap.subscribe(params => {
      this.userId = +params.get('id');
      this.fetchUserDetails();
    });
  }

  fetchUserDetails() {
    this.userService.getUserDetailsForUserId(this.userId)
      .subscribe(response => {
        // todo redirect if its logged user profile
        this.dataSource = new MatTableDataSource(response.freeTimeSlots);
        this.dataSource.sort = this.sort;
        this.dataSource.sortingDataAccessor = (data, attribute) => data[attribute];
        return this.userDetailed = response;
      });
  }

  formatTimeslotToString(timeSlot: Timeslot): string {
    let string = timeSlot.day < 10 ? '0' + timeSlot.day : '' + timeSlot.day;
    string += ' ' + MonthsEnum[timeSlot.month] + ' ' + timeSlot.year + ' ';
    timeSlot.hour < 10 ? string += '0' + timeSlot.hour + ':' : string += timeSlot.hour + ':';
    timeSlot.minute < 10 ? string += '0' + timeSlot.minute : string += timeSlot.minute;
    return string;
  }

  selectTimeslot(userTimeslot: UserTimeslot, event: any) {
    if (this.disableTable) {
      return;
    }
    event.target.textContent = 'not_interested';
    console.log('received', userTimeslot);
    this.disableTable = true;
    this.timeslotSelected = userTimeslot;
  }

  addToCart() {
    if (!this.subjectSelected) {
      this.displayMissingSubjectSelection = true;
      return;
    }
    this.cartService.addToCart(this.subjectSelected, this.timeslotSelected, this.userDetailed)
      .subscribe(response => {
        this.disableTable = false;
        this.fetchUserDetails();
      });
  }
}
