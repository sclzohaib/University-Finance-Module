import { Injectable } from '@angular/core';
import { Application } from '../../models/Enduser/application.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class ApplicationService {

	private applications: Array<Application> = [];
	data: BehaviorSubject<Application[]> = new BehaviorSubject([]);

	constructor() {
		this.add({
			subject: "aqwe",
			date: new Date(),
			status: "Pending",
			associatePerson: "rtyert",
			department: "sdsgv",
			university: "tyurg",
			quotation: [],
			budgetSheet: null,
			purchaseOrder: null,
			grn: null,
			coveringLetter: null,
			summary: null,
			ledger: null,
			paymentVoucher: null,
		})
	}

	add(data: Application) {
		this.applications = [
			...this.applications,
			data
		];
		this.data.next(this.applications);
	}

	// edit(id: number, name: string) {
	// 	this.applications[id].name = name;
	// 	this.data.next(this.applications);
	// }

	// remove(name: string) {
	// 	this.applications = this.applications.filter(x => x.name !== name);
	// 	this.data.next(this.applications);
	// }

}
