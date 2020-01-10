import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { DepartAddModalComponent } from './components/depart-add-modal/depart-add-modal.component';
import { DepartEditModalComponent } from './components/depart-edit-modal/depart-edit-modal.component';
import { DepartmentService } from 'src/app/core/services/Purchase/department.service';
import { Department } from 'src/app/core/models/Purchase/department';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.less']
})
export class DepartmentComponent implements OnInit {

	departments: any = [];
	loading: boolean = false;
	constructor(private modalSvc: NzModalService,
		private departmentService: DepartmentService,
		private message: NzMessageService) { }

  ngOnInit() {
		this.getAllDepartments();
  }
  onModalCancel() {
		this.getAllDepartments();
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Department",
			nzContent: DepartAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				// feeTypes: this.feeTypes
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(department: Department) {

		const modal = this.modalSvc.create({
			nzTitle: "Edit Department",
			nzContent: DepartEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				dept: department
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);
	}

	public getAllDepartments(){
		this.departmentService.getAllDepartment().subscribe(
				data => {
						this.departments = data;


				},
				error => {
					// console.log(error);
					if(error['status']=='404'){
						this.departments = [];
					}
						else if(error.error){
						this.departments = error.error;
				}

					else{
						this.loading = true;
					}

				}
		);
	}

	public deleteDepartment(id: number){
		this.departmentService.deleteDepartment(id).subscribe(
			data =>{
				this.message.create('success', `Department Deleted Successfully!`);
				this.getAllDepartments();
			},
			error=> {
				this.message.create('error', `Department Not Deleted!`);
				this.getAllDepartments();
			}
		);

	}
}
