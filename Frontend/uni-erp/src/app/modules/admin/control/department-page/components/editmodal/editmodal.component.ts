import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Department } from 'src/app/core/models/department.model';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';

@Component({
	selector: 'editmodal',
	templateUrl: './editmodal.component.html',
	styleUrls: ['./editmodal.component.less']
})
export class EditmodalComponent implements OnInit {

	@Input() name: string;
	@Input() code: string;
	@Input() departments: Array<Department>;

	editForm: FormGroup;

	constructor(private modalRef: NzModalRef<EditmodalComponent, Department>, private fb: FormBuilder) { }

	ngOnInit() {
		this.editForm = this.fb.group({
			code: [{ value: this.code, disabled: true }, [Validators.required]],
			name: [this.name, [Validators.required, duplicateValidator(this.departments.map(x => x.name))]]
		});
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}

	onOk() {
		if (this.editForm.valid) {
			if (this.code === this.editForm.controls['code'].value) {
				this.modalRef.close({
					name: <string>this.editForm.controls['name'].value,
					code: <string>this.editForm.controls['code'].value
				});
			}
		}
	}

}
