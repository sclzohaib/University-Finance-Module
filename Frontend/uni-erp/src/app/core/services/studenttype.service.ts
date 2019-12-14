import { Injectable } from '@angular/core';
import { StudentType } from '../models/student.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class StudenttypeService {

	private studentTypes: Array<StudentType> = [];
	data: BehaviorSubject<StudentType[]> = new BehaviorSubject([]);

	constructor() {
		this.add({
			name: "Private"
		});
		this.add({
			name: "Overseas"
		});
		this.add({
			name: "Government Affiliate"
		});
		this.add({
			name: "On Campus"
		});
	}

	add(stType: StudentType) {
		this.studentTypes = [
			...this.studentTypes,
			stType
		];
		this.data.next(this.studentTypes);
	}

	edit(id: number, name: string) {
		this.studentTypes[id].name = name;
		this.data.next(this.studentTypes);
	}

	remove(name: string) {
		this.studentTypes = this.studentTypes.filter(x => x.name !== name);
		this.data.next(this.studentTypes);
	}
}
