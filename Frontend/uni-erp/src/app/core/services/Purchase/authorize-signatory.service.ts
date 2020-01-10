import { AuthorizeSignatory } from './../../models/Purchase/authorize-signatory';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthorizeSignatoryService {

  constructor(private http: HttpClient) { }

  // postMethod
  public saveAuthSign(authSign: AuthorizeSignatory): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/authorizeSignatory/', authSign);
	}

	//get all method
	public getAllAuthSign(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/authorizeSignatory/');
	}

	//update call
	public updateAuthSign(id: number, authSign: AuthorizeSignatory):Observable<Object>{
		return this.http.put(environment.baseUrl+'api/authorizeSignatory/' + id, authSign);
	}

	//delete call
	public deleteAuthSign(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/authorizeSignatory/' + id);
	}
}
