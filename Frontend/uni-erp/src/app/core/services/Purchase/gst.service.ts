import { Gst } from './../../models/Purchase/gst';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GstService {

	constructor(private http: HttpClient) { }
	// postMethod
  public saveGst(gst: Gst): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/gst/', gst);
	}

	//get all method
	public getAllGst(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/gst/');
	}

	//update call
	public updateGst(id: number, gst: Gst){
		return this.http.put(environment.baseUrl+'api/gst/' + id, gst);
	}

	//delete call
	public deleteGst(id: number):Observable<Object>{
		return this.http.delete(environment.baseUrl+'api/gst/' + id);
	}
}
