import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Centar} from "./centar";
import * as http from "http";

@Injectable({
  providedIn: 'root'
})
export class CentarService {

  constructor(private http: HttpClient) { }

  getCentar(name:string, city:string, free:boolean, sort:string){
    return this.http.get<Centar[]>('http://localhost:8080/api/v1/centar',  {params: {name: name, city: city, free: free, sort: sort}});


  }
}
