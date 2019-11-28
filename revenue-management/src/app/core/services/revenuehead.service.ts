import { Injectable } from '@angular/core';
import { RevenueHead } from '../models/revenuehead.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class RevenueheadService {

	private revenueHeads: Array<RevenueHead> = [];
	data: BehaviorSubject<RevenueHead[]> = new BehaviorSubject([]);

	constructor() {
		this.add({
			code: '5502',
			name: 'Examination Fee'
		});
		this.add({
			code: '5503',
			name: 'Degree Fee'
		});
	}

	add(revHead: RevenueHead) {
		this.revenueHeads = [
			...this.revenueHeads,
			revHead
		];
		this.data.next(this.revenueHeads);
	}

	edit(revHead: RevenueHead) {
		this.revenueHeads[this.revenueHeads.findIndex(x => x.code === revHead.code)].name = revHead.name;
		this.data.next(this.revenueHeads);
	}

	remove(revCode: string) {
		this.revenueHeads = this.revenueHeads.filter(d => d.code !== revCode);
		this.data.next(this.revenueHeads);
	}
}
