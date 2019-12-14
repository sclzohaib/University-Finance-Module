import { Component, OnInit, OnDestroy } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { EditmodalComponent } from "./components/editmodal/editmodal.component";
import { Department } from 'src/app/core/models/department.model';
import { DepartmentService } from 'src/app/core/services/department.service';
import { Subscription } from 'rxjs';
import { AddmodalComponent } from './components/addmodal/addmodal.component';

@Component({
	selector: 'app-department-page',
	templateUrl: './department-page.component.html',
	styleUrls: ['./department-page.component.less']
})
export class DepartmentPageComponent implements OnInit, OnDestroy {

	departments: Array<Department> = [];
	private subscription: Subscription;

	constructor(private modalService: NzModalService, private deptSvc: DepartmentService) {
		// this.addRow(["5503", "Computer Science"]);
	}

	ngOnInit() {
		this.subscription = this.deptSvc.data.subscribe(x => this.departments = x);
	}

	deleteRow(code: string) {
		this.deptSvc.remove(code);
	}
	
	onModalCancel() {
		
	}
	
	afterAdd = (value: Array<string>) => {
		if(value) this.deptSvc.add({ code: value[0], name: value[1] });
	}
	
	onOkEdit = (value: Department) => {
		if (value) this.deptSvc.edit(value);
	}

	onAdd() {
		const modal = this.modalService.create({
			nzTitle: "Add Department",
			nzContent: AddmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				departments: this.departments
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(data: Department) {
		const modal = this.modalService.create({
			nzTitle: "Edit Department",
			nzContent: EditmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				name: data.name,
				code: data.code,
				departments: this.departments
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.onOkEdit);
	}

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}
}