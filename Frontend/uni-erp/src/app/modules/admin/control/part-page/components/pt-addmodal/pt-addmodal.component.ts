import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Part } from 'src/app/core/models/part.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';
import { NzModalRef } from 'ng-zorro-antd';

@Component({
	selector: 'pt-addmodal',
	templateUrl: './pt-addmodal.component.html',
	styleUrls: ['./pt-addmodal.component.less']
})
export class PtAddmodalComponent implements OnInit {

	@Input() parts: Array<Part>;
	addForm: FormGroup;
	isVisible: boolean = false;

	constructor(private modalRef: NzModalRef<PtAddmodalComponent>, private fb: FormBuilder) { }

	ngOnInit() {
		this.addForm = this.fb.group({
			name: ["", [Validators.required, Validators.pattern("^(?:(?! )[^0-9]*[^ 0-9])?$"), duplicateValidator(this.parts.map(x => x.name))]]
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
