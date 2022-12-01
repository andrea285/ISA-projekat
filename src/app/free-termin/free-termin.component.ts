import { Component, OnInit } from '@angular/core';
import {FreeTerminService} from "./free-termin.service";
import {FreeTermin} from "./free-termin";

@Component({
  selector: 'app-free-termin',
  templateUrl: './free-termin.component.html',
  styleUrls: ['./free-termin.component.css']
})
export class FreeTerminComponent implements OnInit {
  termin: FreeTermin[]=[];
  date: string = '';
  time: string = '';
  duration: number = 5;
  term: FreeTermin = {
    id: 0,
    date: this.date,
    time: this.time,
    duration: this.duration
  }
  constructor(private http: FreeTerminService) { }

  ngOnInit(): void {
    this.http.getAllFreeTerm().subscribe(value => {
      this.termin=value;
    })
  }

  createTerm(): void{
    this.http.postAllFreeTerm(this.date, this.time, this.duration).subscribe(value => {
      console.log('aaaaaaaaaaaaaaaaaaaaaa');
    });
  }

}
