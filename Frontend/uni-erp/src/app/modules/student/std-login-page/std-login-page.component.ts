import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { NzMessageService, UploadFile, NzModalService } from 'ng-zorro-antd';
import { Observable, Observer } from 'rxjs';
import { VoucherModalComponent } from './components/voucher-modal/voucher-modal.component';

@Component({
	selector: 'app-std-login-page',
	templateUrl: './std-login-page.component.html',
	styleUrls: ['./std-login-page.component.less']
})
export class StdLoginPageComponent implements OnInit {
	radioValue = "A";
	loginForm: FormGroup;
	registerForm: FormGroup;

	index: number = 1;
	
	constructor(private msg: NzMessageService, private fb: FormBuilder, private modalSvc:NzModalService) { }

	submitForm(): void {
		for (const i in this.loginForm.controls) {
			this.loginForm.controls[i].markAsDirty();
			this.loginForm.controls[i].updateValueAndValidity();
		}
	}


	ngOnInit(): void {
		this.loginForm = this.fb.group({
			cnic: [null, [Validators.required]],
			password: [null, [Validators.required]],
			remember: [true]
		});
		this.registerForm = this.fb.group({
			name: [null, [Validators.required]],
			fatherName: [null, [Validators.required]],
			cnic: [null, [Validators.required]],
			password: [null, [Validators.required]],
			checkPassword: [null, [Validators.required, this.confirmationValidator]],
			phoneNumberPrefix: ['+92'],
			phoneNumber: [null, [Validators.required]],
			email: [null, [Validators.email, Validators.required]],
			enrolNumber: [null],
			seatNumber: [null],

		});
	}


	updateConfirmValidator(): void {
		/** wait for refresh value */
		Promise.resolve().then(() => this.registerForm.controls.checkPassword.updateValueAndValidity());
	}
	confirmationValidator = (control: FormControl): { [s: string]: boolean } => {
		if (!control.value) {
			return {
				required: true
			};
		} else if (control.value !== this.registerForm.controls.password.value) {
			return {
				confirm: true,
				error: true
			};
		}
		return {};
	};
onModalCancel(){

}
afterAdd=()=>{};

	printVoucher():void{
		const modal = this.modalSvc.create({
			nzTitle: "Print Voucher",
			nzContent: VoucherModalComponent,
			nzOnCancel: this.onModalCancel,
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterAdd);
	
	}

	pre(): void {
		this.index -= 1;
	}

	next(): void {
		this.index += 1;
	}

	done(): void {
		console.log('done');
	}
}