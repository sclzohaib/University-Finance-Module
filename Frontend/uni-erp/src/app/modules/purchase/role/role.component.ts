import { RoleService } from './../../../core/services/Purchase/role.service';
import { Component, OnInit } from '@angular/core';
import { NzModalService, NzMessageService } from 'ng-zorro-antd';
import { RoleAddModalComponent } from './components/role-add-modal/role-add-modal.component';
import { RoleEditModalComponent } from './components/role-edit-modal/role-edit-modal.component';
import { Role } from 'src/app/core/models/Purchase/role';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.less']
})
export class RoleComponent implements OnInit {
	roles: any = [];
	loading: boolean = false;
  constructor(private modalSvc: NzModalService,
		private roleService: RoleService,
		private message: NzMessageService) { }

  ngOnInit() {
		this.getAllRole();
  }
  onModalCancel() {
		this.getAllRole();
	}
	onAdd() {
		const modal = this.modalSvc.create({
			nzTitle: "Add Role",
			nzContent: RoleAddModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				// feeTypes: this.feeTypes
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterAdd);
	}

	onEdit(role: Role) {
		const modal = this.modalSvc.create({
			nzTitle: "Edit Role",
			nzContent: RoleEditModalComponent,
			nzOnCancel: this.onModalCancel.bind(this),
			nzOnOk: this.onModalCancel.bind(this),
			nzComponentParams: {
				rol: role
			},
			nzFooter: null
		});
		// modal.afterClose.subscribe(this.afterEdit);
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

					else{
						this.loading = true;
					}

				}
		);
	}

	public deleteRole(id: number){
		this.roleService.deleteRole(id).subscribe(
			data =>{
				this.message.create('success', `Role Deleted Successfully!`);
				this.getAllRole();
			},
			error=> {
				this.message.create('error', `Role Not Deleted!`);
				this.getAllRole();
			}
		);

	}
}
