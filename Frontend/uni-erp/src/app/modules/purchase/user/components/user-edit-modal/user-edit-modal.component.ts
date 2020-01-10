import { UserTypeService } from './../../../../../core/services/Purchase/user-type.service';
import { UserService } from './../../../../../core/services/Purchase/user.service';
import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/core/models/Purchase/user';
import { NzModalService, NzModalRef, NzMessageService } from 'ng-zorro-antd';
import { AuthLvlAddModalComponent } from '../../../authorize-lvl/components/auth-lvl-add-modal/auth-lvl-add-modal.component';
import { AuthorizeSignatoryService } from 'src/app/core/services/Purchase/authorize-signatory.service';
import { RoleService } from 'src/app/core/services/Purchase/role.service';
import { DepartmentService } from 'src/app/core/services/Purchase/department.service';

@Component({
  selector: 'app-user-edit-modal',
  templateUrl: './user-edit-modal.component.html',
	styleUrls: ['./user-edit-modal.component.less'],

})
export class UserEditModalComponent implements OnInit {

	@Input() usr: User;
	authSignatories: any = [];
	departments: any = [];
	roles: any = [];
	userTypes: any = [];
	passwordVisible = false;
	constructor(private modalSvc: NzModalService,
		private modalRef: NzModalRef<AuthLvlAddModalComponent>,
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

	onCancel() {
		this.modalRef.triggerCancel();
	}

	updateUser(){
		this.userService.updateUser(this.usr.id, this.usr).subscribe(
			data => {

				this.message.create('success', `User Updated Successfully!`,{nzDuration:3000});
				// console.log(JSON.parse(JSON.stringify(this.authLvl)))
				this.modalRef.triggerOk();
			},
			error => {
				this.message.create('error', `User Not Updated!`,{nzDuration:3000});
			}
		);

		// this.modalRef.close();
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
