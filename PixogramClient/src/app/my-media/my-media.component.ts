import { Component, OnInit } from '@angular/core';
import { MediaService } from '../media.service';
import { imageToShow } from './imageToShow.component';
import { Media } from '../models/Media';
import { DomSanitizer } from '@angular/platform-browser';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-media',
  templateUrl: './my-media.component.html',
  styleUrls: ['./my-media.component.css']
})
export class MyMediaComponent implements OnInit {
 


src1:Media[];


src2:any;
units:any;
urll:string;
  constructor(private sanitizer:DomSanitizer ,private mediaService: MediaService,private userservice:UserService,private router:Router) { 
    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;}
  }

  sanitize(url:string) {
    return this.sanitizer.bypassSecurityTrustUrl(url); 
  }

   print(){
    console.log(this.src1);
   }


  ngOnInit() {

    this.mediaService.getCustomerImages(this.userservice.id).subscribe(response => this.src1 = response);

   
  }

}
