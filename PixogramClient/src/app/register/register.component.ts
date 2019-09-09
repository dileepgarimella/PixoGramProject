import { Component, OnInit } from '@angular/core';
import { User } from '../models/User';
import { UserService } from '../user.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username: String;
  firstname: String;
  lastname: String;
  email: String;
  password: String;
  rPassword: String;
  submitted = false;

  constructor(private userService: UserService, private authService: AuthService,private router: Router) { }
  

  ngOnInit() {
    
  }
 
  register(){
    this.authService.change();
  }

  onSubmit() {
    this.submitted = true;
    let user = new User(this.firstname,this.lastname,this.username, this.password,this.email);
    this.userService.createUser(user)
    .subscribe(data => console.log(data), error => console.log(error));

    this.router.navigate(['MyMedia']);
  }

}
