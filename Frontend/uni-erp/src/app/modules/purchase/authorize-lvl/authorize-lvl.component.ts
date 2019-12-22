import { AuthLvlEditModalComponent } from './components/auth-lvl-edit-modal/auth-lvl-edit-modal.component';
import { AuthLvlAddModalComponent } from './components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';

@Component({
  selector: 'app-authorize-lvl',
  templateUrl: './authorize-lvl.component.html',
  styleUrls: ['./authorize-lvl.component.less']
})
export class AuthorizeLvlComponent implements OnInit {

  constructor(private modalSvc: NzModalService) { }

  ngOnInit() {
	}

	onModalCancel() {

	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Authorize Level",
			nzContent: AuthLvlAddModalComponent,
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
			nzTitle: "Edit Authorize Level",
			nzContent: AuthLvlEditModalComponent,
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
