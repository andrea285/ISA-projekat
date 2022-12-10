import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import {ThemePalette} from "@angular/material/core";
import {formControl} from "@angular/core/schematics/migrations/typed-forms/util";
import {FormControl} from "@angular/forms";


@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrls: ['./appointments.component.css']
})
export class AppointmentsComponent implements OnInit {

  //public date: moment.Moment;
  public disabled = false;
  public showSpinners = true;
  public showSeconds = false;
  public touchUi = false;
  public enableMeridian = false;
  //public minDate: moment.Moment;
  //public maxDate: moment.Moment;
  public stepHour = 1;
  public stepMinute = 1;
  public stepSecond = 1;
  public color: ThemePalette = 'primary';

  public dateControl = new FormControl(new Date(2022, 12, 10, 14, 10))
  public date: Date = new Date();

  constructor() { }

  ngOnInit(): void {
  }

}
