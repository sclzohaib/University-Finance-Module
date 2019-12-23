import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { AuthSignAddModalComponent } from './components/auth-sign-add-modal/auth-sign-add-modal.component';
import { AuthSignEditModalComponent } from './components/auth-sign-edit-modal/auth-sign-edit-modal.component';

@Component({
  selector: 'app-authorize-signatory',
  templateUrl: './authorize-signatory.component.html',
  styleUrls: ['./authorize-signatory.component.less']
})
export class AuthorizeSignatoryComponent implements OnInit {

  constructor(private modalSvc: NzModalService) { }

  ngOnInit() {
  }
  onModalCancel() {

	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Authorize Signatory",
			nzContent: AuthSignAddModalComponent,
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
			nzTitle: "Edit Authorize Signatory",
			nzContent: AuthSignEditModalComponent,
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
