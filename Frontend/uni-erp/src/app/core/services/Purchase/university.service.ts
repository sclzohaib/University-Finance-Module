import { University } from './../../models/Purchase/university';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UniversityService {


  constructor(private http: HttpClient) { }

  // postMethod
  public saveUniversity(university: University): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/university/', university);
	}

	//get all method
	public getAllUniversity(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/university/');
	}

	//update call
	public updateUniversity(id: number, university: University):Observable<Object>{
		return this.http.put(environment.baseUrl+'api/university/' + id, university);
	}

	//delete call
	public deleteUniversity(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/university/' + id);
	}
}
