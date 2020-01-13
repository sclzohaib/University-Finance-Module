import { QuotationAddModalComponent } from './../../../../purchase/Flows/quotation-add-modal/quotation-add-modal.component';
import { Component, OnInit } from '@angular/core';
import { NzModalRef, NzModalService } from 'ng-zorro-antd';
import { ApplicationAddModalComponent } from '../application-add-modal/application-add-modal.component';

@Component({
  selector: 'app-application-view-modal',
  templateUrl: './application-view-modal.component.html',
  styleUrls: ['./application-view-modal.component.less']
})
export class ApplicationViewModalComponent implements OnInit {

  constructor(private modalRef: NzModalRef<ApplicationViewModalComponent>,private modalSvc: NzModalService) { }

  ngOnInit() {
  }
	onCancel() {
    this.modalRef.triggerCancel();
	}
	onModalCancel() {

	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Quotation",
			nzWidth: 1000,
			nzContent: QuotationAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				// feeTypes: this.feeTypes
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}
}
