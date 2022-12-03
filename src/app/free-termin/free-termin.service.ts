import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FreeTermin} from "./free-termin";
import {formatDate} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class FreeTerminService {

  term: FreeTermin | undefined;
  constructor(private http: HttpClient) {

  }

  getAllFreeTerm(){
    return this.http.get<FreeTermin[]>('http://localhost:8080/api/v1/termin')
  }

  postAllFreeTerm(date: string, time: string, duration: number){


    let fd = formatDate(date, 'yyyy-MM-dd', 'en_us');

    this.term = {
      id:0,
      date: fd,
      time: time,
      duration: duration
    };



    return this.http.post<FreeTermin>('http://localhost:8080/api/v1/termin', this.term)
  }

  /*getAllCenters(){
    return this.http.get
  }*/

}
