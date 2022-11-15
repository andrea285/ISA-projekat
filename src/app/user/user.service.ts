import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "./user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  headers=new Headers({
    'Content-Type': 'application/json',
    'Autorization': 'Brear jklmn'
  })
  constructor(private http:HttpClient) { }

  getUser(id:number): Observable<User>{
    return this.http.get<User>('http://localhost:8080/api/v1/korisnik?id='+ id);
  }

  updateUser(user: User): Observable<User>{
    return this.http.post<User>('http://localhost:8080/api/v1/korisnik/', user);
  }
}
