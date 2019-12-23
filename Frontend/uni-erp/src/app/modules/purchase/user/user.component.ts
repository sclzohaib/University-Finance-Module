import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { UserAddModalComponent } from './components/user-add-modal/user-add-modal.component';
import { UserEditModalComponent } from './components/user-edit-modal/user-edit-modal.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.less']
})
export class UserComponent implements OnInit {

  constructor(private modalSvc: NzModalService) { }

  ngOnInit() {
  }
  onModalCancel() {

	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add User",
			nzContent: UserAddModalComponent,
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
			nzTitle: "Edit User",
			nzContent: UserEditModalComponent,
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
