import { User } from './../../../core/models/Purchase/user';
import { UserService } from './../../../core/services/Purchase/user.service';
import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { UserAddModalComponent } from './components/user-add-modal/user-add-modal.component';
import { UserEditModalComponent } from './components/user-edit-modal/user-edit-modal.component';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.less']
})
export class UserComponent implements OnInit {

	users: any = [];
	loading: boolean = false;
  constructor(private modalSvc: NzModalService,
		private userService: UserService,
		private message: NzMessageService) { }

  ngOnInit() {
		this.getAllUser();
  }
  onModalCancel() {
		this.getAllUser();
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add User",
			nzContent: UserAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				// feeTypes: this.feeTypes
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(user: User) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit User",
			nzContent: UserEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				usr: user
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);
	}

	public getAllUser(){
		this.userService.getAllUser().subscribe(
				data => {
						this.users = data;
						// console.log(data);


				},
				error => {

					if(error['status']=='404'){
						this.users = [];
					}
						else if(error.error){
						// this.roles = error.error;
						this.users = [];
							// console.log(error.error)
						error.error.map(u=>{

							this.users.push({
								id: u.id,
								name: u.name,
								email: u.email,
								password : u.password,
								status: u.status,
								address: u.address,
								contactNo : u.contactNo,
								department: u.department,
								roles: u.roles,
								userType: u.userType,
								authorizeSignatory: u.authorizeSignatory,
								rol:  u.roles.map(r=>" "+r.title)
							});

						});

				}

					else{
						this.loading = true;
					}

				}
		);
	}

	public deleteUser(id: number){
		this.userService.deleteUser(id).subscribe(
			data =>{
				this.message.create('success', `User Deleted Successfully!`);
				this.getAllUser();
			},
			error=> {
				this.message.create('error', `User Not Deleted!`);
				this.getAllUser();
			}
		);

	}

}
