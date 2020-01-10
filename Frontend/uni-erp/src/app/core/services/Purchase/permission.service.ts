import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Permission } from '../../models/Purchase/permission';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PermissionService {


  constructor(private http: HttpClient) { }

  // postMethod
  public savePermission(permission: Permission): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/permission/', permission);
	}

	//get all method
	public getAllPermission(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/permission/');
	}

	//update call
	public updatePermission(id: number, permission: Permission){
		return this.http.put(environment.baseUrl+'api/permission/' + id, permission);
	}

	//delete call
	public deletePermission(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/permission/' + id);
	}
}
