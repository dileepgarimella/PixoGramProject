import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8003/user';

username:String="";
id:number;

  constructor(private http: HttpClient) { }

  getUser(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`,user);
  }


  updateUser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getUsers(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  getOtherUsers(): Observable<any> {
    return this.http.get(this.baseUrl+'s/'+this.id);
  }
  deleteAll(): Observable<any> {
    return this.http.delete(`${this.baseUrl}` + `/delete`, { responseType: 'text' });
  }


  follow(uid: number,fid:number ): Observable<Object> {
    return this.http.get(this.baseUrl+'/'+uid+'/'+fid);
  }



  followers(uid: number): Observable<any> {
    return this.http.get(this.baseUrl+'2/'+uid);
  }

  following(uid: number): Observable<any> {
    return this.http.get(this.baseUrl+'1/'+uid);
  }
}

