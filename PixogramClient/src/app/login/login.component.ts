import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { User } from '../models/User';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: String;
  password: String;
  invalidLogin: boolean = false;
  users: User[];

  constructor(private router: Router,public authService: AuthService,private userService: UserService) {

   }

  ngOnInit() {
    this.userService.getUsers().subscribe(response => this.users = response);
    
  }

  onLogin(){
    this.authService.change();
  }
  onLogout(){
    this.authService.change1();
  }
  onLoginSubmit(){
    for (let i = 0; i < this.users.length; i++) {
      if (this.users[i].username === this.username && this.users[i].password === this.password) {
        this.userService.id=this.users[i].id;
        this.userService.username=this.users[i].firstname;
        this.router.navigate(['MyMedia']);
        this.invalidLogin = false;
        localStorage.setItem("userId", this.users[i].id.toString());
        this.onLogin();
        console.log(this.users[0].email);
      } 
      else {
        this.invalidLogin = true;
      }
    }
  }

}
