import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Timeslot} from '../model/timeslot';

@Injectable({
  providedIn: 'root'
})
export class TimeslotService {

  constructor(private http: HttpClient) {
  }

  getTimeslotsForUser(username: string): Observable<Timeslot[]> {
    return this.http.get<Timeslot[]>(`http://localhost:8082/api/timeslots/${username}`);
  }

}
