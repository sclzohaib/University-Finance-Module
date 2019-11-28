import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Department } from 'src/app/core/models/department.model';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';
import { NzModalRef } from 'ng-zorro-antd';

@Component({
	selector: 'addmodal',
	templateUrl: './addmodal.component.html',
	styleUrls: ['./addmodal.component.less']
})
export class AddmodalComponent implements OnInit {

	@Input() departments: Array<Department>
	addForm: FormGroup;

	constructor(private modalRef: NzModalRef, private fb: FormBuilder) {
	}
	
	ngOnInit() {
		this.addForm = this.fb.group({
			code: ["", [Validators.required, duplicateValidator(this.departments.map(x => x.code))]],
			name: ["", [Validators.required, duplicateValidator(this.departments.map(x => x.name))]]
		})
	}

	onOk() {
		if (this.addForm.valid) {
			this.modalRef.close([
				this.addForm.controls['code'].value,
				this.addForm.controls['name'].value
			]);
		}
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}
}
