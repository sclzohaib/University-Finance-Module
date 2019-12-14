import { Injectable } from '@angular/core';
import { Class } from '../models/class.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class ClassService {

	private classes: Array<Class> = [];
	data: BehaviorSubject<Class[]> = new BehaviorSubject([]);

	constructor() {
		this.add({
			name: "MS"
		});
		this.add({
			name: "MPhil"
		});
		this.add({
			name: "BS"
		});
	}

	add(cls: Class) {
		this.classes = [
			...this.classes,
			cls
		];
		this.data.next(this.classes);
	}

	edit(id: number, name: string) {
		this.classes[id].name = name;
		this.data.next(this.classes);
	}

	remove(name: string) {
		this.classes = this.classes.filter(x => x.name !== name);
		this.data.next(this.classes);
	}
}
