import { Injectable } from '@angular/core';
import { Department } from '../models/department.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class DepartmentService {

	private departments: Array<Department> = [];
	data: BehaviorSubject<Department[]> = new BehaviorSubject([]);

	constructor() {
		this.add({
			code: '009',
			name: 'Computer Science'
		});
		this.add({
			code: '103',
			name: 'Teacher Education'
		});
	}

	add(dept: Department) {
		this.departments = [
			...this.departments,
			dept
		];
		this.data.next(this.departments);
	}

	edit(dept: Department) {
		this.departments[this.departments.findIndex(x => x.code === dept.code)].name = dept.name;
		this.data.next(this.departments);
	}

	remove(depCode: string) {
		this.departments = this.departments.filter(d => d.code !== depCode);
		this.data.next(this.departments);
	}
}
