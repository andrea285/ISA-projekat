import { Component, OnInit } from '@angular/core';
import {FreeTerminService} from "./free-termin.service";
import {FreeTermin} from "./free-termin";
import {CentarService} from "../search-centar/centar.service";
import {Centar} from "../search-centar/centar";
import {MatSnackBar} from "@angular/material/snack-bar";
import {catchError, of} from "rxjs";

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


  centers: Centar[] = [];
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
    duration: 0,
    start: '',
    end: ''
  }
  start: string = ''
  chooseCenter(center: Centar){
    console.log(center.name);
  }
  constructor(private http: FreeTerminService,
              private centerHttp: CentarService,
              private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.http.getAllFreeTerm().subscribe(value => {
      this.termin=value;
    })
    this.centerHttp.getCentar('null', 'null', false, 'null').subscribe(value => {
      this.centers = value;
    });

  }

  createTerm(): void{
    let t = Number( this.time.replace(':', '.'));
    let s = Number(this.centar.start.replace(':', '.'));
    let e = Number(this.centar.end.replace(':', '.'));
    if(t < e && t > s){


      this.http.postAllFreeTerm(this.date, this.time, this.duration).pipe(catchError(err => of([]))).subscribe(value => {
        this.http.getAllFreeTerm().subscribe({
          complete: () => {
            /*this.http.getAllFreeTerm().subscribe(value => {
              this.termin=value;
            })*/
          }, // completeHandler
          error: () => {
            console.log('uhvacena greska');
            this.openSnackBar("vreme termina vec postoji","")
          },    // errorHandler
        });

      });
    }
    else{
      this.openSnackBar('neispravno vreme, molimo Vas izaberite vreme od '+s+' do '+e, '')
    }
  }



  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }
}
