import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import {ThemePalette} from "@angular/material/core";
import {formControl} from "@angular/core/schematics/migrations/typed-forms/util";
import {FormControl} from "@angular/forms";
import {AppointmentsService} from "./appointments.service";
import {Centar} from "../search-centar/centar";
import {FreeTermin} from "../free-termin/free-termin";


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

  constructor(private appointmentService: AppointmentsService) { }

  ngOnInit(): void {
  }

  search() {
    console.log("klik na dugme");
    this.appointmentService.getAllFreeTerm(this.date, this.startTime, this.endTime).subscribe(value => {
      this.freeTermins = value;
    });
  }
}