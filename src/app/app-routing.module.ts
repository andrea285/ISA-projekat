import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {UserComponent} from "./user/user.component";
import {UserProfilComponent} from "./user/user-profil/user-profil.component";
import {SearchCentarComponent} from "./search-centar/search-centar.component";
import {FreeTerminComponent} from "./free-termin/free-termin.component";

const routes: Routes=[
  {path: '', component: AppComponent},
  {path: 'user-update', component: UserComponent},
  {path: 'user', component: UserProfilComponent},
  {path: 'centar', component: SearchCentarComponent},
  {path: 'termin', component: FreeTerminComponent}

];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
