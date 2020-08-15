import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Subject} from '../model/subject';

@Injectable({providedIn: 'root'})

export class SubjectsService {
  constructor(private http: HttpClient) {

  }

  getAllSubjects(): Observable<Subject[]> {
    return this.http.get<Subject[]>('http://localhost:8082/api/subjects/all');
  }

}
