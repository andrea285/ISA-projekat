import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {formatDate} from "@angular/common";
import {Centar} from "../search-centar/centar";

@Injectable({
  providedIn: 'root'
})
export class AppointmentsService {

  constructor(private http: HttpClient) { }

  getAllFreeTerm(date: Date){
    let fd = formatDate(date, 'yyyy-MM-dd', 'en_us');

    return this.http.get<Centar[]>('http://localhost:8080/api/v1/appointments?date='+date);



  }
}
