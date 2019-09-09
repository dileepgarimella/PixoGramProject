import {  OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MediaService } from '../media.service'
import { Media } from '../models/Media';
import { FormGroup, FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user.service';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map'
@Component({
  selector: 'app-upload-media',
  templateUrl: './upload-media.component.html',
  styleUrls: ['./upload-media.component.css']
})
export class UploadMediaComponent implements OnInit {

  form: FormGroup;
file: File;

imageToShow:any;
myURL:any

constructor(private fb: FormBuilder, private http: HttpClient,private meadiaService: MediaService,private router:Router,private userService:UserService) {
  this.router.routeReuseStrategy.shouldReuseRoute = function () {
    return false;}

}

ngOnInit() {
    this.createForm();
}

// Instantiate an AbstractControl from a user specified configuration
  createForm() {
    this.form = this.fb.group({
      file_upload: null
    });
  }

  
  fileChange(event: any) {
    // Instantiate an object to read the file content
    let reader = new FileReader();
    // when the load event is fired and the file not empty
    if(event.target.files && event.target.files.length > 0) {
      // Fill file variable with the file content
      this.file = event.target.files[0];
    }
  }

  // Upload the file to the API
  upload() {
    // Instantiate a FormData to store form fields and encode the file
    let body = new FormData();
    // Add file content to prepare the request
    body.append("file", this.file);
this.meadiaService.StoreFile(body,this.userService.id)
.subscribe(
  // Admire results
  (data) => {console.log(data)},
  // Or errors :-(
  error => console.log(error),
  // tell us if it's finished
  () => { console.log("completed") }
);
    // Launch post request
   
    this.router.navigate(['MyMedia']);
   // [routerLink]="['/MyMedia']"
  }
 











  onURLinserted() {
    this.getImage(this.myURL).subscribe(data => {
      this.createImageFromBlob(data);
    }, error => {
      console.log("Error occured",error);
    });
}

getImage(imageUrl: string): Observable<File> {
  return this.http
      .get(imageUrl, { responseType:'blob' })
      .map((res: Response) => res.blob());
}

createImageFromBlob(image: Blob) {
 let reader = new FileReader(); //you need file reader for read blob data to base64 image data.
 reader.addEventListener("load", () => {
    this.imageToShow = reader.result; // here is the result you got from reader
 }, false);

 if (image) {
    reader.readAsDataURL(image);
 }
}
  
}
