import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
isLoggedin = false;
  constructor() { }
change(){
  this.isLoggedin = true;

}
change1(){
  this.isLoggedin = false;

}

}
