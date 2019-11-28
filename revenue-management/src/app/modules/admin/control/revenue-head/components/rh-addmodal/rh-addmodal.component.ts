import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { duplicateValidator } from 'src/app/core/validators/duplicate-validator.directive';
import { RevenueHead } from 'src/app/core/models/revenuehead.model';
import { NzModalRef } from 'ng-zorro-antd';

@Component({
	selector: 'rh-addmodal',
	templateUrl: './rh-addmodal.component.html',
	styleUrls: ['./rh-addmodal.component.less']
})
export class RhAddmodalComponent implements OnInit {

	@Input() revenueHeads: Array<RevenueHead>;
	addForm: FormGroup;

	constructor(private modalRef: NzModalRef<RhAddmodalComponent>, private fb: FormBuilder) { }

	ngOnInit() {
		this.addForm = this.fb.group({
			code: ["", [Validators.required, Validators.pattern('[0-9]+'), duplicateValidator(this.revenueHeads.map(x => x.code))]],
			name: ["", [Validators.required, Validators.pattern("^(?:(?! )[^0-9]*[^ 0-9])?$"), duplicateValidator(this.revenueHeads.map(x => x.name))]]
		});
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
