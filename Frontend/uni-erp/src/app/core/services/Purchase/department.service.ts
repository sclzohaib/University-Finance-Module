import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Department } from '../../models/Purchase/department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {


  constructor(private http: HttpClient) { }

  // postMethod
  public saveDepartment(dept: Department): Observable<Object> {
    return this.http.post(environment.baseUrl + 'api/department/', dept);
	}

	//get all method
	public getAllDepartment(): Observable<Object>{
		return this.http.get(environment.baseUrl +  'api/department/');
	}

	//update call
	public updateDepartment(id: number, dept: Department){
		return this.http.put(environment.baseUrl+'api/department/' + id, dept);
	}

		//delete call
		public deleteDepartment(id: number):Observable<Object>{
			return this.http.delete(environment.baseUrl+'api/department/' + id);
		}
}
