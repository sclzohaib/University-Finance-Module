import { Component, OnInit, OnDestroy } from '@angular/core';
import { RevenueHead } from 'src/app/core/models/revenuehead.model';
import { NzModalService } from 'ng-zorro-antd';
import { RhEditmodalComponent } from './components/rh-editmodal/rh-editmodal.component';
import { RevenueheadService } from 'src/app/core/services/revenuehead.service';
import { Subscription } from 'rxjs';
import { RhAddmodalComponent } from './components/rh-addmodal/rh-addmodal.component';

@Component({
	selector: 'app-revenue-head',
	templateUrl: './revenue-head.component.html',
	styleUrls: ['./revenue-head.component.less']
})
export class RevenueHeadComponent implements OnInit, OnDestroy {

	revenueHeads: Array<RevenueHead> = [];
	private subscription: Subscription;

	constructor(private modalSvc: NzModalService, private rhSvc: RevenueheadService) { }

	ngOnInit() {
		this.subscription = this.rhSvc.data.subscribe(x => this.revenueHeads = x);
	}

	deleteRow(code: string) {
		this.rhSvc.remove(code);
	}

	onModalCancel() {

	}

	afterAdd = (value: Array<string>) => {
		if (value) this.rhSvc.add({ code: value[0], name: value[1] });
	}

	afterEdit = (value: RevenueHead) => {
		if (value) this.rhSvc.edit(value);
	}

	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Part",
			nzContent: RhAddmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				revenueHeads: this.revenueHeads
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(data: RevenueHead) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Department",
			nzContent: RhEditmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				name: data.name,
				code: data.code
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterEdit);
	}

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}
}