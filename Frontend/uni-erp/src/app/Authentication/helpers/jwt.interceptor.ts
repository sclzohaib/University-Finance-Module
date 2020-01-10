import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../services/authentication.service';


@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthenticationService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
				// let currentUser = this.authenticationService.currentUserValue;
        // if (currentUser && currentUser.token) {
				// 		console.log(currentUser.token);
        //     request = request.clone({
        //         setHeaders: {
        //             Authorization: `Bearer ${currentUser.token}`
        //         }
        //     });
				// }

				if(localStorage.length > 0){
					let currentUser = localStorage.getItem('currentUser');
					const headers = new HttpHeaders({
						Authorization: JSON.parse(currentUser)['token'],
						'Content-Type': 'application/json',
						'Access-Control-Allow-Credentials': 'true'
					});
					const changedReq = request.clone({ headers });
					return next.handle(changedReq);
				} else {
					const changedReq = request.clone({
						headers: request.headers.set('Content-Type', 'application/json')
					});
					return next.handle(changedReq);
				}


    }
}
