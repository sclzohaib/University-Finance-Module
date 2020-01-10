import { UniversityService } from './../../../../../core/services/Purchase/university.service';
import { Component, OnInit, Input } from '@angular/core';
import { Department } from 'src/app/core/models/Purchase/department';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { DepartmentService } from 'src/app/core/services/Purchase/department.service';

@Component({
  selector: 'app-depart-edit-modal',
  templateUrl: './depart-edit-modal.component.html',
  styleUrls: ['./depart-edit-modal.component.less']
})
export class DepartEditModalComponent implements OnInit {

	@Input() dept: Department;
	universities: any = [];
  constructor(private departmentService: DepartmentService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService,
		private uniService: UniversityService) { }

  ngOnInit() {
		this.getAllUniversity();
  }
	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateDepartment(){
		this.departmentService.updateDepartment(this.dept.id, this.dept).subscribe(
			data => {
				this.message.create('success', `Department Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `Department Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
	}

	public getAllUniversity(){
		this.uniService.getAllUniversity().subscribe(
				data => {
						this.universities = data;
						// console.log(data)


				},
				error => {
					if(error['status']=='404'){
						this.universities = [];
					}
						else if(error.error){
						this.universities = error.error;
				}
				}
		);
	}
}
