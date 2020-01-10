import { Component, OnInit } from '@angular/core';
import { Department } from 'src/app/core/models/Purchase/department';
import { DepartmentService } from 'src/app/core/services/Purchase/department.service';
import { UniversityService } from 'src/app/core/services/Purchase/university.service';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';

@Component({
  selector: 'app-depart-add-modal',
  templateUrl: './depart-add-modal.component.html',
  styleUrls: ['./depart-add-modal.component.less']
})
export class DepartAddModalComponent implements OnInit {

	universities: any = [];
	department: Department = new Department();
  constructor(private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService,
		private departmentService: DepartmentService,
		private uniService: UniversityService) { }

  ngOnInit() {
		this.getUniversity();
	}

	saveDepartment(){
		// console.log(this.authLvl);
		this.departmentService.saveDepartment(this.department).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `Department Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Signatory Successfully Added!`);
				this.message.create('error', `Department Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

public getUniversity(){
	this.uniService.getAllUniversity().subscribe(
			data => {
					this.universities = data;


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
