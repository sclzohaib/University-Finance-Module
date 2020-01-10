import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AuthenticationService } from '../services/authentication.service';
import { NzMessageService } from 'ng-zorro-antd';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthenticationService,private message: NzMessageService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {
            if (err.status === 401) {
								// auto logout if 401 response returned from api
								this.message.create('error', `Invalid Username or Password!`,{nzDuration:3000}).onClose!;
                this.authenticationService.logout();
                location.reload(true);
            }

            // const error = err.error.message || err.statusText;
            return throwError(err);
        }))
    }
}
