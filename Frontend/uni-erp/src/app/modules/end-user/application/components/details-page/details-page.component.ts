import { Component, OnInit } from '@angular/core';
import { ApplicationService } from 'src/app/core/services/Enduser/application.service';
import { Subscription } from 'rxjs';
import { Application } from 'src/app/core/models/Enduser/application.model';
import { ActivatedRoute } from '@angular/router';
import { NzModalService } from 'ng-zorro-antd';
import { QuotationAddModalComponent } from '../quotation-add-modal/quotation-add-modal.component';
import { Quotation } from 'src/app/core/models/Enduser/quotation.model';

@Component({
	selector: 'app-details-page',
	templateUrl: './details-page.component.html',
	styleUrls: ['./details-page.component.less']
})
export class DetailsPageComponent implements OnInit {

	appid: number;
	subscription: Subscription;
	application: Application;

	constructor(private appSvc: ApplicationService, private route: ActivatedRoute, private modalSvc: NzModalService) { }

	ngOnInit() {
		this.subscription = this.appSvc.data.subscribe(x => {
			this.appid = +this.route.snapshot.paramMap.get('id');
			this.application = x[this.appid];
		})
	}

	onModalClose = (data: Quotation) => {
		this.application.quotation = [
			...this.application.quotation,
			data
		]
	}

	onAddQuotation() {
		const addModal = this.modalSvc.create({
			nzTitle: "Add Quotation",
			nzContent: QuotationAddModalComponent,
			nzWidth: 700,
			nzFooter: null,
		});
		addModal.afterClose.subscribe(this.onModalClose)
	}

}
