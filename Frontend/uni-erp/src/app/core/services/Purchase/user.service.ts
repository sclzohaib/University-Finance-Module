import { User } from './../../models/Purchase/user';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  constructor(private http: HttpClient) { }

  // postMethod
  public saveUser(user: User): Observable<Object> {
	// return this.http.post(environment.baseUrl + 'api/user/', user);
	return this.http.post(environment.baseUrl + 'token/user/', user);

	}

	//get all method
	public getAllUser(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'token/user/');
	}

	//update call
	public updateUser(id: number, user: User){
		return this.http.put(environment.baseUrl+'token/user/' + id, user);
	}

	//delete call
	public deleteUser(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'token/user/' + id);
	}
}
