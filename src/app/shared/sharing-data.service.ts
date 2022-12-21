import { Injectable } from '@angular/core';
import {Appointments} from "../appointments/appointments";

@Injectable({
  providedIn: 'root'
})
export class SharingDataService {

  constructor() { }

  private appointmentId : number=0;

  setAppointmentId(appointmentId: number) {
    this.appointmentId = appointmentId;
  }

  getData() {
    return this.appointmentId;
  }
  clearData() {
    this.appointmentId = 0;
  }


}
