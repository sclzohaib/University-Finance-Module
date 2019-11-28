import { Injectable } from '@angular/core';
import { FeeType } from '../models/feetype.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class FeetypeService {

	feetypes: Array<FeeType> = [];
	data: BehaviorSubject<FeeType[]> = new BehaviorSubject([]);

	constructor() { }

	add(feetype: FeeType) {
		this.feetypes = [
			...this.feetypes,
			feetype
		];
		this.data.next(this.feetypes);
	}

	edit(id: number, feetype: string, revenueHead: string, studentTypes: Array<string>, classes: Array<string>, parts: Array<string>, amount: number) {
		// const prev = this.feetypes[id]; // for server
		this.feetypes[id].feetype = feetype;
		this.feetypes[id].revenueHead = revenueHead;
		this.feetypes[id].studentTypes = studentTypes;
		this.feetypes[id].classes = classes;
		this.feetypes[id].parts = parts;
		this.feetypes[id].amount = amount;
		this.data.next(this.feetypes);
	}

	remove(feetype: string) {
		this.feetypes = this.feetypes.filter(x => x.feetype !== feetype);
		this.data.next(this.feetypes);
	}
}
