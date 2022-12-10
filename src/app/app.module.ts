import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { UserProfilComponent } from './user/user-profil/user-profil.component';
import { SearchCentarComponent } from './search-centar/search-centar.component';
import { FreeTerminComponent } from './free-termin/free-termin.component';
import {MatFormField, MatFormFieldControl, MatFormFieldModule, MatHint} from "@angular/material/form-field";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatInputModule} from "@angular/material/input";
import {MatIconModule} from "@angular/material/icon";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {NgxMaterialTimepickerModule} from "ngx-material-timepicker";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {MaterialExampleModule} from "./material/material.module";
import { AppointmentsComponent } from './appointments/appointments.component';
import {
  NgxMatDatetimePickerModule,
  NgxMatNativeDateModule,
  NgxMatTimepickerModule
} from "@angular-material-components/datetime-picker";


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    UserProfilComponent,
    SearchCentarComponent,
    FreeTerminComponent,
    AppointmentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule,
    MatIconModule,
    BrowserAnimationsModule,
    NgxMaterialTimepickerModule,
    MatSnackBarModule,
    MaterialExampleModule,
    NgxMatDatetimePickerModule,
    NgxMatNativeDateModule,
    NgxMatDatetimePickerModule,
    NgxMatTimepickerModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
