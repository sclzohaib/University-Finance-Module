import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
	selector: 'app-login-page',
	templateUrl: './login-page.component.html',
	styleUrls: ['./login-page.component.less']
})
export class LoginPageComponent implements OnInit {
	validateForm: FormGroup;

	constructor(private fb: FormBuilder) { }

	submitForm(): void {
		for (const i in this.validateForm.controls) {
			this.validateForm.controls[i].markAsDirty();
			this.validateForm.controls[i].updateValueAndValidity();
		}
	}


	ngOnInit(): void {
		this.validateForm = this.fb.group({
			userName: [null, [Validators.required]],
			password: [null, [Validators.required]],
			remember: [true]
		});
	}

}
