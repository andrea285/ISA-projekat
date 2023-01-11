import { Component, OnInit } from '@angular/core';
import {UserApp} from "./user-app";
import {AppointmentsService} from "../../appointments/appointments.service";
import {Appointments} from "../../appointments/appointments";
import {User} from "../user";
import {FreeTermin} from "../../free-termin/free-termin";
import {Centar} from "../../search-centar/centar";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-appointments',
  templateUrl: './user-appointments.component.html',
  styleUrls: ['./user-appointments.component.css']
})
export class UserAppointmentsComponent implements OnInit {

  userApps: UserApp[] = [];


  constructor(private appService: AppointmentsService,
              private router: Router) { }

  ngOnInit(): void {
    this.appService.getAllAppointmentsById(5).subscribe({
      next: data => {
        this.userApps = data;
        console.log(this.userApps.toString());

      },error: err => {
        console.log(err);

      },
      complete: () => {
        console.log(this.userApps.length);
      }
    });
  }


  cancel(id: number) {
    this.appService.deleteAppointmentByid(id).subscribe({
      complete: () => {
        window.location.reload();
      }
    });
  }
}
