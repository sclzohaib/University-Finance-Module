import { Component, OnInit } from '@angular/core';
import { LoginService } from '../core/services/login.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthenticationService } from '../Authentication/services/authentication.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.less']
})
export class LoginPageComponent implements OnInit {

	constructor(private loginService: LoginService, private router: Router,	private message: NzMessageService,
		private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private authenticationService: AuthenticationService) {
					// redirect to home if already logged in
					if (this.authenticationService.currentUserValue) {
            this.router.navigate(['/home']);
        }
				}
	// username: string;
	// password: string;
	loginForm: FormGroup;
    // loading = false;
    // submitted = false;
    returnUrl: string;
    error = '';
  ngOnInit() {
		this.loginForm = this.formBuilder.group({
			username: [null, [Validators.required]],
			password: [null, [Validators.required]],
			remember: [true]
		});

	// get return url from route parameters or default to '/'
	this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/home';
	}

	get f() { return this.loginForm.controls; }

  // onLogin(){
	// 	if(this.username=="admin" && this.password=="admin"){
	// 	this.loginService.login();
	// 	this.router.navigate(["/home"]);
	// 	}
	// 	else{
	// 		this.message.create('error', `Invalid Username or Password!`,{nzDuration:3000});
	// 	}
	// }

	onSubmit() {
		for (const i in this.loginForm.controls) {
			this.loginForm.controls[i].markAsDirty();
			this.loginForm.controls[i].updateValueAndValidity();
		}

		// stop here if form is invalid
		if (this.loginForm.invalid) {
				return;
		}

		this.authenticationService.login(this.f.username.value, this.f.password.value)
				.pipe(first())
				.subscribe(
						data => {

								this.router.navigate([this.returnUrl]);
								this.loginService.login();
						},
						error => {
								this.error = error;

						});
}
}
