import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { DepartAddModalComponent } from './components/depart-add-modal/depart-add-modal.component';
import { DepartEditModalComponent } from './components/depart-edit-modal/depart-edit-modal.component';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.less']
})
export class DepartmentComponent implements OnInit {

  constructor(private modalSvc: NzModalService) { }

  ngOnInit() {
  }
  onModalCancel() {

	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Department",
			nzContent: DepartAddModalComponent,
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
			nzTitle: "Edit Department",
			nzContent: DepartEditModalComponent,
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
