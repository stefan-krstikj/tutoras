import {Component, OnInit} from '@angular/core';
import {AuthService} from '../services/AuthService';
import {UserService} from '../services/UserService';
import {SubjectsService} from '../services/SubjectsService';
import {Subject} from '../model/subject';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  allSubjects: Subject[];
  searchResultSubjects: Subject[];
  selectedSubjects: Subject[] = [];

  constructor(private authService: AuthService,
              private userService: UserService,
              private subjectsService: SubjectsService) {
  }

  ngOnInit(): void {
    this.subjectsService.getAllSubjects()
      .subscribe(response => {
        this.searchResultSubjects = response;
        this.allSubjects = response;
      });
  }

  onKey(value) {
    this.searchResultSubjects = this.search(value);
  }

  search(value: string) {
    let filter = value.toLowerCase();
    return this.allSubjects.filter(subject => subject.name.toLowerCase().startsWith(filter));
  }

  searchTutors(){
    console.log('searchResultSubjects', this.searchResultSubjects)
    console.log('selectedSubjects', this.selectedSubjects)
  }
}
