import { Component, OnInit, OnDestroy } from '@angular/core';
import { NzModalService } from 'ng-zorro-antd';
import { StdEditmodalComponent } from './components/std-editmodal/std-editmodal.component';
import { StudentType } from 'src/app/core/models/student.model';
import { StudenttypeService } from 'src/app/core/services/studenttype.service';
import { Subscription } from 'rxjs';
import { StdAddmodalComponent } from './components/std-addmodal/std-addmodal.component';

@Component({
	selector: 'app-student-type',
	templateUrl: './student-type.component.html',
	styleUrls: ['./student-type.component.less']
})
export class StudentTypeComponent implements OnInit, OnDestroy {

	studentTypes: Array<StudentType> = [];
	private subscription: Subscription;

	constructor(private modalService: NzModalService, private stTypeSvc: StudenttypeService) { }

	ngOnInit() {
		this.subscription = this.stTypeSvc.data.subscribe(x => this.studentTypes = x);
	}


	deleteRow(data: string) {
		this.stTypeSvc.remove(data);
	}

	onModalCancel() {

	}

	afterAdd = (value: string) => {
		if (value) this.stTypeSvc.add({
			name: value
		});
	}

	afterEdit = (value: { id: number, name: string }) => {
		if (value) this.stTypeSvc.edit(value.id, value.name)
	}

	onAdd() {
		const modal = this.modalService.create({
			nzTitle: "Add Student Type",
			nzContent: StdAddmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				studentTypes: this.studentTypes
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(i: number, data: string) {
		const modal = this.modalService.create({
			nzTitle: "Edit Student Type",
			nzContent: StdEditmodalComponent,
			nzOnCancel: this.onModalCancel,
			nzComponentParams: {
				id: i,
				name: data,
				studentTypes: this.studentTypes
			},
			nzFooter: null
		});
		modal.afterClose.subscribe(this.afterEdit);
	}

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}

}
