import { Component, ViewChild, ElementRef } from '@angular/core';
import {FileUploader} from 'ng2-file-upload';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  @ViewChild('fileInput', {static: false}) fileInput: ElementRef;
 
  uploader: FileUploader;
  isDropOver: boolean;
 
  ngOnInit(): void {
    const headers = [{name: 'Accept', value: 'application/json'}];
    this.uploader = new FileUploader({url: '/files', autoUpload: true, headers: headers});
 
    this.uploader.onCompleteAll = () => alert('File uploaded');
  }
 
  fileOverAnother(e: any): void {
    this.isDropOver = e;
  }
 
  fileClicked() {
    this.fileInput.nativeElement.click();
  }
}

