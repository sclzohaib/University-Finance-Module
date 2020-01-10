import { AuthorizeLvl } from './../../models/Purchase/authorizelvl';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthorizeLvlService {

	constructor(private http: HttpClient) { }

  // postMethod
  public saveAuthLvl(authLvl: Object): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/authorizeLvl/', authLvl);
	}

	//get all method
	public getAllAuthLvl(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/authorizeLvl/');
	}

	//update call
	public updateAuthLvl(id: number, authLvl: AuthorizeLvl):Observable<Object>{
		return this.http.put(environment.baseUrl+'api/authorizeLvl/' + id, authLvl);
	}

	//delete call
	public deleteAuthLvl(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/authorizeLvl/' + id);
	}
}
