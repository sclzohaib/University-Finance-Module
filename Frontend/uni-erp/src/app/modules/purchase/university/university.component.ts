import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { UniAddModalComponent } from './components/uni-add-modal/uni-add-modal.component';
import { UniEditModalComponent } from './components/uni-edit-modal/uni-edit-modal.component';

@Component({
  selector: 'app-university',
  templateUrl: './university.component.html',
  styleUrls: ['./university.component.less']
})
export class UniversityComponent implements OnInit {

  constructor(private modalSvc: NzModalService) { }

  ngOnInit() {
  }
  onModalCancel() {

	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add University",
			nzContent: UniAddModalComponent,
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
			nzTitle: "Edit University",
			nzContent: UniEditModalComponent,
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
