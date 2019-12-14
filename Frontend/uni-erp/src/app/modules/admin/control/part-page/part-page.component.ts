import { Component, OnInit, OnDestroy } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { Part } from 'src/app/core/models/part.model';
import { PtEditmodalComponent } from './components/pt-editmodal/pt-editmodal.component';
import { Subscription } from 'rxjs';
import { PartService } from 'src/app/core/services/part.service';
import { PtAddmodalComponent } from './components/pt-addmodal/pt-addmodal.component';

@Component({
	selector: 'app-part-page',
	templateUrl: './part-page.component.html',
	styleUrls: ['./part-page.component.less']
})
export class PartPageComponent implements OnInit, OnDestroy {

	parts: Array<Part> = [];
	private subscription: Subscription;

	constructor(private modalSvc: NzModalService, private ptSvc: PartService) { }

	ngOnInit() {
		this.subscription = this.ptSvc.data.subscribe(x => this.parts = x);
	}

	deleteRow(data: string) {
		this.ptSvc.remove(data);
	}
	
	onModalCancel() {
		
	}

	afterAdd = (value: string) => {
		if (value) this.ptSvc.add({
			name: value
		});
	}
	
	afterEdit = (value: { id: number, name: string }) => {
		if (value) this.ptSvc.edit(value.id, value.name);
	}

	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Part",
			nzContent: PtAddmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				parts: this.parts
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(i: number, data: string) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Part",
			nzContent: PtEditmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				id: i,
				name: data,
				parts: this.parts
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterEdit);
	}

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}
}


