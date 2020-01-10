import { UserTypeEditModalComponent } from './components/user-type-edit-modal/user-type-edit-modal.component';
import { UserType } from './../../../core/models/Purchase/user-type';
import { UserTypeAddModalComponent } from './components/user-type-add-modal/user-type-add-modal.component';
import { UserTypeService } from './../../../core/services/Purchase/user-type.service';
import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';

@Component({
  selector: 'app-user-type',
  templateUrl: './user-type.component.html',
  styleUrls: ['./user-type.component.less']
})
export class UserTypeComponent implements OnInit {

	userTypes: any = [];
	loading: boolean = false;
  constructor(private modalSvc: NzModalService, private userTypeService: UserTypeService,private message: NzMessageService) { }

  ngOnInit() {
		this.getAllUserType();
  }

	onModalCancel() {
		// this.ngOnInit();
			this.getAllUserType();
			// console.log("hi")
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add User Type",
			nzContent: UserTypeAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
		//	nzOnCancel: ()=> this.onModalCancel,
			nzComponentParams: {

			},

			nzFooter: null
		});


	}

	onEdit(userType: UserType) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit User Type",
			nzContent: UserTypeEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {

					usrType: userType

			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);

	}

	public getAllUserType(){
		this.userTypeService.getAllUserType().subscribe(
				data => {
						this.userTypes = data;
						// console.log("data")


				},
				error => {
					if(error['status']=='404'){
						this.userTypes = [];
					}
						else if(error.error){
						this.userTypes = error.error;
				}

					else{
						this.loading = true;
					}

				}
		);
	}

	public deleteUserType(id: number){
		this.userTypeService.deleteUserType(id).subscribe(
			data =>{
				this.message.create('success', `User Type Deleted Successfully!`);
				this.getAllUserType();
			},
			error=> {
				this.message.create('error', `User Type Not Deleted!`);
				this.getAllUserType();
			}
		);

	}
}
