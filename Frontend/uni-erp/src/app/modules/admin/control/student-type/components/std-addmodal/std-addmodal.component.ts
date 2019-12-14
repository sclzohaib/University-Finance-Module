import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';
import { StudentType } from 'src/app/core/models/student.model';
import { NzModalRef } from 'ng-zorro-antd';

@Component({
	selector: 'std-addmodal',
	templateUrl: './std-addmodal.component.html',
	styleUrls: ['./std-addmodal.component.less']
})
export class StdAddmodalComponent implements OnInit {

	@Input() studentTypes: Array<StudentType>;
	addForm: FormGroup;
	isVisible: boolean = false;

	constructor(private modalRef: NzModalRef<StdAddmodalComponent>, private fb: FormBuilder) { }

	ngOnInit() {
		this.addForm = this.fb.group({
			name: ["", [Validators.required, Validators.pattern("^(?:(?! )[^0-9]*[^ 0-9])?$"), duplicateValidator(this.studentTypes.map(x => x.name))]]
		});
	}

	onOk() {
		if (this.addForm.valid) {
			this.modalRef.close(this.addForm.controls['name'].value);
		}
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}
}
