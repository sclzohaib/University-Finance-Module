import { Component, OnInit, OnDestroy } from '@angular/core';
import { Class } from "../../../../core/models/class.model";
import { NzModalService } from 'ng-zorro-antd';
import { ClEditmodalComponent } from './components/cl-editmodal/cl-editmodal.component';
import { Subscription } from 'rxjs';
import { ClassService } from 'src/app/core/services/class.service';
import { ClAddmodalComponent } from './components/cl-addmodal/cl-addmodal.component';

@Component({
	selector: 'app-class-page',
	templateUrl: './class-page.component.html',
	styleUrls: ['./class-page.component.less']
})
export class ClassPageComponent implements OnInit, OnDestroy {

	classes: Array<Class> = [];
	private subscription: Subscription;

	constructor(private modalSvc: NzModalService, private clsSvc: ClassService) { }

	ngOnInit() {
		this.subscription = this.clsSvc.data.subscribe(x => this.classes = x);
	}

	afterAdd = (value: string) => {
		if(value)	this.clsSvc.add({
			name: value
		});
	}

	afterEdit = (value: { id: number, name: string }) => {
		if (value) this.clsSvc.edit(value.id, value.name);
	}

	deleteRow(data: string) {
		this.clsSvc.remove(data);
	}

	onModalCancel() {

	}

	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Class",
			nzContent: ClAddmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				classes: this.classes
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(i: number, data: string) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Class",
			nzContent: ClEditmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				id: i,
				name: data,
				classes: this.classes
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterEdit);
	}

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}
}