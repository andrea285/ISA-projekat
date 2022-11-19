import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CentarService} from "./centar.service";
import {Centar} from "./centar";
import {SearchParameters} from "./search-parameters";
import {Observable} from "rxjs";

@Component({
  selector: 'app-search-centar',
  templateUrl: './search-centar.component.html',
  styleUrls: ['./search-centar.component.css']
})
export class SearchCentarComponent implements OnInit {

  constructor(private rout: ActivatedRoute,
              private http: CentarService) { }

  centar: Centar = {
    id: 0,
    name: '',
    address: '',
    description: '',
    review: 0,
    reservation: false,
    admins: '',
    medWorkers: '',
    dateAndTime: '',
    duration: 0
  }

  searchParams: SearchParameters = {
    name:'',
    city:'',
    sort:'',
    free:false
  }

  //centri: Observable<Centar>;
  ds: Centar[] = []; //lista svih centara**************
  ngOnInit(): void {
    this.http.getCentar('null', 'null', false, 'null').subscribe(value => {
      console.log(value)
      this.ds = value; //***************
    })
  }

  sortAscDesc(sort: string): void{
    this.searchParams.sort = sort;
    this.searchParams.name = 'null';
    this.searchParams.city = 'null';
    this.searchParams.free = false;
    this.http.getCentar(this.searchParams.name, this.searchParams.city, this.searchParams.free, this.searchParams.sort).subscribe(value => {
      console.log(value)
      this.ds = value; //***************
    })

  }

  checkAvailability(event: any){
    console.log(event.target.checked);
    this.http.getCentar('null', 'null', event.target.checked, 'null').subscribe(value => {
      console.log(value)
      this.ds = value; //***************
    })
  }

  searchByText(){

    if(this.centar.name === ''){
      this.centar.name = 'null';
    }

    if(this.centar.address === ''){
      this.centar.address = 'null';
    }

    this.http.getCentar(this.centar.name, this.centar.address, false, 'null').subscribe(value => {
      console.log(value)
      this.ds = value; //***************
    })

  }
}
