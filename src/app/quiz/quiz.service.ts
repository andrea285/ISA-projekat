import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PersonalInfo} from "./personal-info/personal-info";
import {Upitnik} from "./personal-info/upitnik";
import {Quiz} from "./quiz";
import {Observable} from "rxjs";
import {Appointments} from "../appointments/appointments";

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  q: Quiz = {
    p:{
      id: 0,
      fullName: '',
      jmbg: '',
      dateOfBirth: '',
      sex: '',
      address: '',
      district: '',
      city: '',
      homeNumber: '',
      mobile: '',
      jobNumber: '',
      occupation: '',
      jobTitle: '',
      previousDinations: '',
      korisnik: 5
    },
    u: {
      id: 0,
      dobrovoljan: false,
      odbijen: false,
      lekovi: false,
      nahranjen: false,
      tetoviran: false
    }
  }
  constructor(private http: HttpClient) { }

  save(pi: PersonalInfo, u: Upitnik){
    this.q.p=pi;
    console.log(pi.fullName);
   return this.http.post('http://localhost:8080/api/v1/osnovneinformacije', this.q)
  }

  getAllZakazaniTermini(): Observable<Appointments[]>{
      return this.http.get<Appointments[]>('http://localhost:8080/api/v1/appointments/'+5);
  }

  sixMonthsDonation(): Observable<boolean>{
    return this.http.get<boolean>('http://localhost:8080/api/v1/appointments/six');
  }
}
