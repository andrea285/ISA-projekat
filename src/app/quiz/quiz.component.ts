import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PersonalInfo} from "./personal-info/personal-info";
import {Upitnik} from "./personal-info/upitnik";
import {MatSnackBar} from "@angular/material/snack-bar";
import {QuizService} from "./quiz.service";
import {SharingDataService} from "../shared/sharing-data.service";
import {AppointmentsService} from "../appointments/appointments.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  personalInformation: PersonalInfo = {
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
    previousDonations: '',
    korisnik: 0
  };

  questions: Upitnik = {
    id: 0,
    dobrovoljan: false,
    odbijen: false,
    lekovi: false,
    nahranjen: false,
    tetoviran: false
  };

  constructor(private _sneakBar: MatSnackBar,
              private quizService: QuizService,
              private router: Router,
              private sharedService: SharingDataService,
              private appointmentsService: AppointmentsService) { }

  ngOnInit(): void {
  }

  setPersInfo(personalInformation: PersonalInfo) {
    this.personalInformation = personalInformation;

  }

  setQuestions(u: Upitnik) {
  this.questions = u;
  }


  save(){


    this.personalInformation.korisnik = 5;

    if (this.personalInformation.fullName == '' || this.personalInformation.sex == '' || this.personalInformation.address == '' || this.personalInformation.jmbg == '' || this.personalInformation.dateOfBirth == '' || this.personalInformation.district == '' || this.personalInformation.city == '' || this.personalInformation.homeNumber == ''
      || this.personalInformation.mobile == '' || this.personalInformation.jobNumber == '' || this.personalInformation.occupation == '' || this.personalInformation.jobTitle == '' || this.personalInformation.previousDonations == '' || this.personalInformation.korisnik == 0) {
      this._sneakBar.open('popuni sve informacije', 'zatvori', {
        duration: 3000
      })
    } else {

      this.quizService.save(this.personalInformation, this.questions).subscribe({
        error: (err) => {
          this._sneakBar.open(err.message, 'zatvori', {
            duration: 3000
          })
        }, complete: () => {
          console.log(this.sharedService.getData()+" asdasdqwe")
          this._sneakBar.open('uspesno ste sacuvali upitnik i Termin za davanje krvi', 'zatvori', {
            duration: 3000
          })
          this.appointmentsService.saveAppointment(this.sharedService.getData(),5).subscribe({
            complete: () => {
              this.router.navigate(['/user'], {queryParams: {id: 5}});
            }
          });
        }
      });
    }

  }
}
