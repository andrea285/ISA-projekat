import { Component, OnInit } from '@angular/core';
import {User} from "./user";
import {UserService} from "./user.service";
import {FormBuilder} from "@angular/forms";
import * as url from "url";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

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
              private router:Router,
              private location: Location,
              private activatedRoute: ActivatedRoute) { }


  ngOnInit(): void {
    //let url=this.router.parseUrl("id");
    //console.log(url)
    let userid = 0;

    this.activatedRoute.queryParams.subscribe(id=>{
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

  onSubmit() {
    console.log(this.userForm.value)
    this.http.updateUser(this.user).subscribe({
      next:(data)=>{
        console.log(data);
      },complete:()=>{
        //this.router.navigate(['/user?id='+this.user.id]);
        this.location.back();
      }
    });
  }


}
