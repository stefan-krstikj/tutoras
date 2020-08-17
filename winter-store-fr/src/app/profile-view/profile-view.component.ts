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

@Component({
  selector: 'app-profile-view',
  templateUrl: './profile-view.component.html',
  styleUrls: ['./profile-view.component.css']
})
export class ProfileViewComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private userService: UserService,
              config: NgbRatingConfig) {
    config.max = 5;
    config.readonly = true;
  }

  userId: number;
  userDetailed: UserDetailed;

  dataSource;
  displayedColumns: string[];

  @ViewChild(MatSort, {static: true}) sort: MatSort;


  ngOnInit(): void {
    this.displayedColumns = ['position', 'startTime', 'endTime', 'price', 'action'];
    this.route.paramMap.subscribe(params => {
      this.userId = +params.get('id');
      this.fetchUserDetails();
    });
  }

  fetchUserDetails(){
    this.userService.getUserDetailsForUserId(this.userId)
      .subscribe(response => {
        // todo redirect if its logged user profile
        this.dataSource = new MatTableDataSource(response.freeTimeSlots);
        this.dataSource.sort = this.sort
        this.dataSource.sortingDataAccessor = (data, attribute) => data[attribute];
        return this.userDetailed = response;
      })
  }

  formatTimeslotToString(timeSlot: Timeslot): string {
    let string = timeSlot.day < 10 ? '0' + timeSlot.day : '' + timeSlot.day
    string+= ' ' + MonthsEnum[timeSlot.month] + ' ' + timeSlot.year + ' ';
    timeSlot.hour < 10 ? string+='0'+timeSlot.hour+':' : string+=timeSlot.hour+':';
    timeSlot.minute < 10 ? string+='0'+timeSlot.minute : string+=timeSlot.minute;
    return string;
  }

  addToCart(timeslot: UserTimeslot){

  }
}
