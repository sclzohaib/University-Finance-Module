import { ApplicationViewModalComponent } from './components/application-view-modal/application-view-modal.component';
import { ApplicationAddModalComponent } from './components/application-add-modal/application-add-modal.component';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { Application } from 'src/app/core/models/Enduser/application.model';
import { ApplicationService } from 'src/app/core/services/Enduser/application.service';
import { Subscription } from 'rxjs';

@Component({
	selector: 'app-application',
	templateUrl: './application.component.html',
	styleUrls: ['./application.component.less']
})
export class ApplicationComponent implements OnInit, OnDestroy {

	applications: Array<Application> = [];
	subscription = new Subscription();

	constructor(private modalSvc: NzModalService, private appSvc: ApplicationService) {
		this.subscription = this.appSvc.data.subscribe(x => this.applications = x)
	}

	ngOnInit() {
	}

	onModalCancel() {

	}

	afterAdd = (data: Application) => {
		this.appSvc.add(data);
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
		modal.afterClose.subscribe(this.afterAdd);
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

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}

}
