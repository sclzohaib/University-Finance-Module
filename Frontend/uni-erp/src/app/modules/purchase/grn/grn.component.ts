import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { GrnEditModalComponent } from './components/grn-edit-modal/grn-edit-modal.component';
import { GrnAddModalComponent } from './components/grn-add-modal/grn-add-modal.component';

@Component({
  selector: 'app-grn',
  templateUrl: './grn.component.html',
  styleUrls: ['./grn.component.less']
})
export class GrnComponent implements OnInit {

  constructor(private modalSvc: NzModalService) { }

  ngOnInit() {
  }
  onModalCancel() {

	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add GRN",
			nzContent: GrnAddModalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				// feeTypes: this.feeTypes
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit() {
		const modal = this.modalSvc.create({
			nzTitle: "Edit GRN",
			nzContent: GrnEditModalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				// id: id,
				// feeType: data
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);
	}
}
