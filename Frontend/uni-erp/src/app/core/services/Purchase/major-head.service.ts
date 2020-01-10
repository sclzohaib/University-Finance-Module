import { MajorHead } from './../../models/Purchase/major-head';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MajorHeadService {


  constructor(private http: HttpClient) { }

  // postMethod
  public saveMajorHead(majorHead: MajorHead): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/majorHead/', majorHead);
	}

	//get all method
	public getAllMajorHead(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/majorHead/');
	}

	//update call
	public updateMajorHead(id: number, majorHead: MajorHead){
		return this.http.put(environment.baseUrl+'api/majorHead/' + id, majorHead);
	}

	//delete call
	public deleteMajorHead(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/majorHead/' + id);
	}
}
