import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserType } from '../../models/Purchase/user-type';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserTypeService {

  constructor(private http: HttpClient) { }
	// postMethod
  public saveUserType(userType: UserType): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/userType/', userType);
	}

	//get all method
	public getAllUserType(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/userType/');
	}

	//update call
	public updateUserType(id: number, userType: UserType){
		return this.http.put(environment.baseUrl+'api/userType/' + id, userType);
	}

	//delete call
	public deleteUserType(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/userType/' + id);
	}
}
