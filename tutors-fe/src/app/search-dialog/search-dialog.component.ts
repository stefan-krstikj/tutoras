import { Component, OnInit } from '@angular/core';
import {Subject} from '../model/subject';
import {AuthService} from '../services/AuthService';
import {UserService} from '../services/UserService';
import {SubjectsService} from '../services/SubjectsService';

@Component({
  selector: 'app-search-dialog',
  templateUrl: './search-dialog.component.html',
  styleUrls: ['./search-dialog.component.css']
})
export class SearchDialogComponent implements OnInit {

  allSubjects: Subject[];
  searchResultSubjects: Subject[];
  selectedSubjects: Subject[] = [];
  searched = false;

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
    this.searched = true;
  }

}
