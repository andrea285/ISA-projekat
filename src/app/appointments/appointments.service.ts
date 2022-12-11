import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {formatDate} from "@angular/common";
import {Centar} from "../search-centar/centar";
import {FreeTermin} from "../free-termin/free-termin";

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
}
