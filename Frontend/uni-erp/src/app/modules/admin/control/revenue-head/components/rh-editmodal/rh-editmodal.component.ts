import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RevenueHead } from 'src/app/core/models/revenuehead.model';
import { NzModalRef } from 'ng-zorro-antd';

@Component({
	selector: 'app-rh-editmodal',
	templateUrl: './rh-editmodal.component.html',
	styleUrls: ['./rh-editmodal.component.less']
})
export class RhEditmodalComponent implements OnInit {

	@Input() name: string;
	@Input() code: string;

	editForm: FormGroup;

	constructor(private modalRef: NzModalRef<RhEditmodalComponent, RevenueHead>, private fb: FormBuilder) { }

	ngOnInit() {
		this.editForm = this.fb.group({
			code: [{ value: this.code, disabled: true }, [Validators.required]],
			name: [this.name, [Validators.required]]
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
