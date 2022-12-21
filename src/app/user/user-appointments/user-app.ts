import {User} from "../user";
import {Appointments} from "../../appointments/appointments";
import {FreeTermin} from "../../free-termin/free-termin";

export interface UserApp {

  slobodanTermin: FreeTermin,
  korisnik: User,
}
