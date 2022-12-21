import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {NgSignaturePadOptions} from "@almothafar/angular-signature-pad";
import {PersonalInfo} from "./personal-info";
import * as events from "events";

@Component({
  selector: 'app-personal-info',
  templateUrl: './personal-info.component.html',
  styleUrls: ['./personal-info.component.css']
})
export class PersonalInfoComponent implements OnInit {

  @Output() personalInfoEmitter = new EventEmitter();
  constructor() { }

  personalinformation: PersonalInfo = {
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
  }

  ngOnInit(): void {
  }

  confirm() {

  }

  onChange(){
    console.log('sssssss');
    this.personalInfoEmitter.emit(this.personalinformation);
  }
}
