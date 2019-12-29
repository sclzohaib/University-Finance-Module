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
}
