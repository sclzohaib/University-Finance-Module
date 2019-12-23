import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { MajorHeadAddModalComponent } from './components/major-head-add-modal/major-head-add-modal.component';
import { MajorHeadEditModalComponent } from './components/major-head-edit-modal/major-head-edit-modal.component';

@Component({
  selector: 'app-major-head',
  templateUrl: './major-head.component.html',
  styleUrls: ['./major-head.component.less']
})
export class MajorHeadComponent implements OnInit {

  constructor(private modalSvc: NzModalService) { }

  ngOnInit() {
  }
  onModalCancel() {

	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Major Head",
			nzContent: MajorHeadAddModalComponent,
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
			nzTitle: "Edit Major Head",
			nzContent: MajorHeadEditModalComponent,
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
