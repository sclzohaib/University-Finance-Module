import { ApplicationViewModalComponent } from './components/application-view-modal/application-view-modal.component';
import { ApplicationAddModalComponent } from './components/application-add-modal/application-add-modal.component';
import { Component, OnInit } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';

@Component({
  selector: 'app-application',
  templateUrl: './application.component.html',
  styleUrls: ['./application.component.less']
})
export class ApplicationComponent implements OnInit {

  constructor(private modalSvc: NzModalService) { }

  ngOnInit() {
	}

	onModalCancel() {

	}

onAdd() {
	const modal = this.modalSvc.create({
		nzTitle: "Add Application",
		nzContent: ApplicationAddModalComponent,
		nzOnCancel: this.onModalCancel.bind(this),
		nzOnOk: this.onModalCancel.bind(this),
		nzComponentParams: {
			// feeTypes: this.feeTypes
		},
		nzFooter: null
	});
	// modal.afterClose.subscribe(this.afterAdd);
}

onEdit() {
	const modal = this.modalSvc.create({
		nzTitle: "View Application",
		nzWidth: 520,
		nzContent: ApplicationViewModalComponent,
		nzOnCancel: this.onModalCancel.bind(this),
		nzOnOk: this.onModalCancel.bind(this),
		nzComponentParams: {

		},
		nzFooter: null
	});
	// modal.afterClose.subscribe(this.afterEdit);
}

}
