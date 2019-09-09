import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Media } from './models/Media';

@Injectable({
  providedIn: 'root'
})
export class MediaService {

  private baseUrl = 'http://localhost:8003/api';

  constructor(private http: HttpClient) { }

  StoreFile(mediafile: FormData,id:number): Observable<object> {
  return  this.http.post('http://localhost:8003/api/storeImages/'+id, mediafile);
    
    }
    getCustomerImages(id: number): Observable<any> {
  
   
      console.log(this.http.get(this.baseUrl+'/downloadFile/'+id));

      return  this.http.get(this.baseUrl+'/downloadFile/'+id);
    }


    getCustomerImages1(id: number): Observable<any> {
  
   
      console.log(this.http.get(this.baseUrl+'/downloadFiles/'+id));

      return  this.http.get(this.baseUrl+'/downloadFiles/'+id );
    }
 
 
}
