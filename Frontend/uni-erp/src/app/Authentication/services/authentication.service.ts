import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from 'src/app/core/models/Purchase/user';
import { environment } from 'src/environments/environment';
import { UserType } from 'src/app/core/models/Purchase/user-type';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
		public currentUser: Observable<User>;
		user: User = new User();
		userType: UserType = new UserType();

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
				this.currentUser = this.currentUserSubject.asObservable();

    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(username: string, password: string) {

        return this.http.post<any>(`${environment.baseUrl}token/generate-token`, { username, password })
            .pipe(map(response => {

							this.user.name = response.result.username;
							this.user.email = response.result.email;
							this.user.token = response.result.token;
							this.userType.userType =  response.result.userType;
							this.user.userType = this.userType;

							// store user details and jwt token in local storage to keep user logged in between page refreshes

                localStorage.setItem('currentUser', JSON.stringify(this.user));
                this.currentUserSubject.next(this.user);
                return this.user;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}
