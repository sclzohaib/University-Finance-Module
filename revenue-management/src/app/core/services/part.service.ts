import { Injectable } from '@angular/core';
import { Part } from '../models/part.model';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PartService {

	private parts: Array<Part> = [];
	data: BehaviorSubject<Part[]> = new BehaviorSubject([]);

	constructor() {
		this.add({
			name: "Part One"
		});
		this.add({
			name: "Part Two"
		});
	}

	add(pt: Part) {
		this.parts = [
			...this.parts,
			pt
		];
		this.data.next(this.parts);
	}
	
	edit(id: number, name: string) {
		this.parts[id].name = name;
		this.data.next(this.parts);
	}
	
	remove(name: string) {
		this.parts = this.parts.filter(x => x.name !== name);
		this.data.next(this.parts);
	}
}
