import { Role } from './../../models/Purchase/role';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RoleService {


  constructor(private http: HttpClient) { }

  // postMethod
  public saveRole(role: Role): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/role/', role);
	}

	//get all method
	public getAllRole(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/role/');
	}

	//update call
	public updateRole(id: number, role: Role){
		return this.http.put(environment.baseUrl+'api/role/' + id, role);
	}

	//delete call
	public deleteRole(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/role/' + id);
	}
}
