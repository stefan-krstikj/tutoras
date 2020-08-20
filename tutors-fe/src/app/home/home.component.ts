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
  constructor() {
  }

  ngOnInit(): void {
  }
}
