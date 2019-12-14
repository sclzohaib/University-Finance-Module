import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzModalRef } from 'ng-zorro-antd';
import { Part } from 'src/app/core/models/part.model';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';

@Component({
	selector: 'pt-editmodal',
	templateUrl: './pt-editmodal.component.html',
	styleUrls: ['./pt-editmodal.component.less']
})
export class PtEditmodalComponent implements OnInit {

	@Input() id: number;
	@Input() name: string;
	@Input() parts: Array<Part>

	editForm: FormGroup;

	constructor(private modalRef: NzModalRef<PtEditmodalComponent>, private fb: FormBuilder) { }

	ngOnInit() {
		this.editForm = this.fb.group({
			name: [this.name, [Validators.required, Validators.pattern("^(?:(?! )[^0-9]*[^ 0-9])?$"), duplicateValidator(this.parts.map(x => x.name))]]
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
