import {Component, OnInit} from '@angular/core';
import * as moment from 'moment';
import {ThemePalette} from "@angular/material/core";
import {formControl} from "@angular/core/schematics/migrations/typed-forms/util";
import {FormControl} from "@angular/forms";
import {AppointmentsService} from "./appointments.service";
import {Centar} from "../search-centar/centar";
import {FreeTermin} from "../free-termin/free-termin";
import {Sort} from "@angular/material/sort";
import {UserService} from "../user/user.service";
import {User} from "../user/user";
import {MatSnackBar} from "@angular/material/snack-bar";
import {PersonalInfo} from "../quiz/personal-info/personal-info";
import {Upitnik} from "../quiz/personal-info/upitnik";
import {Route, Router, Routes} from "@angular/router";
import {PersonalInfoService} from "../quiz/personal-info/personal-info.service";
import {QuizService} from "../quiz/quiz.service";


@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {

  freeTermins: FreeTermin[] = [];
  public date: Date = new Date();
  startTime: any;
  endTime: any;
  personalInfo: PersonalInfo = {
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
    korisnik: 0
  }

  quiz: Upitnik = {
    id: 0,
    dobrovoljan: false,
    odbijen: false,
    lekovi: false,
    nahranjen: false,
    tetoviran: false
  }
  user: User = {
    id:0,
    firstName:'',
    lastName:'',
    password:'',
    email:'',
    address:'',
    city:'',
    state:'',
    jmbg:'',
    phone:'',
    job:'',
    information:'',
    gender:'',

  }

  isSixMonths: boolean = false;
  constructor(private appointmentService: AppointmentsService,
              private userService: UserService,
              private _snackBar: MatSnackBar,
              private rout: Router,
              private personalInfoService: PersonalInfoService,
              private quizService: QuizService) {
  }

  ngOnInit(): void {
  }

  search() {
    console.log("klik na dugme");
    this.appointmentService.getAllFreeTerm(this.date, this.startTime, this.endTime).subscribe(value => {
      this.freeTermins = value;
    });
  }

  sortView($event: Sort) {
    if ($event.direction === 'asc') {
      this.freeTermins.sort((a, b) => (a.centar.review > b.centar.review) ? 1 : -1);
    } else {
      this.freeTermins.sort((a, b) => (a.centar.review < b.centar.review) ? 1 : -1);
    }
  }

  schedule() {
    this.quizService.sixMonthsDonation().subscribe(value => {
      this.isSixMonths = value;
      console.log(value);
      console.log(this.isSixMonths);
    })
    console.log(this.isSixMonths + 'nestoooo');
    if(this.isSixMonths) {
      this.userService.getUser(5).subscribe({
        next:(result) => {
          this.user = result;
        },
        error:(err) => {
          this._snackBar.open(err, 'close', {
            duration:3000
          })
        }
      })
      this.personalInfoService.findPersonalInfo(5).subscribe({
        next:(result) => {
          this.personalInfo = result;
        },
        error:(err) => {
          this._snackBar.open(err.message, 'close', {
            duration:3000
          })


        }, complete:() =>{

          if(this.personalInfo == null){
            this.rout.navigate(['/quiz']);
          }
        }})
    }
    else{
      this._snackBar.open('Nije proslo 6 meseci od zadnjeg davanja krvi', 'zatvori', {
        duration: 3000
      })
    }
  }
}
