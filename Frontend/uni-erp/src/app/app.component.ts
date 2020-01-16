import { LoginService } from "./core/services/login.service";
import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { AuthenticationService } from "./Authentication/services/authentication.service";
import { User } from "./core/models/Purchase/user";

@Component({
	selector: "app-root",
	templateUrl: "./app.component.html",
	styleUrls: ["./app.component.less"]
})
export class AppComponent {
	isCollapsed = false;
	// isLoggedIn = false;

	currentUser: User;

	constructor(
		private router: Router,
		private authenticationService: AuthenticationService
	) {
		// this.loginService.isLoggedIn.subscribe(x => {
		// 	this.isLoggedIn = x;

		// });

		this.authenticationService.currentUser.subscribe(
			x => (this.currentUser = x)
		);
	}
	logout() {
		this.authenticationService.logout();
		// this.isLoggedIn = false;
		this.router.navigate(["/"]);
	}
	// signOut(){
	// 	this.isLoggedIn = false;
	// 	this.router.navigate(["/"]);
	// }

	get isAdmin() {
		return this.currentUser && this.currentUser.userType.userType === 'Admin';
	}

}
