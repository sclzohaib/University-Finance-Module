import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { QuotationItem } from 'src/app/core/models/Enduser/quotation-item.model';
import { NzModalRef } from 'ng-zorro-antd';
import { Quotation } from 'src/app/core/models/Enduser/quotation.model';
import { Vendor } from 'src/app/core/models/Enduser/vendor.model';

@Component({
	selector: 'app-quotation-add-modal',
	templateUrl: './quotation-add-modal.component.html',
	styleUrls: ['./quotation-add-modal.component.less']
})
export class QuotationAddModalComponent implements OnInit {

	addQuotationForm: FormGroup;
	editCache: { [key: string]: { edit: boolean; data: QuotationItem } } = {};
	items: Array<QuotationItem> = [];

	constructor(private modalRef: NzModalRef<QuotationAddModalComponent, Quotation>, private fb: FormBuilder) { }

	ngOnInit() {
		this.addQuotationForm = this.fb.group({
			subject: ['', [Validators.required]],
			termsConditions: ['', [Validators.required]],
			vendor: ['', [Validators.required]]
		});

		this.updateEditCache();
	}

	get formControls() {
		return this.addQuotationForm.controls;
	}

	addItem() {
		this.items = [
			...this.items,
			new QuotationItem()
		];
		this.updateEditCache();
	}

	removeItem() {
		this.items = this.items.slice(0, -1);
	}

	startEdit(id: number): void {
		this.editCache[id].edit = true;
	}

	cancelEdit(id: number): void {
		const index = id;
		this.editCache[id] = {
			data: { ...this.items[index] },
			edit: false
		};
	}

	saveEdit(id: number): void {
		const index = id
		Object.assign(this.items[index], this.editCache[id].data);
		this.editCache[id].edit = false;
	}

	updateEditCache(): void {
		this.items.forEach((item, id) => {
			this.editCache[id] = {
				edit: false,
				data: { ...item }
			};
		});
	}

	onCancel() {
		this.modalRef.triggerCancel();
	}

	onOk() {
		this.modalRef.close({
			date: new Date(),
			items: this.items,
			subject: this.formControls['subject'].value,
			termsAndConditions: this.formControls['termsConditions'].value,
			vendor: new Vendor(),
			totalAmount: 1234441,
			isApproved: false
		})
	}
}