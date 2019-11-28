import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzModalRef } from 'ng-zorro-antd';
import { Class } from 'src/app/core/models/class.model';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';

@Component({
	selector: 'cl-editmodal',
	templateUrl: './cl-editmodal.component.html',
	styleUrls: ['./cl-editmodal.component.less']
})
export class ClEditmodalComponent implements OnInit {

	@Input() id: number;
	@Input() name: string;
	@Input() classes: Array<Class>;

	editForm: FormGroup;

	constructor(private modalRef: NzModalRef<ClEditmodalComponent>, private fb: FormBuilder) { }

	ngOnInit() {
		this.editForm = this.fb.group({
			name: [this.name, [Validators.required, Validators.pattern("^(?:(?! )[^0-9]*[^ 0-9])?$"), duplicateValidator(this.classes.map(x => x.name))]]
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