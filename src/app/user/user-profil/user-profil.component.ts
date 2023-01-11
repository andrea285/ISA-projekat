import { Component, OnInit } from '@angular/core';
import {User} from "../user";
import {UserService} from "../user.service";
import {FormBuilder} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-user-profil',
  templateUrl: './user-profil.component.html',
  styleUrls: ['./user-profil.component.css']
})
export class UserProfilComponent implements OnInit {

  user: User = {
    id:0,
    firstName:'',
    lastName:'',
    password:'',
    email:'',
    address:'',
    city:'',
    state:'',
    jmbg:'',
    phone:'',
    job:'',
    information:'',
    gender:''
  }
  //userForm: any;
  userForm=this.formBuilder.group({
    id:0,
    firstName:'',
    lastName:'',
    password:'',
    email:'',
    address:'',
    city:'',
    state:'',
    jmbg:'',
    phone:'',
    job:'',
    info:'',
    gender:''
  })

  //id:number=0;
  constructor(private http:UserService,
              private formBuilder: FormBuilder,
              private router: ActivatedRoute,
              private ruter: Router) { }


  ngOnInit(): void {
    //let url=this.router.parseUrl("id");
    //console.log(url)
    let userid = 0;

    this.router.queryParams.subscribe(id=>{
      userid=Number(id['id']);



      this.http.getUser(userid).subscribe((user: User)=>{
        console.log(this.user);
        this.user={
          id:user.id,
          firstName:user.firstName,
          lastName:user.lastName,
          password:user.password,
          email:user.email,
          address:user.address,
          city:user.city,
          state:user.state,
          jmbg:user.jmbg,
          phone:user.phone,
          job:user.job,
          information:user.information,
          gender:user.gender
        }
      });
    })
    console.log(this.user)
  }

  scheduleNew() {
    this.ruter.navigate(['/appointment'])
  }

}
