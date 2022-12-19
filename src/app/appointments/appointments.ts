import {FreeTermin} from "../free-termin/free-termin";
import {User} from "../user/user";

export interface Appointments {
  id: number,
  slobodanTermin: FreeTermin,
  korisnik: User
}
