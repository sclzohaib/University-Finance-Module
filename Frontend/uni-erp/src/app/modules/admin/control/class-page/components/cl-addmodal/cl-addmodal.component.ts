import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';
import { Class } from 'src/app/core/models/class.model';
import { NzModalRef } from 'ng-zorro-antd';

@Component({
	selector: 'cl-addmodal',
	templateUrl: './cl-addmodal.component.html',
	styleUrls: ['./cl-addmodal.component.less']
})
export class ClAddmodalComponent implements OnInit {

	@Input() classes: Array<Class>;
	addForm: FormGroup;
	isVisible: boolean = false;

	constructor(private modalRef: NzModalRef<ClAddmodalComponent>, private fb: FormBuilder) { }

	ngOnInit() {
		this.addForm = this.fb.group({
			name: ["", [Validators.required, Validators.pattern("^(?:(?! )[^0-9]*[^ 0-9])?$"), duplicateValidator(this.classes.map(x => x.name))]]
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
