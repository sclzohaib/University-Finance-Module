import { MinorHead } from './../../models/Purchase/minor-head';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MinorHeadService {


  constructor(private http: HttpClient) { }

  // postMethod
  public saveMinorHead(minorHead: MinorHead): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/minorHead/', minorHead);
	}

	//get all method
	public getAllMinorHead(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/minorHead/');
	}

	//update call
	public updateMinorHead(id: number, minorHead: MinorHead){
		return this.http.put(environment.baseUrl+'api/minorHead/' + id, minorHead);
	}

	//delete call
	public deleteMinorHead(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/minorHead/' + id);
	}
}
