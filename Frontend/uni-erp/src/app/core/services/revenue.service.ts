import { Injectable } from '@angular/core';
import { Revenue } from '../models/revenue.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class RevenueService {

	revenueData: Array<Revenue> = [];
	data: BehaviorSubject<Revenue[]> = new BehaviorSubject([]);

	constructor() {
		this.add({
			id: '0',
			studentCnic: '4210112312412',
			studentType: 'Private',
			revenueHead: 'Degree Fee (5503)',
			department: 'Computer Science',
			monthYearPaid: 'Feb 2019',
			isPaid: true,
			shift: "Morning",
			amount: 24122
		});
		this.add({
			id: '1',
			studentCnic: '4210112312212',
			studentType: 'Overseas',
			revenueHead: 'Examination Fee (5502)',
			department: 'Teacher Education',
			monthYearPaid: 'Jan 2014',
			shift: "Morning",
			isPaid: true,
			amount: 12124
		});
		this.add({
			id: '2',
			studentCnic: '4210115532212',
			studentType: 'Overseas',
			revenueHead: 'Examination Fee (5502)',
			department: 'Teacher Education',
			monthYearPaid: 'Jan 2015',
			shift: "Evening",
			isPaid: true,
			amount: 14334
		});
	}

	add(revenueDato: Revenue) {
		this.revenueData = [
			...this.revenueData,
			revenueDato
		];
		this.data.next(this.revenueData);
	}

	remove(id: string) {
		this.revenueData = this.revenueData.filter(x => x.id !== id);
	}
}
