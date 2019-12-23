import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { MinorHeadAddModalComponent } from './components/minor-head-add-modal/minor-head-add-modal.component';
import { MinorHeadEditModalComponent } from './components/minor-head-edit-modal/minor-head-edit-modal.component';

@Component({
  selector: 'app-minor-head',
  templateUrl: './minor-head.component.html',
  styleUrls: ['./minor-head.component.less']
})
export class MinorHeadComponent implements OnInit {

  constructor(private modalSvc: NzModalService) { }

  ngOnInit() {
  }
  onModalCancel() {

	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Minor Head",
			nzContent: MinorHeadAddModalComponent,
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
			nzTitle: "Edit Minor Head",
			nzContent: MinorHeadEditModalComponent,
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
