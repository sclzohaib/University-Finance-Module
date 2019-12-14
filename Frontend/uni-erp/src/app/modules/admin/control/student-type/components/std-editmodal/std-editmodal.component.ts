import { Component, OnInit, Input } from '@angular/core';
import { NzModalRef } from 'ng-zorro-antd';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';
import { StudentType } from 'src/app/core/models/student.model';

@Component({
	selector: 'std-editmodal',
	templateUrl: './std-editmodal.component.html',
	styleUrls: ['./std-editmodal.component.less']
})
export class StdEditmodalComponent implements OnInit {

	@Input() id: number;
	@Input() name: string;
	@Input() studentTypes: Array<StudentType>;

	editForm: FormGroup;

	constructor(private modalRef: NzModalRef<StdEditmodalComponent>, private fb: FormBuilder) { }

	ngOnInit() {
		this.editForm = this.fb.group({
			name: [this.name, [Validators.required, Validators.pattern("^(?:(?! )[^0-9]*[^ 0-9])?$"), duplicateValidator(this.studentTypes.map(x => x.name))]]
		});
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}

	onOk() {
		if (this.editForm.valid) {
			this.modalRef.close({
				id: this.id,
				name: <string>this.editForm.controls['name'].value
			});
		}
	}
}