import { Component, OnInit } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Application } from 'src/app/core/models/Enduser/application.model';

@Component({
	selector: 'app-application-add-modal',
	templateUrl: './application-add-modal.component.html',
	styleUrls: ['./application-add-modal.component.less']
})
export class ApplicationAddModalComponent implements OnInit {
	applicationForm: FormGroup

	constructor(private modalRef: NzModalRef<ApplicationAddModalComponent, Application>, private fb: FormBuilder) { }

	ngOnInit() {
		this.applicationForm = this.fb.group({
			subject: ['', Validators.required],
			associatePerson: ['', Validators.required],
			department: ['', Validators.required],
			university: ['', Validators.required]
		})
	}

	get formControls() {
		return this.applicationForm.controls;
	}

	onOk() {
		this.modalRef.close({
			subject: this.formControls['subject'].value,
			date: new Date(),
			status: "Pending",
			associatePerson: this.formControls['associatePerson'].value,
			department: this.formControls['department'].value,
			university: this.formControls['university'].value,
			quotation: [],
			budgetSheet: null,
			purchaseOrder: null,
			grn: null,
			coveringLetter: null,
			summary: null,
			ledger: null,
			paymentVoucher: null,
		})
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}

}
