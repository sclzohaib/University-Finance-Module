import { Grn } from './../../models/Purchase/grn';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GrnService {


  constructor(private http: HttpClient) { }

  // postMethod
  public saveGrn(grn: Grn): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/grn/', grn);
	}

	//get all method
	public getAllGrn(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/grn/');
	}

	//update call
	public updateGrn(id: number, grn: Grn){
		return this.http.put(environment.baseUrl+'api/grn/' + id, grn);
	}

	//delete call
	public deleteGrn(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/grn/' + id);
	}
}
