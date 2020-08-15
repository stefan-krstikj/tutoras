import {Component, OnInit} from '@angular/core';
import {Subject} from '../../model/subject';
import {SubjectsService} from '../../services/SubjectsService';
import {UserService} from '../../services/UserService';
import {element} from 'protractor';

@Component({
  selector: 'app-profile-subjects',
  templateUrl: './profile-subjects.component.html',
  styleUrls: ['./profile-subjects.component.css']
})
export class ProfileSubjectsComponent implements OnInit {

  subjectsAvailable: Subject[] = [];
  userSubjects: Subject[] = [];

  constructor(private subjectsService: SubjectsService,
              private userService: UserService) {
  }

  ngOnInit(): void {
    this.initializeSubjects();
  }

  initializeSubjects(): void {
    this.userService.getUserDetailsForSignedInUser()
      .subscribe((responseUserDetailed) => {
        const responseUserSubjects = responseUserDetailed.subjects;
        console.log('userSubjects', responseUserSubjects)
        this.subjectsService.getAllSubjects()
          .subscribe(responseAll => {
            console.log('all subjects', responseAll);
            return this.subjectsAvailable = responseAll.filter(it => {
              return !responseUserSubjects.map(item => item.id).includes(it.id);
            });
          });
        console.log('available subjects', this.subjectsAvailable)
        return this.userSubjects = responseUserSubjects;
      });
  }

  addToSelectedSubjects(subject: Subject) {
    this.subjectsAvailable = this.subjectsAvailable.filter(it => it.id !== subject.id);
    this.userSubjects.push(subject);
    this.sendUpdatedUserSubjects();
  }

  removeFromSelectedSubjects(subject: Subject) {
    this.userSubjects = this.userSubjects.filter(it => it.id !== subject.id);
    this.subjectsAvailable.push(subject);
    this.sendUpdatedUserSubjects();
  }

  sendUpdatedUserSubjects(){
    this.userService.updateSubjects(this.userSubjects);
  }
}
