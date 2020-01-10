import { Component, OnInit } from '@angular/core';
import { DepartmentService } from 'src/app/core/services/Purchase/department.service';
import { User } from 'src/app/core/models/Purchase/user';
import { NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { AuthorizeSignatoryService } from 'src/app/core/services/Purchase/authorize-signatory.service';
import { RoleService } from 'src/app/core/services/Purchase/role.service';
import { UserService } from 'src/app/core/services/Purchase/user.service';
import { UserTypeService } from 'src/app/core/services/Purchase/user-type.service';

@Component({
  selector: 'app-user-add-modal',
  templateUrl: './user-add-modal.component.html',
  styleUrls: ['./user-add-modal.component.less']
})
export class UserAddModalComponent implements OnInit {

	user: User = new User();
	authSignatories: any = [];
	departments: any = [];
	roles: any = [];
	userTypes: any = [];
	passwordVisible = false;
  constructor(private modalRef: NzModalRef<AuthLvlAddModalComponent>,
		private message: NzMessageService,
		private authSignService: AuthorizeSignatoryService,
		private departmentService: DepartmentService,
		private roleService: RoleService,
		private userService: UserService,
		private userTypeService: UserTypeService) { }

  ngOnInit() {
		this.getAllAuthSign();
		this.getAllDepartments();
		this.getAllRole();
		this.getAllUserType();
	}

	saveUser(){
		// console.log(this.minorHead);
		this.userService.saveUser(this.user).subscribe(
			data => {
				// console.log(data['status']+"data");
				this.message.create('success', `User Successfully Added!`,{nzDuration:3000});
				this.modalRef.triggerOk();
			},
			error => {
				// console.log(error['status']+"error");
				// console.log(error);
				// this.message.create('success', `Authorize Signatory Successfully Added!`);
				this.message.create('error', `User Not Added!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();

}
onCancel() {
	this.modalRef.triggerCancel();
}

	//get all user types
	public getAllUserType(){
		this.userTypeService.getAllUserType().subscribe(
				data => {
						this.userTypes = data;


				},
				error => {
					if(error['status']=='404'){
						this.userTypes = [];
					}
						else if(error.error){
						this.userTypes = error.error;
				}



				}
		);
	}

	public getAllAuthSign(){
		this.authSignService.getAllAuthSign().subscribe(
				data => {
						this.authSignatories = data;


				},
				error => {
					if(error['status']=='404'){
						this.authSignatories = [];
					}
						else if(error.error){
						this.authSignatories = error.error;
				}



				}
		);
	}

	public getAllDepartments(){
		this.departmentService.getAllDepartment().subscribe(
				data => {
						this.departments = data;


				},
				error => {
					if(error['status']=='404'){
						this.departments = [];
					}
						else if(error.error){
						this.departments = error.error;
				}



				}
		);
	}

	public getAllRole(){
		this.roleService.getAllRole().subscribe(
				data => {
						this.roles = data;
						// console.log(data);


				},
				error => {

					if(error['status']=='404'){
						this.roles = [];
					}
						else if(error.error){
						// this.roles = error.error;
						this.roles = [];

						error.error.map(r=>{

							this.roles.push({
								id : r.id,
								title : r.title,
								permissions: r.permissions,
								permis:  r.permissions.map(p=>" "+p.title)
							});

						});

				}



				}
		);
	}

}
