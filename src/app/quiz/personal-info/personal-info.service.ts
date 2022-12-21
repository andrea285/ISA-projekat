import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PersonalInfo} from "./personal-info";

@Injectable({
  providedIn: 'root'
})
export class PersonalInfoService {

  constructor(private http: HttpClient) {

  }

  findPersonalInfo(id: number): Observable<PersonalInfo>{
    return this.http.get<PersonalInfo>('http://localhost:8080/api/v1/osnovneinformacije/' + id);
  }


}

