import {Component, Inject, Input, OnInit} from '@angular/core';
import {Subject} from '../model/subject';
import {UserDetailed} from '../model/user-detailed';
import {UserService} from '../services/UserService';
import {NgbRatingConfig} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-search-results',
  templateUrl: './search-results.component.html',
  styleUrls: ['./search-results.component.css']
})
export class SearchResultsComponent implements OnInit {

  @Input() subjects: Subject[];

  tutorsMatchingSearch: UserDetailed[] = [];

  constructor(private userService: UserService,
              config: NgbRatingConfig) {
    config.max = 5;
    config.readonly = true;
  }

  ngOnInit(): void {
    this.subjects.forEach(
      it => {
        this.userService.findTutorsForSubject(it)
          .subscribe((response: UserDetailed[]) => {
            console.log('response', response)
            response.map(it => {
              return this.tutorsMatchingSearch.findIndex(item => item.id ===it.id) === -1 ? this.tutorsMatchingSearch.push(it) : null;
            });
          });
      }
    );
  }

  tutorSubjectMatch(subject: Subject): boolean{
    return this.subjects.findIndex(it => it.id === subject.id) >= 0;
  }

  generateRandomImage(): string{
    return Math.floor(Math.random() * 10) + 1 + '.jpeg';
  }
}
