import { Component, OnInit, OnDestroy } from '@angular/core';
import { FeeType } from 'src/app/core/models/feetype.model';
import { NzModalService } from 'ng-zorro-antd';
import { FtaddmodalComponent } from './components/ftaddmodal/ftaddmodal.component';
import { FeetypeService } from 'src/app/core/services/feetype.service';
import { Subscription } from 'rxjs';
import { FteditmodalComponent } from './components/fteditmodal/fteditmodal.component';

@Component({
	selector: 'app-fee-page',
	templateUrl: './fee-page.component.html',
	styleUrls: ['./fee-page.component.less']
})
export class FeePageComponent implements OnInit, OnDestroy {

	feeTypes: Array<FeeType> = [];
	private subscription: Subscription;

	constructor(private modalSvc: NzModalService, private ftSvc: FeetypeService) { }

	ngOnInit() {
		this.subscription = this.ftSvc.data.subscribe(x => this.feeTypes = x);
	}

	afterAdd = (value: FeeType) => {
		if (value) this.ftSvc.add(value);
	}

	afterEdit = (value: { id: number, feetype: string, revenueHead: string, studentType: Array<string>, classes: Array<string>, parts: Array<string>, amount: number }) => {
		if (value) this.ftSvc.edit(value.id, value.feetype, value.revenueHead, value.studentType, value.classes, value.parts, value.amount);
	}

	onModalCancel() {

	}

	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Fee Type",
			nzContent: FtaddmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				feeTypes: this.feeTypes
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(id: number, data: FeeType) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Fee Type",
			nzContent: FteditmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				id: id,
				feeType: data
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterEdit);
	}

	deleteRow(id: string) {
		this.ftSvc.remove(id);
	}

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}
}
