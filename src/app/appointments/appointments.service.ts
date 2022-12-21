import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {formatDate} from "@angular/common";
import {Centar} from "../search-centar/centar";
import {FreeTermin} from "../free-termin/free-termin";
import {Appointments} from "./appointments";
import {UserApp} from "../user/user-appointments/user-app";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AppointmentsService {

  constructor(private http: HttpClient) { }

  getAllFreeTerm(date: Date, startTime: any, endTime: any){
    let fd = formatDate(date, 'yyyy-MM-dd', 'en_us');
    console.log("app service");
    return this.http.get<FreeTermin[]>('http://localhost:8080/api/v1/appointments',  {params: {date: fd, startTime: startTime, endTime: endTime}});

  }

  saveAppointment(appId: number, userId: number){
    return this.http.post('http://localhost:8080/api/v1/appointments', {slobodanTerminId: appId, korisnikId: userId});
  }

  getAllAppointmentsById(id: number): Observable<UserApp[]>{
    return this.http.get<UserApp[]>('http://localhost:8080/api/v1/appointments/find/' + id);
  }
}
